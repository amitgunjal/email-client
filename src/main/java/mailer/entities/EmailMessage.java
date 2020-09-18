/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.entities;

import java.util.List;
import lombok.Data;

/**
 *
 * @author amit
 */
@Data
public class EmailMessage {

    private List<String> toEmails;
    private String subject;
    private String messageBody;
}
