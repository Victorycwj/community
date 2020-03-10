package com.cwjee.community.service;

import com.cwjee.community.mapper.UserMapper;
import com.cwjee.community.model.User;
import com.cwjee.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

        UserExample example = new UserExample();
        example.createCriteria().
                andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 0){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else {
            User dbUser = users.get(0);

            User updateUser = new User();
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example1 = new UserExample();
            example1.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, example1);
        }

    }
}
