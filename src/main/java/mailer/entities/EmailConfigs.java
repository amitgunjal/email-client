/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.entities;

import lombok.Data;

/**
 *
 * @author amit
 */
@Data
public class EmailConfigs {

    private String smtpPort;
    private String smtpServer;
    private String fromMail;
    private String userName;
    private String password;

}
