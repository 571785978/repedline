package com.example.reptile.netease.mapper;

import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NeteaseMusicDao {

    @Insert("REPLACE into songlist (id,url,title,img_url) values(#{id},#{url},#{title},#{img_url})")
    void insertOrUpdate(PlayList entity);

    @Select("SELECT url from songlist")
    List<String> getPlayListUrlAll();

    @Insert("replace into song values(#{id},#{href},#{singer},#{img_url},#{album})")
    void insertOrUpdateSong(SongDetail songDetail);
}
