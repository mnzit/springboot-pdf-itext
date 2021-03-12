package com.anup.pdf.gen.service.impl;

import com.anup.pdf.gen.service.PDFService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
public class PDFServiceImpl implements PDFService {

    @Override
    public void generatePlainPdf(String pathAndFileName, String text) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream((pathAndFileName)));
        } catch (DocumentException | FileNotFoundException e) {
            System.out.println("Error Getting Document Instance");
        }

        document.open();

        try {
            BaseFont baseFone =
                    BaseFont.createFont("D:\\Downloads\\arial-unicode-ms\\ArialUnicodeMS.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFone, 10);
            Paragraph p = new Paragraph(text, font);
            document.add(p);
        } catch (DocumentException | IOException e) {
            System.out.println("Error Modify Document");
        }
        document.close();
    }

    @Override
    public ByteArrayInputStream generateInputStream(String pathAndFileName, String text) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, out);
        } catch (DocumentException e) {
            System.out.println("Error Getting Document Instance");
        }

        document.open();

        try {
            BaseFont baseFone =
                    BaseFont.createFont("D:\\Downloads\\arial-unicode-ms\\ArialUnicodeMS.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFone, 10);
            Paragraph p = new Paragraph(text, font);
            document.add(p);
        } catch (DocumentException | IOException e) {
            System.out.println("Error Modify Document");
        }
        document.close();

        return new ByteArrayInputStream((out.toByteArray()));

    }


}
