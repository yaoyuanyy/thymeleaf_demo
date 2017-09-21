package com.yy.service.impl;

import com.yy.mapper.UserMapper;
import com.yy.model.User;
import com.yy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * <p>
 * Created by yaoliang on 2017/9/20 at 下午8:45
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public void insert(User user) {

    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String name, String password) throws Exception{

        User user = userMapper.getUserByName(name);

        if (user == null) {
            throw new Exception("用户名不存在");
        }

        if (!password.equals(user.getPassword())) {
            throw new Exception("密码错误");
        }

        return user;
    }
}