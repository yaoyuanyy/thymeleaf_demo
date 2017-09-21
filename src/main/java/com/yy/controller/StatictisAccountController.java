package com.yy.controller;

import com.yy.service.StatictisAccountService;
import com.yy.util.Constant;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <p></p>
 * <pre></pre>
 * NB.
 * Created by skyler on 2017/9/18 at 下午8:49
 */

@Controller
@RequestMapping("/statictisAccount")
@SessionAttributes({Constant.SITE, Constant.ACCOUNT})
public class StatictisAccountController {

    @Resource
    private StatictisAccountService statictisAccountService;

    @PostMapping("/getStatictisAccountData")
    public ModelAndView getStatictisAccountData(@NotBlank(message = "参数不正确") @RequestParam("site") String site, @NotBlank(message = "参数不正确") @RequestParam("account") String account,
                                                HttpSession session) {
        Map<String, List<Double>> statictisData = statictisAccountService.statictisAccountData(site, account);

        ModelMap modelMap = new ModelMap("statictisData", statictisData);
        modelMap.addAttribute("currentSite", site);
        modelMap.addAttribute("currentAccount", account);
        modelMap.addAttribute("sites", session.getAttribute(Constant.SITE));
        modelMap.addAttribute("accounts", session.getAttribute(Constant.ACCOUNT));

        return new ModelAndView("index_data", modelMap);
    }
}
