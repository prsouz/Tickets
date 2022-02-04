package com.io.ticket.usecase;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component
public class QrCodeImageGeneratorImpl implements QrCodeImageGenerator {


    @Override
    public BufferedImage getQrCode(String code) throws WriterException {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(code, BarcodeFormat.QR_CODE,200, 200);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
