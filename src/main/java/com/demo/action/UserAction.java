package com.demo.action;

import com.demo.service.UserService0;
import com.demo.service.imp.UserService0Imp;
import com.demo.util.ProjException;
import com.demo.util.ResultUtil;
import com.demo.util.SpringContextUtil;
import com.demo.util.Tools;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * Created by richard on 2017/6/4.
 */
public class UserAction extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
            doPost(req,resp);
    }
    private UserService0 userService0Imp=null;
    public UserAction(){
        userService0Imp= SpringContextUtil.getContext().getBean(UserService0.class);
    }

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
           Map<String,Object> o= ResultUtil.wrapResult(methodName,method.invoke(userService0Imp,params),path);
           resp.getWriter().write(getResult(o,params));
           resp.getWriter().close();
        } catch (Exception e1){
            e1.printStackTrace();
            Map<String,Object> o=ResultUtil.wrapErrorResult(methodName,path, ProjException.get(e1));
            resp.getWriter().write(getResult(o,params));
            resp.getWriter().close();
        }
    }


    private String getResult(Map<String,Object> rs,Map<String,Object> query){
//
//        Object o=rs.get("result");
//        String html=Tools.getMainHtml();
//        if(o==null){
//            html=html.replaceAll("\\$message","result is null");
//        }
//        if(o instanceof Map){
//            html=html.replaceAll("\\$message","");
//            for (String key:query.keySet()){
//                html=html.replaceAll("\\$"+key,query.get(key).toString());
//            }
//        }else{
//           html= html.replaceAll("\\$message",String.valueOf(o));
//        }
        return rs.toString();
    }
}
