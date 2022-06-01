package com.exam.producer.repository;

import com.exam.producer.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    int insertUser(User user) throws Exception;
    List<User> selectUserList() throws Exception;
}
