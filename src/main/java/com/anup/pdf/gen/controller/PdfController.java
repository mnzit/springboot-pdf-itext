package com.anup.pdf.gen.controller;

import com.anup.pdf.gen.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;


/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@RestController
public class PdfController {

    private final PDFService pdfService;

    String textToPrint = "Spanish ā é á Á \u0101 \u00E9 \u00E1 \u00C1";


    @Autowired
    public PdfController(PDFService pdfService) {
        this.pdfService = pdfService;
    }


    @RequestMapping(
            value = "/download/pdf",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_PDF_VALUE
    )
    public ResponseEntity<InputStreamResource> report() {

        String fileName = "plain.pdf";

        ByteArrayInputStream byteArrayInputStream = pdfService
                .generateInputStream(fileName, textToPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=" + fileName);

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(byteArrayInputStream));
    }

}
