package com.demo.action;

import com.demo.service.UserService0;
import com.demo.service.imp.UserService0Imp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public class UserAction extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
            doPost(req,resp);
    }
    private UserService0 userService0Imp=new UserService0Imp();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
       //user/login
       //user/register
        String path=req.getPathInfo();
        String tmp[]=path.split("/");
        String action=tmp[0]; //先不使用
        String methodName=tmp[1];
        Map<String,Object> params=new HashMap<String, Object>();
        Map<String,String[]> t=req.getParameterMap();
        for(String key:t.keySet()){
            params.put(key,t.get(key)[0]);
        }

        try {
            Method method=UserService0.class.getMethod(methodName,Map.class);
           Object o= method.invoke(userService0Imp,params);
           if(o==null){
               o=new String("no resources");
           }
           resp.getWriter().write(o.toString());
           resp.getWriter().close();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
