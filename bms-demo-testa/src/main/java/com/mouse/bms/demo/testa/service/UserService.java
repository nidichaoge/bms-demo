package com.mouse.bms.demo.testa.service;

import com.mouse.bms.demo.testa.dataobject.User;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 12:43
 * @description
 */
public interface UserService {

    User findByUsername(String username);

}
