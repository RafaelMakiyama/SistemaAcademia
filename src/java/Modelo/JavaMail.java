/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

    
public class JavaMail {
   
            
    
    public void sendEmail(String email, String subject, String msg) {
      // Recipient's email ID needs to be mentioned.
      String to = email;
      

      // Conta que vai enviar os e-mails
      String from = "itrainnersistema@gmail.com";
      final String username = "itrainnersistema@gmail.com";//change accordingly
      final String password = "rafaeleruan";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      
      // Configurações de autenticação do  servidor
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
         new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(username, password);
	   }
         });

      try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Assunto do E-mail
	   message.setSubject(subject);
	
	   // Conteúdo do E-mail
	   message.setText(msg);

	   // Send message
	   Transport.send(message);

	   

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}
