package at.tu.graz.coffee.javaHelper;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.StrictMode;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Session;




public class EmailSender extends AsyncTask<String,String, Void> {
    private String username = "agilesoftwaredev2021@gmail.com";
    private String password = "Bismarck0104";
    Properties props = new Properties();


    @Override
    protected Void doInBackground(String... strings) {
        send(strings[0], strings[1]);
        return null;
    }

    public void send(String to, String text)
    {
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
            message.setText(text);
            Transport.send(message);
        }
        catch (MessagingException e)
        {
            e.printStackTrace();
        }

    }


}
