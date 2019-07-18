package com.mouse.bms.demo.testa.service;

import com.mouse.bms.demo.testa.dao.TestRoleDAO;
import com.mouse.bms.demo.testa.dao.TestUserDAO;
import com.mouse.bms.demo.testa.dao.TestUserRoleDAO;
import com.mouse.bms.demo.testa.dataobject.TestRoleDO;
import com.mouse.bms.demo.testa.dataobject.TestUserDO;
import com.mouse.bms.demo.testa.dataobject.TestUserRoleDO;
import com.mouse.bms.demo.testa.dataobject.User;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 12:45
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TestUserDAO testUserDAO;
    @Resource
    private TestUserRoleDAO testUserRoleDAO;
    @Resource
    private TestRoleDAO testRoleDAO;

    /**
     * 基于模拟内存的方式
     *
     * @param username
     * @return
     */
    @Override
    public User findUserByUsername(String username) {
        if ("mouse".equals(username)) {
            return User.builder().id(1L).username("mouse").password("123").role("user").build();
        }
        if ("chao".equals(username)) {
            return User.builder().id(2L).username("chao").password("123").role("admin").build();
        }
        return null;
    }

    //===================================================================================================

    /**
     * 基于mysql的方式
     *
     * @param username
     * @return
     */
    @Override
    public TestUserDO findByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return testUserDAO.findByUsername(username);
    }

    @Override
    public List<TestRoleDO> findByRoleIds(Long userId) {
        if (0 >= userId) {
            throw new RuntimeException("userId illegal");
        }
        List<TestUserRoleDO> byUserId = testUserRoleDAO.findByUserId(userId);
        if (CollectionUtils.isEmpty(byUserId)) {
            return new ArrayList<>();
        }
        List<Long> collect = byUserId.stream().map(TestUserRoleDO::getRoleId).collect(Collectors.toList());
        return testRoleDAO.findById(collect);
    }

}
