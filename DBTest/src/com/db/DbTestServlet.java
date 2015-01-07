package com.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;





@SuppressWarnings("serial")
public class DbTestServlet extends HttpServlet {
	private static final Logger log = Logger.getLogger(DbTestServlet.class.getName());
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		resp.setContentType("text/plain");
		testMail();
		//resp.getWriter().println("Hello, world" + testConn());
		
		
	}
	public void testMail()
	{
		

		// ...
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);

		String msgBody = "...";

		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("subhashini.80@gmail.com", "SV Admin"));
		    msg.addRecipients(Message.RecipientType.TO,
		     new InternetAddress[]{
		    		new InternetAddress("kasinath.anupindi@gmail.com", "Mr. User"),
		    		new InternetAddress("balajiprashad18@gmail.com", "Mr. User"),
		    		new InternetAddress("subhashini.80@gmail.com", "Mr. User")});
		    msg.setSubject("test mail from app");
		    
		    msg.setText(msgBody);
		    Transport.send(msg);
		    System.out.println("sent");
		} catch (AddressException e) {
		    // ...
		} catch (MessagingException e) {
		    // ...
		} catch (Exception e) {
		    // ...
		}

	}
	
	public String testConn1()
	{
		String url = null;
		String ans= null;
		try {
			//Class.forName("com.mysql.jdbc.GoogleDriver");
			 Class.forName("com.mysql.jdbc.Driver");
			 //Class.forName("com.google.appengine.api.rdbms.AppEngineDriver").newInstance();
			

		/*url ="jdbc:mysql://173.194.254.108:3306?user=root";
		
		Connection conn = DriverManager.getConnection(url,"root","genesis22");*/
			 
		url ="jdbc:mysql://localhost:3306?user=root";
				
		Connection conn = DriverManager.getConnection(url);
		ResultSet rs = conn.createStatement().executeQuery(
		"SELECT * from testxan.invite");
		rs.next();
		 ans= rs.getString(2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}
	public String testConn()
	{
		String url = null;
		String ans= null;
		try {
			Class.forName("com.google.appengine.api.rdbms.AppEngineDriver");
			
			
log.info("1");
		url ="jdbc:google:mysql://project-xanadu-2014:genesis1?user=root";
		
		Connection conn = DriverManager.getConnection(url);
			 
		//url ="jdbc:google:mysql://localhost:3306?user=root";
		log.info("2");	
		
		ResultSet rs = conn.createStatement().executeQuery(
		"SELECT * from testxan.invite");
		log.info("3");
		rs.next();
		 ans= rs.getString(1);
		 log.info("4");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.info(e.getMessage());
		}
		return ans;
	}
}
