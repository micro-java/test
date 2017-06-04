package com.demo.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by richard on 2017/6/4.
 */
public class DbUtil {
    private  static SqlSessionFactory sessionFactory=null;

    public static void init()throws Exception{
        InputStream inputStream= Resources.getResourceAsStream("MybatisConf.xml");
         sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sess=sessionFactory.openSession();
    }

    public static SqlSession getSqlSession(){
        return sessionFactory.openSession();
    }
    public static  void close(){
    }
}
