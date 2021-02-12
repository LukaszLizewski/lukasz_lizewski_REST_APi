package com.crud.smog.service;

import com.crud.smog.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(Mail mail) {
        LOGGER.info("Starting email preparation.");
        try {
            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");
        } catch (MailException e) {
            LOGGER.error("Field to process email sending", e.getMessage(),e);
        }
    }
    private MimeMessagePreparator createMimeMessage(final Mail mail) {

        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                messageHelper.setTo(mail.getMailTo());
                messageHelper.setSubject(mail.getSubject());
                messageHelper.setText(mail.getMessage(), true);
        };
    }
}
