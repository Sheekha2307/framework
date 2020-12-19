package utility;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class EmailWithAttachment {

	public static void emailWithAttachment() throws EmailException {
		// TODO Auto-generated method stub
		EmailAttachment attachment=new EmailAttachment();
		 attachment.setPath("C:\\Users\\LAP073\\eclipse-workspace\\demoMavenEclipseProject -GitHub\\target\\cucumber-reports\\report.html");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("html file");
		   attachment.setName("Report");
		   
			/*
			 * attachment = new EmailAttachment(); attachment.
			 * setPath("C:\\Users\\LAP073\\eclipse-workspace\\demoMavenEclipseProject -GitHub\\target\\logs\\Manual.logs"
			 * ); attachment.setDisposition(EmailAttachment.ATTACHMENT);
			 * attachment.setDescription("logs file"); attachment.setName("Manual logs");
			 */
		   //set email body   
		  MultiPartEmail email=new MultiPartEmail();
		   email.setHostName("smtp.gmail.com");
		   email.setSmtpPort(465);
		  email.setSSLOnConnect(true);
		  email.setAuthenticator(new DefaultAuthenticator("testsheekha@gmail.com","Summer@2020"));
		    try {
		 
		email.addTo("testsheekha@gmail.com","Test");
		 email.setFrom("dummyselenium1995@gmail.com", "Me");
		   email.setSubject("Test Email");
		   email.setMsg("PFA in html");
		 
		} catch (EmailException e) {
		  System.out.println(e.getMessage());
		 }
		   
		   System.out.println("Mail started sending");

		//add attachment to email
		   email.attach(attachment);

		//email send
		   email.send();  
		   System.out.println("Mail is sent");
		    
		}
		
	}


