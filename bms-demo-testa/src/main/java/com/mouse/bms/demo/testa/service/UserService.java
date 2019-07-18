package com.mouse.bms.demo.testa.service;

import com.mouse.bms.demo.testa.dataobject.TestRoleDO;
import com.mouse.bms.demo.testa.dataobject.TestUserDO;
import com.mouse.bms.demo.testa.dataobject.User;

import java.util.List;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 12:43
 * @description
 */
public interface UserService {

    User findUserByUsername(String username);

    TestUserDO findByUsername(String username);

    List<TestRoleDO> findByRoleIds(Long userId);

}
