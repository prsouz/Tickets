package com.io.ticket.usecase;

import com.google.zxing.WriterException;

import java.awt.image.BufferedImage;

public interface QrCodeImageGenerator {
    BufferedImage getQrCode(String code) throws WriterException;
}
