package com.xx.service;

import com.xx.bean.User;

import java.util.Map;

/**
 * Created by richard on 2017/6/2.
 */
public interface UserService {
    User findUser(Map<String, Object> stringObjectMap);
}
