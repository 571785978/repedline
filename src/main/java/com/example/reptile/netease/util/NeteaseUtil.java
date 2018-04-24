package com.example.reptile.netease.util;


import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * 网易音乐
 */
public class NeteaseUtil {

    static Logger logger = LoggerFactory.getLogger(NeteaseUtil.class);
    static Invocable inv;

    static{
        try {
            Path path = Paths.get("classpath:static/youkaPlayer/js/core.js");
            byte [] bytes = Files.readAllBytes(path);
            String js = new String(bytes);
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            inv = (Invocable) engine.eval(js);
            logger.info("初始化引擎成功");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ScriptException e){
            e.printStackTrace();
        }
    }

    public static HashMap<String,String> getDatas(String paras){
        try {
            ScriptObjectMirror so = (ScriptObjectMirror) inv.invokeFunction("myFunc",paras);
            HashMap<String,String> datas = new HashMap();
            datas.put("params",so.get("encText").toString());
            datas.put("encSecKey",so.get("encSeckey").toString());
            return datas;
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

}
