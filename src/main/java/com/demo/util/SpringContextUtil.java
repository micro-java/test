package com.demo.util;

import org.springframework.context.ApplicationContext;

/**
 * Created by richard on 2017/6/4.
 */
public class SpringContextUtil {
    private static ApplicationContext context=null;
    public static void setContext(ApplicationContext contex) {
        context=contex;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
