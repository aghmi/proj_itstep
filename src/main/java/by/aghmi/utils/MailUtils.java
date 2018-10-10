package by.aghmi.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtils {

	public static void send(final String from, final String pass, String to, String subject, String msg){
		Session session = Session.getInstance(AppSettings.getSettings().getProperties(),
		          new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		                return new PasswordAuthentication(from, pass);
		            }
		          });
		  try {
	        	
	        	Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
				message.setSubject(subject);
				message.setText(msg);
				
				Transport.send(message);
				System.out.println("SEND MSG TO :" + to);
				
			} catch (AddressException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	public static void main(String[] args) {
		
		String fromEmail = AppSettings.getSettings().getProp("mailUser");
		String pass = AppSettings.getSettings().getProp("mailPass");
        String msg = "Hello from JAVA APP!";
        String toEmail = "test@gmail.com"; 
        String subject = "This is not SPAM!";
        
       
        send(fromEmail, pass, toEmail, subject, msg);
		
       
      
        
	}

}
