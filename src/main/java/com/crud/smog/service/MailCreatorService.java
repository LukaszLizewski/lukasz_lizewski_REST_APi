package com.crud.smog.service;

import com.crud.smog.air.client.AirClient;
import com.crud.smog.air.domain.AirIndex;
import com.crud.smog.air.domain.AirStation;
import com.crud.smog.air.domain.AirStationDto;
import com.crud.smog.config.AdminConfig;
import com.crud.smog.domain.UserEntity;
import com.crud.smog.mapper.AirMapper;
import com.crud.smog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        Context context = new Context();
        context.setVariable("message", "Information about REST_APi");
        context.setVariable("project_url", adminConfig.getAdminProjectUrl());
        context.setVariable("button", "Visit the project TEMP");
        context.setVariable("project_name", adminConfig.getAdminProjectName());
        context.setVariable("admin_object", adminConfig);
        context.setVariable("users_list", getListOfUsers());
        context.setVariable("stations_list", getListOfStations());
        context.setVariable("creator", adminConfig.getAdminName());
        return templateEngine.process("mail/scheduled-mail", context);
    }
    private List<UserEntity> getListOfUsers(){
        return userRepository.findAll();
    }
    private List<String> getListOfStations(){
        List<AirStation> airStations = airMapper.mapToListAirStation(airClient.getStations());
        Map<AirStation, AirIndex> map = new HashMap<>();
        for (AirStation station: airStations) {
            System.out.println("Sending request to: " + station.getStationName());
            map.put(station,airMapper.mapToAirIndex(airClient.getIndex(station.getId())));
        }
        String builder = "";
        List<String> listOfStations  = map.entrySet().stream()
                .map(e-> builder.concat(e.getKey().getStationName()).concat("- quality of air: ").concat(e.getValue().getStIndexLevel().getIndexLevelName()))
                .collect(Collectors.toList());
        return listOfStations;
    }

}
