package com.demo.action.imp;

import com.alibaba.fastjson.JSON;
import com.demo.action.NewUserAction;
import com.demo.service.UserService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
@Controller
@RequestMapping(value = "/user")
public class NewUserActionImp implements NewUserAction {
    @Autowired
    private UserService0 userService0Imp;

    @ResponseBody
    @RequestMapping(path = "/login.htm",method = RequestMethod.GET)
    public String login(@RequestParam Map<String, Object> obj) {
        Object o=userService0Imp.login(obj);
        return JSON.toJSONString(o);
    }
    @ResponseBody
    @RequestMapping(path = "/register.htm",method = RequestMethod.GET)
    public String register(@RequestParam Map<String,Object> obj){
        Object o=userService0Imp.register(obj);
        return JSON.toJSONString(0);
    }

    @ResponseBody
    @RequestMapping(path = "/setpassword.htm",method = RequestMethod.GET)
    public String setpassword(@RequestParam Map<String, Object> obj) {
        int o=userService0Imp.setpassword(obj);
        return JSON.toJSONString(o);
    }

    @ResponseBody
    @RequestMapping(path = "showAllUsers.htm",method = RequestMethod.GET)
    public String showAllUsers(@RequestParam Map<String,Object> obj){
        Object list=userService0Imp.showAllUsers(obj);
        return JSON.toJSONString(list);
    }



}
