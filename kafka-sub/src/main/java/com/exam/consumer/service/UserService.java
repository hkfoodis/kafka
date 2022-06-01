package com.exam.consumer.service;

import com.exam.consumer.domain.UserSub;
import com.exam.consumer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public int insertUser(UserSub userSub) throws Exception {
        int ret = 0;

        if(userRepository.insertUser(userSub) >= 1) {
            ret =1;
        }

        return ret;
    }

    public List<UserSub> getUserList() throws Exception {
        return userRepository.selectUserList();
    }
}
