package com.crud.smog.scheduler;

import com.crud.smog.config.AdminConfig;
import com.crud.smog.domain.Mail;
import com.crud.smog.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private EmailService emailService;

    private static final String SUBJECT = "Lukasz_Lizewski_Smog_REST_APi, daily information";

    @Scheduled/*(cron = "0 0 10 * * *")*/(fixedDelay = 1000000 )
    public void sendInformationEmail() {

        emailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT)
        );
    }
}
