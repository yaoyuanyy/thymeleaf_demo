package com.yy.service;

import com.yy.model.User;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/20 at 下午8:45
 */
public interface UserService {

    void insert(User user);

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User login(String name, String password) throws Exception;

}
