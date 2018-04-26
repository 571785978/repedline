package com.example.reptile.netease.mapper.provider;

import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import com.example.reptile.netease.util.NeteaseUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class NeteaseMusicProvider {

    static Logger logger = LoggerFactory.getLogger(NeteaseMusicProvider.class);

    public String batchInsertPlayList(@Param("list")List<PlayList> list){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("REPLACE into songlist (id,url,title,img_url) values");
        list.forEach(playList -> {
            stringBuffer.append("(");
            stringBuffer.append("\"").append(getReplace(playList.getUrl())).append("\",")
                    .append("\"").append(getReplace(playList.getUrl())).append("\",")
                    .append("\"").append(getReplace(playList.getTitle())).append("\",")
                    .append("\"").append(getReplace(playList.getImg_url())).append("\"");
            stringBuffer.append("),");
        });
        String sql = stringBuffer.substring(0,stringBuffer.length()-1);
        logger.debug(sql);
        return sql;
    }

    public String batchInsertSong(@Param("list")List<SongDetail> list){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("REPLACE into song values");
        //#{id},#{name},#{href},#{singer},#{album},#{img_url},#{albumId},#{playIds}
        list.forEach(song -> {
            stringBuffer.append("(");
            stringBuffer.append("\"").append(getReplace(song.getId())).append("\",")
                    .append("\"").append(getReplace(song.getName())).append("\",")
                    .append("\"").append(getReplace(song.getHref())).append("\",")
                    .append("\"").append(getReplace(song.getSinger())).append("\",")
                    .append("\"").append(getReplace(song.getAlbum())).append("\",")
                    .append("\"").append(getReplace(song.getImg_url())).append("\",")
                    .append("\"").append(getReplace(song.getAlbumId())).append("\",")
                    .append("\"").append(NeteaseUtil.getValue(song.getId())).append("\"");
            stringBuffer.append("),");
        });
        String sql =stringBuffer.substring(0,stringBuffer.length()-1);
        logger.debug(sql);
        return sql;
    }

    private String getReplace(String str){
        return str.replaceAll("\"","'");
    }


}
