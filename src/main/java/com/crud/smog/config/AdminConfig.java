package com.crud.smog.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;
    @Value("${admin.name}")
    private String adminName;
    @Value("${admin.project.name}")
    private String adminProjectName;
    @Value("${admin.project.url}")
    private String adminProjectUrl;
}
