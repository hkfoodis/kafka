package com.exam.kafka.controller;

import com.exam.kafka.domain.User;
import com.exam.kafka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity save(@RequestBody final User user) throws Exception {
        if(userService.insertUser(user) != 1) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> select() throws Exception {
        List<User> list = userService.getUserList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /* 계산 할 수 있는 새로운 기능 */
    @PostMapping(value = "/user/insert/score")
    public ResponseEntity insertScore(@RequestBody User user) throws Exception {
        if (userService.insertScore(user) != 1) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
