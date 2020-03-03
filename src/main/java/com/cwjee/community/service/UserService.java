package com.cwjee.community.service;

import com.cwjee.community.mapper.UserMapper;
import com.cwjee.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Victory
 * @date 2020/3/3 16:25:16
 * @decription
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;


    public void createOrUpdate(User user) {
        long accountId = user.getAccountId();
        User dbuser = userMapper.findById(accountId);
        if (dbuser == null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setGmtModified(System.currentTimeMillis());
            dbuser.setName(user.getName());
            dbuser.setToken(user.getToken());

            userMapper.update(dbuser);
        }

    }
}
