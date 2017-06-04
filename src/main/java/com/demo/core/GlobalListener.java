package com.demo.core;

import com.demo.util.DbUtil;
import com.demo.util.ResourceVerifyUtil;
import com.demo.util.SpringContextUtil;
import com.demo.util.Tools;
import org.apache.commons.io.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by richard on 2017/6/4.
 */
public class GlobalListener  implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
//        String web_inf = sce.getServletContext().getRealPath("/WEB-INF/");
//        try {
//            System.out.println(web_inf);
//            Tools.setMainHtml(FileUtils.readFileToString(new File(web_inf+"/main.html"),"utf8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Tools.setWebPath(web_inf);


//        ApplicationContext context1=SpringContextUtil.getContext();
        try {
//            DbUtil.init();

            ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"beans.xml"});
            SpringContextUtil.setContext(context);

            ResourceVerifyUtil.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DbUtil.close();
    }
}
