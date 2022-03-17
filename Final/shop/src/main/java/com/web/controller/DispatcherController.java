package com.web.controller;

import com.web.bean.AjaxResult;
import com.web.bean.User;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class DispatcherController {

    @Autowired
    private UserService userService;

    // redirect to login page
    @RequestMapping("login")
    public String login() {

        return "login";
    }

    // redirect to register page
    @RequestMapping("register")
    public String register() {

        return "register";
    }

    // login with ajax
    @ResponseBody
    @RequestMapping("doAjaxLogin")
    public Object doAjaxLogin(User user, HttpSession session, HttpServletResponse response) {

        AjaxResult ajaxResult = new AjaxResult();

        User dbUser = userService.checkForLogin(user);

        ajaxResult.setSuccess(dbUser != null);

        return ajaxResult;
    }

    // register with ajax
    @ResponseBody
    @RequestMapping("doAjaxRegister")
    public Object doAjaxRegister(User user) {

        AjaxResult ajaxResult = new AjaxResult();

        User dbExistUser = userService.checkUsernameExistForRegister(user.getUsername());

        if (dbExistUser != null) {
            // username unavailable
            ajaxResult.setSuccess(false);
        } else {
            try {
                userService.insertUserForRegister(user);

                ajaxResult.setSuccess(true);
            } catch (Exception e) {
                e.printStackTrace();
                ajaxResult.setSuccess(false);
            }
        }

        return ajaxResult;
    }

}
