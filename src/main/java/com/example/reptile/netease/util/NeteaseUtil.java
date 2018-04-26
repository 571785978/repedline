package com.example.reptile.netease.util;

import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * 网易音乐
 */
public class NeteaseUtil {

    static Logger logger = LoggerFactory.getLogger(NeteaseUtil.class);

    public static volatile Map<String,String> map;

    public static volatile List<PlayList> playLists;

    public static volatile List<SongDetail> songList;

    static {
        map = Collections.synchronizedMap(new HashMap<String,String>());
        playLists = new Vector<>();
        songList = new Vector<>();
    }

    public static void putValue(String key,String value){
//        logger.info("key:{},value:{}",key,value);
        map.put(key,value);
    }

    public static String getValue(String key){
//        logger.info("获取歌单ID,key:{},value:{}",key,map.get(key));
        return map.get(key);
    }

}
