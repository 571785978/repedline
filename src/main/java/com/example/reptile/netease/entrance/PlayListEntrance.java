package com.example.reptile.netease.entrance;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import org.springframework.stereotype.Component;

@Component
public class PlayListEntrance {

    public void doReptile(){
        HttpGetRequest startUrl = new HttpGetRequest("https://music.163.com/discover/playlist?order=hot&cat=全部&limit=35&offset=0");
        startUrl.setCharset("utf-8");
        GeccoEngine.create()
                //Gecco搜索的包路径
                .classpath("com.example.reptile.netease")
                //开始抓取的页面地址
                .start(startUrl)
                //开启几个爬虫线程
                .thread(1)
                //单个爬虫每次抓取完一个请求后的间隔时间
                .interval(1000)
                .debug(true)
                .run();
    }

}
