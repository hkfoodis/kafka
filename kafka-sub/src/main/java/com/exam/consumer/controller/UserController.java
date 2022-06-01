package com.exam.consumer.controller;


import com.exam.consumer.domain.UserSub;
import com.exam.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public ResponseEntity<List<UserSub>> select() throws Exception {
        List<UserSub> list = userService.getUserList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
