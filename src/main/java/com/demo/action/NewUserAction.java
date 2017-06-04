package com.demo.action;

import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public interface NewUserAction {
    public String login(Map<String,Object> obj);
    public String register(Map<String,Object> obj);
    public String setpassword(Map<String,Object> obj);
    public String showAllUsers(Map<String,Object> obj);
}
