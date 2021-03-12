package com.anup.pdf.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootPdfGeneratorApplication {

//    private final PDFService pdfService;
//
//    @Autowired
//    public SpringBootPdfGeneratorApplication(PDFService pdfService) {
//        this.pdfService = pdfService;
//    }

//    String textToPrint = "Spanish ā é á Á \\u0101 \\u00E9 \\u00E1 \\u00C1";

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPdfGeneratorApplication.class, args);
    }

//    @Bean
//    CommandLineRunner generatePdf() {
//        return strings -> pdfService.generatePlainPdf("plain.pdf", textToPrint);
//    }

}