package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import com.example.reptile.netease.service.NeteaseMusicService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MusicController {

    @Autowired
    NeteaseMusicService neteaseMusicService;

    private static final String SUCCESS_CODE = "200";
    private static final String SUCCESS_MESSAGE = "success";


    @GetMapping("/platListPage")
    public Map<String,Object> playListPage(int page,int limit){
        List<PlayList> data =  neteaseMusicService.playListPage(page,limit);
        int count = neteaseMusicService.totalCountPlayList();
        return response(SUCCESS_CODE,SUCCESS_MESSAGE,data,count);
    }

    @GetMapping("/songLIst")
    public Map<String,Object> songLIst(int page,int limit){
        List<SongDetail> data = neteaseMusicService.songPage(page,limit);
        int count = neteaseMusicService.totalCountSongList();
        return response(SUCCESS_CODE,SUCCESS_MESSAGE,data,count);
    }

    @GetMapping("/playListSong")
    public Map<String,Object> playListSong(String listId){
        List<SongDetail> data = neteaseMusicService.listSongPage(listId);
        return response(SUCCESS_CODE,SUCCESS_MESSAGE,data,data.size());
    }

    private Map<String,Object> response(String code,String result,List<?> data ,int count){
        Map<String,Object> resPonse = new HashMap<>();
        resPonse.put("code","200");
        resPonse.put("msg","success");
        resPonse.put("data",data);
        resPonse.put("count",count);
        return resPonse;
    }

}
