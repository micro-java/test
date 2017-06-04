package com.demo.util;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Created by feiliu on 2017/6/4.
 */
public class ResourceVerifyUtil {
    private static Properties fieldRegular = new Properties();

    private static volatile boolean FLAG = true;

    private static void hanlderError(String title, String msg)
            throws IllegalArgumentException {
        throw new IllegalArgumentException(title + "-->" + msg);
    }

    public static synchronized  void init() {
        if (FLAG){
            //读取配置文件
            try {
                if (fieldRegular == null) fieldRegular = new Properties();
                InputStream inputStream = ResourceVerifyUtil.class.getClassLoader().getResourceAsStream("regularfields.properties");
                if (inputStream != null)
                    fieldRegular.load(inputStream);
            } catch (Exception e) {
                System.out.println(e.getMessage() + " 配置文件加载失败!");
            }
            FLAG = false;
        }

    }

    public static void commonVaild(Map<String, Object> params, String... existField) {
        if (existField != null || existField.length != 0) {
            for (String field : existField) {
                if (!params.containsKey(field)) {
                    hanlderError("Illegal data!", field + " field abnormal input,not exist! ");
                }
            }
        }
        Set<Map.Entry<String, Object>> paramSet = params.entrySet();
        for (Map.Entry<String, Object> param : paramSet) {
            String field = param.getKey();
            Object field_value = param.getValue();
            if (!basicVaild(field, field_value)) {
                String msg = fieldRegular.getProperty(field + "_require", "");
                hanlderError("Illegal data!", field + " field abnormal input. "
                        + msg);
            }
        }
    }


    @SuppressWarnings("unchecked")
    private static boolean basicVaild(String field, Object value) {
        if (value == null) {
            return true;
        }
        if (value.getClass().isAssignableFrom(Map.class)) {
            Map<String, Object> params = ((Map<String, Object>) value);
            Set<Map.Entry<String, Object>> paramSet = params.entrySet();
            for (Map.Entry<String, Object> param : paramSet) {
                if (!basicVaild(param.getKey(), param.getValue())) {
                    return false;
                }
            }
        }
        if (!fieldRegular.containsKey(field)) {
            return true;
        }
        return value.toString().matches(fieldRegular.getProperty(field));
    }
}
