package com.crud.smog.controller;

import com.crud.smog.domain.UserDto;
import com.crud.smog.mapper.UserMapper;
import com.crud.smog.service.DbManager;
import com.crud.smog.service.DbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/smog")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DbUserService dbUserService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    public UserDto getUser(@PathVariable("userId") Long userId) throws UserNotFoundException {
        LOGGER.info("UserController -> getUser; user's Id:" + userId);
        return userMapper.mapToUserDto(dbUserService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/")
    public List<UserDto> getUsers() {
        LOGGER.info("UserController -> getUsers");
        return userMapper.mapToUserListDto(dbUserService.getListOfUsers());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user/deleteUser/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        LOGGER.info("UserController -> deleteUser; user's Id:" + userId);
        dbUserService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/updateUser", consumes = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) throws SQLException {
        upDateProvince();
        LOGGER.info("UserController -> updateUser; user's Id:" + userDto.getId());
        return userMapper.mapToUserDto(dbUserService.saveUserEntity(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        dbUserService.saveUserEntity(userMapper.mapToUser(userDto));
        //upDateProvince(); //update table with id of provinces
        LOGGER.info("UserController -> createUser");
    }

    private void upDateProvince() throws SQLException { // tę metodę przenieść do innej klasy
        DbManager dbManager = DbManager.getInstance();
        String sqlUpdate = "CALL lukasz_lizewski_api.UpdateUsers();";
        Statement statement = dbManager.getConnection().createStatement();
        statement.executeUpdate(sqlUpdate);
    }
}
