package com.example.reptile.netease.piepeline;

import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.resolve.SongList;
import com.example.reptile.netease.service.NeteaseMusicService;
import com.example.reptile.netease.util.NeteaseUtil;
import com.example.reptile.netease.util.SpringUtil;
import com.example.util.ListUtils;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.SchedulerContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Component
@PipelineName("PlayListPipeline")
public class PlayListPipeline implements Pipeline<SongList> {

    @Override
    public void process(SongList songList) {
        NeteaseMusicService neteaseMusicService = (NeteaseMusicService) SpringUtil.getBean("neteaseMusicService");
        List<PlayList> list = new ArrayList<>();
        String webSite = "https://music.163.com";
        HttpRequest request = songList.getHttpRequest();
        songList.getList().stream().forEach(songLists -> {
            songLists.getLi().stream().forEach(detail -> {
                PlayList music = new PlayList();
                String id = detail.getUrl().split("\\?id=")[1];
                music.setId(id);
                music.setImg_url(detail.getImageUrl());
                music.setTitle(detail.getTitle());
                music.setUrl(webSite + detail.getUrl());
                list.add(music);
                SchedulerContext.into(request.subRequest(music.getUrl()));
            });
        });
        neteaseMusicService.saveCloudMusic(list);
        if(null != songList && ListUtils.isNotEmpty(list)){
            Integer offset = songList.getOffset();
            String url = "https://music.163.com/discover/playlist?order=hot&cat=全部&limit=35&offset="+(offset+35);
            SchedulerContext.into(request.subRequest(url));
        }
    }


}
