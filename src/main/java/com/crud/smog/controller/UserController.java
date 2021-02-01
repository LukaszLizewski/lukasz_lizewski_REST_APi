package com.crud.smog.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/smog")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/user/{userId}")
    public String getUser (@PathVariable("userId") Long userId) {
        return "getUser (userId)";
    }
    @RequestMapping(method = RequestMethod.GET, value = "/user/")
    public List<String> getUsers () {
        List<String> list = new ArrayList<>();
        list.add("User1");
        list.add("User2");
        list.add("User3");
        return list;
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/deleteUser/{userId}"/*{userId}*/)
    public String deleteUser (@PathVariable("userId") Long userId) {
        return "deleteUser";
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/updateUser", consumes = APPLICATION_JSON_VALUE)
    public String updateUser () {
        return "updateUser";
    }
    @RequestMapping(method = RequestMethod.POST, value = "/user/createUser", consumes = APPLICATION_JSON_VALUE)
    public String createUser () {
        return "createUser";
    }
}
