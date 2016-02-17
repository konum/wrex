package org.wrex.utils;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Class for sending emails using a new threadthread using java mail. Can be greatly improved but it does its job
 * @author ggefaell
 *
 */
public class SendMail {
	
	
	public static void send(String dest, String subject, List<String> body ) {
		Runnable send = new SendMailThread(dest, subject, body);
		Thread t1 = new Thread(send);
		t1.start();
	} 
	
	static class SendMailThread implements Runnable{
		public SendMailThread(String dest, String subject, List<String> body){
			this.dest = dest;
			this.body = body;
			this.subject = subject;
		}
		String dest; 
		String subject; 
		List<String> body;
		@Override
		public void run() {
			Properties props = System.getProperties();
			props.put("mail.smtp.host", "smpt.yourhost.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");

			Session session = Session.getInstance(props,
					  new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication("yourmail@yourhost.com", "userPassword");
						}
					  });

			System.out.println("Port: " + session.getProperty("mail.smtp.port"));

			// Create the email addresses involved
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress("Wrex Admin <yourmail@yourhost.com>"));
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(dest));
				message.setSubject(subject);
				StringBuilder msg = new StringBuilder();
				for (String string : body) {
					msg.append(string);
				}
				message.setContent(msg.toString(), "text/html; charset=utf-8");

				// Send message
				Transport.send(message);

			} catch (AddressException e) {
				e.printStackTrace();
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		
	}

}
