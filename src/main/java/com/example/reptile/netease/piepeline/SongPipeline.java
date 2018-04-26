package com.example.reptile.netease.piepeline;

import com.example.reptile.netease.resolve.song;
import com.example.reptile.netease.util.NeteaseUtil;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@PipelineName("songPipeline")
public class SongPipeline implements Pipeline<song> {
    @Override
    public void process(song song) {
       if(null != song && null != song.getHref()){
           HttpRequest request = song.getRequest();
           StringBuffer buffer = new StringBuffer();
           String playId = request.getUrl().split("id=")[1];
           String baseUrl = "https://music.163.com";
           song.getHref().forEach(href -> {
               String songId = href.split("id=")[1];
               buffer.setLength(0);
               buffer.append(baseUrl).append(href).append("#");
               SchedulerContext.into(request.subRequest(buffer.toString()));
               NeteaseUtil.putValue(songId,playId);
            });
       }
    }
}
