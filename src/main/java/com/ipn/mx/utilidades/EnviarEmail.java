package com.ipn.mx.utilidades;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author levi1
 */
public class EnviarEmail {
    public void enviarCorreo(String destinatario, String asunto, String mensaje){
        Properties propiedades = new Properties();
        propiedades.setProperty("mail.smtp.auth", "true");
        propiedades.setProperty("mail.smtp.starttls.enable", "true");
        propiedades.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedades.setProperty("mail.smtp.port", "587");
        propiedades.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        propiedades.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        //propiedades.setProperty("mail.smtp.user", "correo.ipn.mx@gmail.com");
        //propiedades.setProperty("mail.smtp.password", "Qwerty12340");
        
        Session session = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("cafeteria.web.levi@gmail.com", "uuoqubfamgbasbjf");
            }
        });
        
        Message elMensaje = new MimeMessage(session);
        
        try {
            elMensaje.setFrom(new InternetAddress("correox@gmail.com"));
            elMensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            //elMensaje.addRecipient(Message.RecipientType.CC, new InternetAddress(destinatario));
            //elMensaje.addRecipient(Message.RecipientType.BCC, new InternetAddress(destinatario));
            
            elMensaje.setSubject(asunto);
            elMensaje.setContent("Bienvenido :" + destinatario + ", en breve recibira ...", "text/html");
            Transport.send(elMensaje);
            System.out.println("enviado ok");
            
        } catch (AddressException ex) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        EnviarEmail ee = new EnviarEmail();
        ee.enviarCorreo("levi13basilio@gmail.com", "Hola", "Hola x2");
    }
}
