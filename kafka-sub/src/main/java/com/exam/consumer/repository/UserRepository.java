package com.exam.consumer.repository;

import com.exam.consumer.domain.UserSub;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    int insertUser(UserSub userSub) throws Exception;
    List<UserSub> selectUserList() throws Exception;
}
