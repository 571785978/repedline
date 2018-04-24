package com.example.reptile.netease.piepeline;

import com.example.reptile.netease.resolve.song;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.springframework.stereotype.Component;

@Component
@PipelineName("songPipeline")
public class SongPipeline implements Pipeline<song> {
    @Override
    public void process(song song) {
       if(null != song && null != song.getHref()){
           HttpRequest request = song.getRequest();
           String baseUrl = "https://music.163.com";
            song.getHref().forEach(href -> {
                SchedulerContext.into(request.subRequest(baseUrl + href));
            });
       }
    }
}
