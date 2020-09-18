/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.processor;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.extern.log4j.Log4j2;
import mailer.entities.EmailConfigs;
import mailer.entities.EmailMessage;

/**
 *
 * @author amit
 */
@Log4j2
public class EmailProcessor {

    public static String sendEmail(final EmailConfigs emailConfigs, final EmailMessage emailMessage) {
        String result = "success";
        Properties props = new Properties();
        props.put("mail.smtp.host", emailConfigs.getSmtpServer());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", emailConfigs.getSmtpPort());

        try {
            Session session = Session.getDefaultInstance(props, null);
            session.setDebug(true);

            MimeMessage msg = new MimeMessage(session);
            msg.setSubject(emailMessage.getSubject());
            msg.setText(emailMessage.getMessageBody());

            msg.setFrom(new InternetAddress(emailConfigs.getFromMail()));

            emailMessage.getToEmails().forEach(email -> {
                try {
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                } catch (MessagingException ex) {
                    log.error(ex);
                }
            });
            msg.saveChanges();
            Transport transport = session.getTransport("smtp");
            transport.connect(emailConfigs.getUserName(), emailConfigs.getPassword());

            transport.sendMessage(msg, msg.getAllRecipients());
            transport.close();

        } catch (MessagingException ex) {
            result = ex.getMessage();
            log.error(ex);
        }
        return result;
    }
}
