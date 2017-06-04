package com.demo.core;

import com.demo.util.DbUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by richard on 2017/6/4.
 */
public class GlobalListener  implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        try {
            DbUtil.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        DbUtil.close();
    }
}
