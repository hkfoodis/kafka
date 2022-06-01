package com.exam.producer.service;


import com.exam.producer.domain.User;
import com.exam.producer.publisher.UserPublisher;
import com.exam.producer.repository.UserRepository;
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
            userPublisher.publish(user);
            ret =1;
        }

        return ret;
    }

    public List<User> getUserList() throws Exception {
        return userRepository.selectUserList();
    }
}
