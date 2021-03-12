package com.anup.pdf.gen.service;

import java.io.ByteArrayInputStream;

public interface PDFService {

    void generatePlainPdf(String pathAndFileName, String text);

    ByteArrayInputStream generateInputStream(String pathAndFileName, String text);
}
