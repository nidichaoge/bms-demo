package com.mouse.bms.demo.testa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-23 12:40
 * @description
 */
@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

}
