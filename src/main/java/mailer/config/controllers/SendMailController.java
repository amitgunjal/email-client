/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.config.controllers;

import mailer.entities.EmailMessage;
import mailer.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amit
 */
@RestController
public class SendMailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/hello")
    public String hello() {
        return "Hi";
    }

    @PostMapping(path = "/mail", consumes = "application/json", produces = "application/json")
    public String sendEmail(@RequestBody EmailMessage message) {
        return emailService.makeEmail(message);
    }

    @GetMapping("/")
    public String main() {
        return "Unauthorised"; //view
    }
}
