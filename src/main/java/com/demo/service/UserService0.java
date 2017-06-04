package com.demo.service;

import java.util.List;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public interface UserService0 {
    public Map<String,Object> login(Map<String,Object> params);
    public int register(Map<String,Object> params);
    public int setpassword(Map<String,Object> params);
    public List<String> showAllUsers(Map<String,Object> params);
}
