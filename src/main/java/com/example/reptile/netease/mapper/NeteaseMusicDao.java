package com.example.reptile.netease.mapper;

import com.example.base.BaseDao;
import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NeteaseMusicDao extends BaseDao<SongDetail>{

    @Insert("REPLACE into songlist (id,url,title,img_url) values(#{id},#{url},#{title},#{img_url})")
    void insertOrUpdate(PlayList entity);

    @Select("SELECT url from songlist")
    List<String> getPlayListUrlAll();

    @Insert("replace into song values(#{id},#{name},#{href},#{singer},#{album},#{img_url},#{albumId},#{playIds})")
    void insertOrUpdateSong(SongDetail songDetail);

    @Select("select * from songlist limit #{page},#{limit}")
    List<PlayList> list(@Param("page") int page, @Param("limit") int limit);

    @Select("select count(*) from songlist")
    int getTotalCountPlayList();
}
