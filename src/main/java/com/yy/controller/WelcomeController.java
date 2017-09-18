package com.yy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/18 at 上午11:35
 */
@Controller
@RequestMapping("/yy")
public class WelcomeController {

    @GetMapping("/welcome")
    public ModelAndView welcome(ModelMap map) {

        map.addAttribute("message", "hello world");

        return new ModelAndView("welcome", map);

    }
}
