package com.mouse.bms.demo.oauth2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * @author mouse
 * @version 1.0
 * @date 2019-07-20 16:52
 * @description
 */
@Controller
public class UserController {

    @ResponseBody
    @GetMapping("/users/current")
    public Principal getUser(Principal principal) {
        return principal;
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
