package com.mouse.bms.demo.testa.service;

import com.mouse.bms.demo.testa.dataobject.TestRoleDO;
import com.mouse.bms.demo.testa.dataobject.TestUserDO;
import com.mouse.bms.demo.testa.dataobject.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-18 12:42
 * @description 基于认证的方式
 */
@Component
public class TestDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;

    /**
     * ROLE_ 角色前必须添加,当用内存方式时不可添加(添加会报错),框架会自动添加
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userService.findUserByUsername(username);
//        if (Objects.isNull(user)) {
//            throw new UsernameNotFoundException("username can not found.");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), passwordEncoder.encode(user.getPassword()), authorities);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TestUserDO byUsername = userService.findByUsername(username);

        if (Objects.isNull(byUsername)) {
            throw new UsernameNotFoundException("username can not found.");
        }
        List<TestRoleDO> byRoleIds = userService.findByRoleIds(byUsername.getId());
        List<SimpleGrantedAuthority> authorities = byRoleIds.stream().map(byRoleId -> new SimpleGrantedAuthority("ROLE_" + byRoleId.getRole())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(byUsername.getUsername(), passwordEncoder.encode(byUsername.getPassword()), authorities);
    }

}
