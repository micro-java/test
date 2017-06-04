package com.xx.action.imp;

import com.xx.action.UserAction;
import com.xx.bean.User;
import com.xx.bean.UserInfo;
import com.xx.dao.UserDao;
import com.xx.dao.imp.UserDaoImp;
import com.xx.service.UserService;
import com.xx.service.imp.UserServiceImp;

import java.util.Map;

/**
 * Created by richard on 2017/6/2.
 */
public class UserActionImp implements UserAction {
    private UserService userServiceImp=new UserServiceImp();

    private UserDao userDaoImp=new UserDaoImp();

    public User login(Map<String, Object> stringObjectMap) {
        //
        User u=userServiceImp.findUser(stringObjectMap);
        User user=userDaoImp.addUser(stringObjectMap);
        try{
            UserInfo userInfo=userDaoImp.getUserInfo(1);
            System.out.println(userInfo);
        }catch (Exception e){

        }

        return null;
    }

}
