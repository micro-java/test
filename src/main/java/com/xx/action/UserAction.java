package com.xx.action;

import com.xx.bean.User;
import com.xx.bean.XX;

import java.util.Map;

/**
 * Created by LRYSIR on 2017/6/2.
 */
public  interface UserAction {
    //login
    public User login(Map<String,Object> stringObjectMap);

}
