package com.csci4050.movie.api;

import com.csci4050.movie.api.model.Customer;
import com.csci4050.movie.api.model.Promotion;
import com.csci4050.movie.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetHeaders;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(Customer customer, String toEmail, String code){

        SimpleMailMessage message = new SimpleMailMessage();

        String body = "Your account has been created! \n"
                + "Email: " + toEmail
                + "\nFirst Name: " + customer.getFirstName()
                + "\nLast Name: " + customer.getLastName()
                + "\nAddress: " + customer.getStreet() + " " + customer.getCity()
                + ", " + customer.getState() + " " + customer.getZip()
                + "\n\nVerify your account: "
                + "http://localhost:8080/customer/verify?code=" + code
                + "&id=" + customer.getCid();
        String subject = "Registration Confirmation";


        message.setFrom("pidgeontheatres@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

//    public void sendEditEmail(Customer customer) {
//
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        String body = "Your account has been changed! \n"
//                    + "Email: " + customer.getEmail()
//                    + "\nFirst Name: " + customer.getFirstName()
//                    + "\nLast Name: " + customer.getLastName()
//                    + "\nAddress: " + customer.getStreet() + ", " + customer.getCity()
//                    + ", " + customer.getState() + " " + customer.getZip()
//                    + "\nPhone: " + customer.getPhone();
//        String subject = "Changes made to Profile";
//
//        message.setFrom("pidgeontheatres@gmail.com");
//        message.setTo(customer.getEmail());
//        message.setText(body);
//        message.setSubject(subject);
//
//        mailSender.send(message);
//    }

    public void sendForgotEmail(String email, User user) {
        SimpleMailMessage message = new SimpleMailMessage();

        String body = "Click here to reset your password: http://localhost:8080/reset?id=" + user.getUid();
        String subject = "Reset Password";

        message.setFrom("pidgeontheatres@gmail.com");
        message.setTo(email);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);
    }

    public void sendPromoEmail(Promotion promo, User user) {
        SimpleMailMessage message = new SimpleMailMessage();

        String body = "New promotion! \nUse code: " + promo.getPcode()
                + "\nTo get " + (int)Math.round((1 - promo.getAmount()) * 100) + "% off on your next purchase!";
        String subject = "New Promotions!";

        message.setFrom("pidgeontheatres@gmail.com");
        message.setText(body);
        message.setSubject(subject);
        message.setTo(user.getEmail());
        mailSender.send(message);
    }
}
