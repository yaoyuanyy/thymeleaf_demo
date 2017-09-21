package com.yy.controller;

import com.yy.model.User;
import com.yy.service.UserService;
import com.yy.util.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/18 at 上午11:35
 */
@Controller
@RequestMapping("/user")
@SessionAttributes({Constant.SITE, Constant.ACCOUNT})
public class LoginController {

    @Resource
    private UserService userService;


    @GetMapping("/index")
    public String index(ModelMap map) {

        return "login";
    }

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("username") String username, @RequestParam("password") String password,
                              HttpSession session) throws Exception{

        User user = userService.login(username, password);

        //List<String> sites = statictisAccountService.querySites();
        //List<String> accounts = statictisAccountService.queryAccounts();

        List<String> sites = new ArrayList<>();
        Collections.addAll(sites, "wo.com", "you.com");
        List<String> accounts = new ArrayList<>();
        Collections.addAll(accounts, "aa@qq.com");


        session.setAttribute(Constant.SITE, sites);
        session.setAttribute(Constant.ACCOUNT, accounts);

        ModelMap modelMap = new ModelMap("sites", sites);
        modelMap.addAttribute("accounts", accounts);

        return new ModelAndView("index_data", modelMap);

    }

    @GetMapping("/logout")
    public ModelAndView logout(ModelMap map) {

        return new ModelAndView("index2", map);

    }

}
