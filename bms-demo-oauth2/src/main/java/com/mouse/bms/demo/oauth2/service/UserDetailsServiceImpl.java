package com.mouse.bms.demo.oauth2.service;

import com.mouse.bms.demo.oauth2.dao.RoleDAO;
import com.mouse.bms.demo.oauth2.dao.UserDAO;
import com.mouse.bms.demo.oauth2.dao.UserRoleDAO;
import com.mouse.bms.demo.oauth2.dataobject.Role;
import com.mouse.bms.demo.oauth2.dataobject.User;
import com.mouse.bms.demo.oauth2.dataobject.UserRoleDO;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-20 15:12
 * @description 密码还必须加密?如何更优雅的去实现
 * 角色前必须加ROLE_,否则还是报错
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserDAO userDAO;

    @Resource
    private RoleDAO roleDAO;

    @Resource
    private UserRoleDAO userRoleDAO;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("username can not be null or empty.");
        }
        User byUsername = userDAO.findByUsername(username);
        if (ObjectUtils.isEmpty(byUsername)) {
            throw new UsernameNotFoundException("can not find user.");
        }
        List<UserRoleDO> byUserId = userRoleDAO.findByUserId(byUsername.getId());
        List<Long> collect = byUserId.stream().map(UserRoleDO::getRoleId).collect(Collectors.toList());
        List<Role> roles = roleDAO.findById(collect);
        roles.forEach(role -> role.setRole("ROLE_" + role.getRole()));
        byUsername.setRoles(roles);
//        byUsername.setPassword(passwordEncoder.encode(byUsername.getPassword()));
        return byUsername;
    }

}
