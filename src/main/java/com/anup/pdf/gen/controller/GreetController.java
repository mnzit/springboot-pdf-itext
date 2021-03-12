package com.anup.pdf.gen.controller;

import com.anup.pdf.gen.response.Greet;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Manjit Shakya
 * @email manjit.shakya@f1soft.com
 */
@RestController
public class GreetController {


    @RequestMapping(
            value = "/greet",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Greet> report() {

        Greet greet = new Greet("Welcome", "Welcome to out application");
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(greet);
    }

}
