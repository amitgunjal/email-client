/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.service.impl;

import mailer.entities.EmailConfigs;
import mailer.entities.EmailMessage;
import mailer.processor.EmailProcessor;
import mailer.service.EmailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 *
 * @author amit
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Value("${login.username}")
    private String userName;

    @Value("${login.password}")
    private String password;

    @Value("${settings.fromMail}")
    private String fromMail;

    @Value("${settings.smtp.port}")
    private String smtpPort;

    @Value("${settings.smtp.server}")
    private String smtpServer;

    @Override
    public String makeEmail(final EmailMessage message) {
        final EmailConfigs emailConfigs = new EmailConfigs();
        emailConfigs.setFromMail(fromMail);
        emailConfigs.setUserName(userName);
        emailConfigs.setPassword(password);
        emailConfigs.setSmtpPort(smtpPort);
        emailConfigs.setSmtpServer(smtpServer);
        return EmailProcessor.sendEmail(emailConfigs, message);
    }

}
