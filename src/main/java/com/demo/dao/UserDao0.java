package com.demo.dao;

import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public interface UserDao0 {
    public Map<String,Object> findUser(String name, String password);
    public boolean registerUser(String name, String password);
}
