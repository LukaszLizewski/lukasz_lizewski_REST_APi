package com.crud.smog.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.config.AdminConfig;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.mapper.AirMapper;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AirClient airClient;
    @Autowired
    private AirMapper airMapper;


    public String buildSchedulerEmail() {
        String builder = "";
        List<String> listOfUsers  = userRepository.findAll().stream()
                .map(e-> builder.concat(e.getFirstName()).concat(" ").concat(e.getLastName()))
                .collect(Collectors.toList());

        Context context = new Context();
        context.setVariable("message", "Information about REST_APi");
        context.setVariable("project_url", "http://google.pl");
        context.setVariable("button", "Visit the project");
        context.setVariable("project_name", adminConfig.getAdminProjectName());
        context.setVariable("admin_object", adminConfig);
        context.setVariable("users_list", listOfUsers);
        return templateEngine.process("mail/scheduled-mail", context);
    }

}
