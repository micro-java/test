import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by richard on 2017/6/1.
 */
public class SimpleServlet01 implements Servlet {
    public void init(ServletConfig config) throws ServletException{
        System.out.println("init");
    }

    public void service(ServletRequest req, ServletResponse res)
            throws ServletException, IOException{
        System.out.println("begin service");
        PrintWriter out=res.getWriter();
        out.println("hello begin");
        out.print("sfdsjlf");
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

}
