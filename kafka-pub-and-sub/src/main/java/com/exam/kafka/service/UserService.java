package com.exam.kafka.service;


import com.exam.kafka.domain.User;
import com.exam.kafka.publisher.UserPublisher;
import com.exam.kafka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserPublisher userPublisher;

    public int insertUser(User user) throws Exception {
        int ret = 0;

        if(userRepository.insertUser(user) >= 1) {
            ret =1;
        }

        return ret;
    }

    public List<User> getUserList() throws Exception {
        return userRepository.selectUserList();
    }

    public int insertScore(User user) throws Exception {
        int ret = 0;

        userPublisher.publish(user);

        return ret;
    }
}
