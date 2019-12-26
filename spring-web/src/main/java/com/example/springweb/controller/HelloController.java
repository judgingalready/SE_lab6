package com.example.springweb.controller;

import com.example.springweb.dao.AppInfo;
import com.example.springweb.dao.User;
import com.example.springweb.service.AppInfoService;
import com.example.springweb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    UserService userService;

    @Autowired
    AppInfoService appInfoService;

    public final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/search", method = {RequestMethod.POST, RequestMethod.GET})
    public String login(Model model, HttpServletRequest request, HttpSession session) {
        logger.info("hello logging" + userService.getUserList());
        List<User> list = userService.getUserList();
        List<AppInfo> Alist = appInfoService.getAppInfoList();
        String string0 = Alist.get(0).toString();
        String string1 = Alist.get(1).toString();
        model.addAttribute("String0", string0);
        model.addAttribute("String1", string1);
        //System.out.println(helloService.helloMapper.findAll());
        //System.out.println(request.getParameter("user_name"));
        for (User helloUser : list)
            if (helloUser.getName().equals(request.getParameter("user_name")) && helloUser.getPassword().equals(request.getParameter("password")))
                return "checkApp";
        return "redirect:/index";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.POST, RequestMethod.GET})
    public String insert(Model model, HttpServletRequest request, HttpSession session) {
        User insert = new User(request.getParameter("id"),request.getParameter("user_name"),request.getParameter("password"));
        userService.register(insert);
        List<AppInfo> Alist = appInfoService.getAppInfoList();
        String string0 = Alist.get(0).toString();
        String string1 = Alist.get(1).toString();
        model.addAttribute("String0", string0);
        model.addAttribute("String1", string1);
        return "checkApp";
    }


    @RequestMapping(value = "/update", method = {RequestMethod.POST, RequestMethod.GET})
    public String update(Model model, HttpServletRequest request, HttpSession session) {
        //System.out.println(request.getParameter("id"));
        AppInfo update = new AppInfo(
                request.getParameter("id"),
                request.getParameter("name"),
                request.getParameter("audit_status"),
                request.getParameter("classification"),
                request.getParameter("name_conforms"),
                request.getParameter("security_level"));
        appInfoService.UpdateByID(update);
        List<AppInfo> Alist = appInfoService.getAppInfoList();
        String string0 = Alist.get(0).toString();
        String string1 = Alist.get(1).toString();
        model.addAttribute("String0", string0);
        model.addAttribute("String1", string1);
        return "checkApp";
    }

    @RequestMapping(value = "/checkApp",method = {RequestMethod.POST, RequestMethod.GET})
    public String hello(Model model, HttpServletRequest request, HttpSession session) {
        String Appid = request.getParameter("id");
        model.addAttribute("Aid", Appid);

        List<AppInfo> list = appInfoService.getAppInfoList();
        String string0 = list.get(0).toString();
        String string1 = list.get(1).toString();
        model.addAttribute("String0", string0);
        model.addAttribute("String1", string1);
        return "checkAppid";
    }
}
