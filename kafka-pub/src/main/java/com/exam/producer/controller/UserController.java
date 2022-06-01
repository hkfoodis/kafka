package com.exam.producer.controller;


import com.exam.producer.domain.User;
import com.exam.producer.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "사용자 저장", description = "사용자 정보를 저장합니다.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
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

}
