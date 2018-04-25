package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.service.NeteaseMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PlayListController {

    @Autowired
    NeteaseMusicService neteaseMusicService;

    @GetMapping("/platListPage")
    public Map<String,Object> playListPage(int page,int limit){
        Map<String,Object> resPonse = new HashMap<>();
        List<PlayList> data =  neteaseMusicService.playListPage(page,limit);
        int count = neteaseMusicService.totalCountPlayList();
        resPonse.put("code","200");
        resPonse.put("msg","success");
        resPonse.put("data",data);
        resPonse.put("count",count);
        return resPonse;
    }

}
