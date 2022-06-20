package com.exam.kafka.repository;

import com.exam.kafka.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    int insertUser(User user) throws Exception;
    List<User> selectUserList() throws Exception;
    void updateScore(User User);
}
