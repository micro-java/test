package com.demo.service.imp;

import com.demo.dao.UserDao0;
import com.demo.dao.imp.UserDaoImp;
import com.demo.service.UserService0;
import com.demo.util.ConstantCode;
import com.demo.util.Tools;

import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public class UserService0Imp implements UserService0 {
    private UserDao0 userDao0Imp=new UserDaoImp();

    /***
     * 参数处理,返回结果处理
     * @param params
     * @return
     */
    public Map<String, Object> login(Map<String, Object> params) {
        //userName,password 都是符合规范的数据
        if(!params.containsKey(ConstantCode.USERNAME)||
                !params.containsKey(ConstantCode.PASSWORD) ||
                params.get(ConstantCode.PASSWORD)==null||
                params.get(ConstantCode.USERNAME)==null){
            return null;
        }
        String userName=params.get(ConstantCode.USERNAME).toString();
        String password= Tools.md5(params.get(ConstantCode.PASSWORD).toString());
        Map<String,Object> user=userDao0Imp.findUser(userName,password);
        //脱敏处理

        return user;
    }

    public boolean register(Map<String, Object> params) {

        if(!params.containsKey(ConstantCode.USERNAME)||
                !params.containsKey(ConstantCode.PASSWORD) ||
                !params.containsKey(ConstantCode.CONPASSWORD) ||
                params.get(ConstantCode.PASSWORD)==null||
                params.get(ConstantCode.USERNAME)==null||
                params.get(ConstantCode.CONPASSWORD)==null){

            return false;
        }
        if(!(params.get(ConstantCode.PASSWORD).toString()).equals(params.get(ConstantCode.CONPASSWORD).toString())){
            return false;
        }else {
            String userName=params.get(ConstantCode.USERNAME).toString();
            String password= Tools.md5(params.get(ConstantCode.PASSWORD).toString());
            boolean user=userDao0Imp.registerUser(userName,password);
            return user;
        }
    }


}
