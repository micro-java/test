package com.demo.util;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by richard on 2017/6/4.
 */
public class ProjException extends RuntimeException {
    private String msg;
    private int code;

    public ProjException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ProjException get(Throwable e){
        return new ProjException(e);
    }
    public ProjException(Throwable e) {
        // 判断基本的类型异常,
        // 9xx 响应结果数据异常 IllegalFormatException
        // 8xx Mysql数据库
        // 7xx 请求参数校验异常 IllegalArgumentException
        // 6xx

        if (e instanceof InvocationTargetException) {
            if (((InvocationTargetException) e).getTargetException() instanceof IllegalArgumentException) {
                code = 900;
                msg = "param  correct:" + ((InvocationTargetException) e).getTargetException().getMessage();
            } else if (((InvocationTargetException) e).getTargetException().getMessage().contains("SQL syntax")) {
                code = 800;
                msg = "mysql param exception ,illegal operate!";
            } else {
                code = 900;
                msg = "request exception:" + e.getMessage();
                e.printStackTrace();
            }
        } else if (e instanceof NoSuchMethodException) {
            code = 500;
            msg = "can not find method:" + e.getMessage();
        } else if (e instanceof RuntimeException){
            code =  600;
            msg = "error param:" + e.getMessage();
        } else {
            code =  600;
            msg = "request exception:" + e.getMessage();
            e.printStackTrace();
        }


    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
