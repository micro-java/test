package com.xx.dao.imp;

import com.xx.bean.User;
import com.xx.bean.UserInfo;
import com.xx.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by richard on 2017/6/3.
 */
public class UserDaoImp implements UserDao {

    public User addUser(Map<String, Object> stringObjectMap) {
        return null;
    }

    public User addUserData(Map<Integer, Object> integerObjectMap) {
        return null;
    }

    public UserInfo getUserInfo(int id)throws IOException {
        InputStream input= Resources.getResourceAsStream("MybatisConf.xml");//load xml

        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(input);//instance of SessionFactory

        SqlSession session=sessionFactory.openSession();//open Session;

        String statment="richard.mapping.MybatisMapper.getUserOne";

        UserInfo userInfo=session.selectOne(statment,id);

        return userInfo;
    }

    public User addUserInfo(Map<String, String> stringStringMap) {
        return null;
    }

}
