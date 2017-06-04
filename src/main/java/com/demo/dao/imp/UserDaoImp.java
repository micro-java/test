package com.demo.dao.imp;

import com.demo.dao.UserDao0;
import com.demo.util.DbUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public class UserDaoImp implements UserDao0{
    private SqlSession sess=null;
    public UserDaoImp(){
        sess= DbUtil.getSqlSession();
    }

    public Map<String, Object> findUser(String name, String password) {
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("name",name);
        params.put("pass",password);
        Map<String,Object> user= sess.selectOne("user.findUser",params);


        return user;
    }

    public boolean registerUser(String name, String password) {
        Map<String,Object> params=new HashMap<String, Object>();
        params.put("name",name);
        params.put("pass",password);
        int user=sess.insert("user.registerUser",params);
        return user==1;
    }

}
