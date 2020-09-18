/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.service;

import mailer.entities.EmailMessage;

/**
 *
 * @author amit
 */
public interface EmailService {

    public String makeEmail(final EmailMessage message);
}
