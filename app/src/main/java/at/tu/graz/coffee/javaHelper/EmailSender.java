package at.tu.graz.coffee.javaHelper;

import android.os.StrictMode;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    private String username = "johntusha04@gmail.com";
    private String password = "Teutonia1863!jg";
    Properties props = new Properties();

    public EmailSender (String msg, String to)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        Session session =  Session.getInstance(props, new javax.mail.Authenticator(){
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(username, password);
            }
        });
        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Support-Request");
            message.setText(msg);
            Transport.send(message);
        }
        catch (MessagingException ee)
        {
            ee.printStackTrace();
        }

    }
}
