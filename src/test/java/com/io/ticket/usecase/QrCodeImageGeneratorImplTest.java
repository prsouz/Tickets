package com.io.ticket.usecase;

import com.google.zxing.WriterException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.awt.image.BufferedImage;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class QrCodeImageGeneratorImplTest {

    @InjectMocks
    QrCodeImageGeneratorImpl qrCodeImage;

    @Test
    void qrCodeGeneratorTest() throws WriterException {
        String baseString = UUID.randomUUID().toString();
        BufferedImage received = qrCodeImage.getQrCode(baseString);
        assertEquals(BufferedImage.class, received.getClass());
    }
}