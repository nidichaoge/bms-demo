package com.mouse.bms.demo.testa.service;

import com.mouse.bms.demo.testa.dataobject.User;
import org.springframework.stereotype.Service;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 12:45
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    //TODO 可以改为从数据库中查询
    @Override
    public User findByUsername(String username) {
        if ("mouse".equals(username)) {
            return User.builder().id(1L).username("mouse").password("123").role("user").build();
        }
        if ("chao".equals(username)) {
            return User.builder().id(2L).username("chao").password("123").role("admin").build();
        }
        return null;
    }

}
