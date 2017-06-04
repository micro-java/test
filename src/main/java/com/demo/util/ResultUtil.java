package com.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by richard on 2017/6/4.
 */
public class ResultUtil {

    private static final String RESULT = "result";
    private static final String KEY = "key";
    private static final String QUERY = "query";
    private static final String CODE = "code";
    private static final String MSG = "msg";

    public static Map<String, Object> wrapResult(String key, Object result, Object query) {
        Map<String, Object> rs = new HashMap<String, Object>();
        rs.put(RESULT, result);
        rs.put(QUERY, query);
        rs.put(KEY, key);
        rs.put(CODE, "1");
        return rs;
    }

    public static Map<String, Object> wrapErrorResult(String key, Object query, ProjException e) {
        Map<String, Object> rs = new HashMap<String,Object>();
        rs.put(QUERY, query);
        rs.put(KEY, key);
        rs.put(CODE, e.getCode());
        rs.put(MSG, e.getMsg());
        return rs;
    }

}
