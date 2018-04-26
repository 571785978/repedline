package com.example.reptile.netease.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * 网易音乐
 */
public class NeteaseUtil {

    static Logger logger = LoggerFactory.getLogger(NeteaseUtil.class);

    public static Map<String,String> map;

    static {
        map = new HashMap<>();
    }

    public static void putValue(String key,String value){
        map.put(key,value);
    }

    public static String getValue(String key){
        return map.get(key);
    }

}
