package com.demo.dao;

import java.util.List;
import java.util.Map;


/**
 * Created by richard on 2017/6/4.
 */
public interface UserDao0 {
    public Map<String,Object> findUser(Map<String,Object> obj);
    public int registerUser(Map<String,Object> obj);

    public int setpassword(Map<String,Object> obj);
    public List<String> showAllUsers();
}
