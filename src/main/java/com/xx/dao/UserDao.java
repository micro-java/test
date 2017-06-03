package com.xx.dao;

import com.xx.bean.User;
import com.xx.bean.UserInfo;

import java.util.Map;

/**
 * Created by richard on 2017/6/3.
 */
public interface UserDao {
     User addUser(Map<String,Object> stringObjectMap) ;
     User addUserData(Map<Integer,Object> integerObjectMap);
     UserInfo getUserInfo(int id)throws Exception;
     User addUserInfo(Map<String,String> stringStringMap);

}
