package com.io.ticket.ports.in;

import com.google.zxing.WriterException;
import com.io.ticket.models.TicketDataModel;
import com.io.ticket.models.TicketTypeEnum;
import com.io.ticket.ports.in.transferObject.*;
import com.io.ticket.ports.in.transferObject.factory.CreatedTicketResponseFactory;
import com.io.ticket.usecase.TicketProcessUseCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;


@Log4j2
@RestController
@ControllerAdvice
public class ETicketRestControllerImpl implements ETicketRestController{

    @Autowired
    TicketProcessUseCase ticketProcessUseCase;

    @Autowired
    CreatedTicketResponseFactory createdTicketResponseFactory;

    @Override
    @ApiOperation(value = "Create new tickets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket Created"),
            @ApiResponse(code = 403, message = "Whitout permission to perform this action."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/create_ticket")
    public ResponseEntity<CreatedTicketResponse> createTicket(@Valid @RequestBody CreateTicketRequest createTicketRequest) throws NoSuchAlgorithmException, WriterException {

        log.info("Received ticket request: " + createTicketRequest);

        return processTicketRequest(createTicketRequest);

    }

    @Override
    @ApiOperation(value = "Get created tickets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Ticket Returned"),
            @ApiResponse(code = 403, message = "Whitout permission to perform this action."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/get_ticket")
    public ResponseEntity<CreatedTicketResponse> getTicket(String TokenId) {
        return new ResponseEntity<CreatedTicketResponse>(HttpStatus.OK);
    }

    @Override
    @ApiOperation(value = "Update Balances")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Balance Updated"),
            @ApiResponse(code = 403, message = "Whitout permission to perform this action."),
            @ApiResponse(code = 500, message = "Exception"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, path = "/balance_update")
    public ResponseEntity<BalanceUpdateResponse> balanceUpdate(@Valid @RequestBody BalanceUpdateRequest balanceUpdateRequest) {
        return null;
    }


    private ResponseEntity<CreatedTicketResponse> processTicketRequest(CreateTicketRequest createTicketRequest) throws NoSuchAlgorithmException, WriterException {

        TicketDataModel ticketDataModel = new TicketDataModel();
        ticketDataModel.setAccountID(createTicketRequest.getAccountID());
        ticketDataModel.setTicketType(TicketTypeEnum.getEnum(createTicketRequest.getTicketType()));

        TicketDataModel returnedTicket = ticketProcessUseCase.processTicketGenerateRequest(ticketDataModel);

        CreatedTicketResponse ticketResponse = createdTicketResponseFactory.createTicketResponseFromTicketDataModel(returnedTicket);

        ResponseEntity<CreatedTicketResponse> responseEntity = new ResponseEntity<>(ticketResponse, HttpStatus.OK);
        log.info("Response Entity to return:" + responseEntity);

        return responseEntity;
    }
}
