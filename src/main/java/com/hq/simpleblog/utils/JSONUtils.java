package com.hq.simpleblog.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * JSON 工具类
 *
 * @author HQ
 * @version v1.0
 * @since 2020/3/22 16:17
 **/
public class JSONUtils {

    /**
     * 将类对象转换成JSONArray
     *
     * @param object: 要转换的类对象
     * @author HQ
     * @since 2020/3/22 16:18
     **/
    public static JSONArray getJSONArray(Object object) {
        return JSONArray.parseArray(JSONArray.toJSONString(object));
    }

    /**
     * 将类对象转换成JSONObject
     *
     * @param object: 要转换的类对象
     * @author HQ
     * @since 2020/3/22 16:19
     **/
    public static JSONObject getJSONObject(Object object) {
        return JSONObject.parseObject(JSONObject.toJSONString(object));
    }

}
