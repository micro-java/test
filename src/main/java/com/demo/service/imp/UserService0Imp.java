package com.demo.service.imp;

import com.demo.dao.UserDao0;
//import com.demo.dao.imp.UserDaoImp;
import com.demo.service.UserService0;
import com.demo.util.ConstantCode;
import com.demo.util.ResourceVerifyUtil;
import com.demo.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
@Service
public class UserService0Imp implements UserService0 {
    @Autowired
    private UserDao0 userDao0Imp;

    /***
     * 参数处理,返回结果处理
     * @param params
     * @return
     */
    public Map<String, Object> login(Map<String, Object> params) {
        ResourceVerifyUtil.commonVaild(params,new String[]{ConstantCode.USERNAME,ConstantCode.PASSWORD});
//        String userName=params.get(ConstantCode.USERNAME).toString();
        String password= Tools.md5(params.get(ConstantCode.PASSWORD).toString());
        params.put("password", Tools.md5(params.get(ConstantCode.PASSWORD).toString()));
        Map<String,Object> user=userDao0Imp.findUser(params);
        //脱敏处理

        return user;
    }

    public int register(Map<String, Object> params) {
        ResourceVerifyUtil.commonVaild(params,new String[]{ConstantCode.USERNAME,ConstantCode.PASSWORD,ConstantCode.CONPASSWORD});

        if(!(params.get(ConstantCode.PASSWORD).toString()).equals(params.get(ConstantCode.CONPASSWORD).toString())){
            return 0;
        }else {
//            String userName=params.get(ConstantCode.USERNAME).toString();
            String password= Tools.md5(params.get(ConstantCode.PASSWORD).toString());
            params.put("password", Tools.md5(params.get(ConstantCode.PASSWORD).toString()));
            int user=userDao0Imp.registerUser(params);
            return user;
        }
    }
    public int setpassword(Map<String, Object> params) {
        ResourceVerifyUtil.commonVaild(params,new String[]{ConstantCode.USERNAME,ConstantCode.PASSWORD,ConstantCode.CONPASSWORD});

        if(!(params.get(ConstantCode.PASSWORD).toString()).equals(params.get(ConstantCode.CONPASSWORD).toString())){
            return 0;
        }else {
//            String userName=params.get(ConstantCode.USERNAME).toString();
            String password= Tools.md5(params.get(ConstantCode.PASSWORD).toString());
            params.put("password", Tools.md5(params.get(ConstantCode.PASSWORD).toString()));
            int user=userDao0Imp.setpassword(params);
            return user;
        }
    }

    public List<String> showAllUsers(Map<String,Object> params) {
        List<String> user=userDao0Imp.showAllUsers();
        return user;
    }


}
