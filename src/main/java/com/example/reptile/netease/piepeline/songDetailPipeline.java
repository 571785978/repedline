package com.example.reptile.netease.piepeline;

import com.example.reptile.netease.entity.SongDetail;
import com.example.reptile.netease.resolve.songDetail;
import com.example.reptile.netease.service.NeteaseMusicService;
import com.example.reptile.netease.util.NeteaseUtil;
import com.example.reptile.netease.util.SpringUtil;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.springframework.stereotype.Component;

@Component
@PipelineName("songDetailPipeline")
public class songDetailPipeline implements Pipeline<songDetail> {
    @Override
    public void process(songDetail songDetail) {
        NeteaseMusicService neteaseMusicService = (NeteaseMusicService) SpringUtil.getBean("neteaseMusicService");
        //url可能会变
        String url = "http://music.163.com/song/media/outer/url?id="+songDetail.getId()+".mp3";
        SongDetail detail = new SongDetail();
        detail.setAlbum(songDetail.getAlbum());
        detail.setName(songDetail.getName());
        detail.setId(songDetail.getId());
        detail.setHref(url);
        detail.setSinger(songDetail.getSinger());
        detail.setImg_url(songDetail.getImg_url());
        String albumId = songDetail.getAlbumId().split("id=")[1];
        detail.setAlbumId(albumId);
        NeteaseUtil.songList.add(detail);
        if(NeteaseUtil.songList.size() >=100){
            neteaseMusicService.insertSong(NeteaseUtil.songList);
            NeteaseUtil.songList.clear();
        }
    }
}
