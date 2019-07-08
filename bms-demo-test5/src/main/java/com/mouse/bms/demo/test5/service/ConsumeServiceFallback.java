package com.mouse.bms.demo.test5.service;

import com.mouse.bms.demo.test5.dto.User;
import org.springframework.stereotype.Service;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-08 20:57
 * @description
 */
@Service
public class ConsumeServiceFallback implements ConsumeService {

    @Override
    public String hello() {
        return "fallback hello";
    }

    @Override
    public User get(Long id) {
        return User.builder().name("fallback get").build();
    }

    @Override
    public Boolean post(User user) {
        return Boolean.FALSE;
    }

    @Override
    public Long put(User user) {
        return -1L;
    }

    @Override
    public Boolean delete(Long id) {
        return Boolean.FALSE;
    }

}
