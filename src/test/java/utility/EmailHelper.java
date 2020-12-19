package utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailHelper {

	public static void main(String[] args) throws EmailException {
		// TODO Auto-generated method stub
		System.out.println("**********Sending email now*********");
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.setAuthenticator(new DefaultAuthenticator("testsheekha@gmail.com", "Summer@2020"));
		email.setSSLOnConnect(true);
		email.setFrom("testsheekha@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("agrawalsheekha@gmail.com");
		email.send();
		System.out.println("**********email sent*********");
	}

}
