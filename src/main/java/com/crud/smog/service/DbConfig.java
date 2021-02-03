package com.crud.smog.service;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component // This component doesnt work need to write down data manually
public class DbConfig {
    @Value("${sql.data.username}")
    private String userName;
    @Value("${sql.data.password}")
    private String userPassword;
    @Value("${sql.data.url}")
    private String url;
}
