package servlet;

import app.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

import static servlet.SimpleServlet01.getDatabase;

/**
 * Created by richard on 2017/5/28.
 */
public class Servlet001 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String clientName=request.getParameter("clientName");
        String userID=request.getParameter("userID");
        try{
            if("".equals(userID)){
                System.out.println("userId is empty");
            }else {
                System.out.println(getDatabase(Integer.parseInt(userID)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        if(clientName!=null){
            clientName=new String(clientName.getBytes("ISO-8859-1"),"GB2312");
        }else {
            clientName="my friend";
        }
        PrintWriter out=null;
        String title= "servlet.Servlet001";
        String heading1="HelloServlet的doGet方法的输出:";

        response.setContentType("text/html;charset=GB2312");
        out=response.getWriter();
        out.print("<HTML><HEAD><TITLE>"+title+"</TITLE>");
        out.print("</HEAD><BODY>");
        out.print(heading1);
        out.println("<h1><p>"+clientName+":您好</h1>");
        if(userID!=null){
            out.print("<h2><p>"+getDatabase(Integer.parseInt(userID))+"</h2>");
        }

        out.print("</BODY></HTML>");
        out.close();
    }

}
