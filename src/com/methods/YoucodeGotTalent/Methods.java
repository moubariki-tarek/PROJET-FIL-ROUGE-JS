package com.methods.YoucodeGotTalent;

import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Methods {
	

	public Long randomId() {
		Random r = new Random();
		Long id = Math.abs(r.nextLong());
		return id;
	}

	public void SendMail(String server,String port,String username,String password,String to,
			String subject,String msg) throws AddressException, MessagingException {
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", "true");
		prop.put("mail.smtp.host", server);
		prop.put("mail.smtp.port", port);
		Session session = Session.getInstance(prop, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(username, password);
		    }
		});
		
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
			  Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			message.setContent(multipart);
			Transport.send(message);
}
	/*public boolean checkEmailvalidity(String emailaddress){
	    String email_regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	   boolean b = emailaddress.matches(email_regex);
	   return b;
	}*/
	public final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public final Pattern VALID_PHONE_NUMBER_REGEX = 
		    Pattern.compile("^\\d{10}$", Pattern.CASE_INSENSITIVE);

	public boolean validateEmail(String emailStr) {
		        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		        return matcher.find();
		}
		
	public boolean validatephone(String phoneStr) {
	        Matcher matcher = VALID_PHONE_NUMBER_REGEX.matcher(phoneStr);
	        return matcher.find();
	}

}
