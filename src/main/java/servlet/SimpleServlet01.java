package servlet;

import app.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Created by richard on 2017/6/1.
 */
public class SimpleServlet01 implements Servlet {
    public void init(ServletConfig config) throws ServletException{
        System.out.println("init");



    }

    public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException{
        System.out.println("begin service");
        String className=req.getParameter("className");
        String shutDown=req.getParameter("shutdown");
        String userData=req.getParameter("userData");

        PrintWriter out=res.getWriter();

        if("yes".equals(shutDown)){
            destroy();
            out.close();
        }else {
            shutDown="no";
        }

        out.println(className+" :hello begin");
        out.println("shutDown: "+shutDown);
        out.println("userData:"+getDatabase(Integer.parseInt(userData)));

    }
    public void destroy(){
        System.out.println("destroy");
    }

    public ServletConfig getServletConfig(){
        return null;
    }

    public String getServletInfo(){
        return null;
    }
    public User getDatabase(int num)throws IOException{

        InputStream inputStream= Resources.getResourceAsStream("MybatisConf.xml");
        SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session=sessionFactory.openSession();
        String statment="richard.mapping.MybatisMapper.getUserOne";
        User user=session.selectOne(statment,num);
        return user;
    }
}
