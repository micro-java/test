package servlet;

import java.io.*;

/**
 * Created by richard on 2017/5/28.
 */
public class Servlet001 extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String clientName=request.getParameter("clientName");
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
        out.print("</BODY></HTML>");
        out.close();
    }
}
