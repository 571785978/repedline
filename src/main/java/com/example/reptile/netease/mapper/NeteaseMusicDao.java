package com.example.reptile.netease.mapper;

import com.example.base.BaseDao;
import com.example.reptile.netease.entity.PlayList;
import com.example.reptile.netease.entity.SongDetail;
import com.example.reptile.netease.mapper.provider.NeteaseMusicProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NeteaseMusicDao extends BaseDao<SongDetail>{

    @InsertProvider(type = NeteaseMusicProvider.class,method = "batchInsertPlayList")
    void insertOrUpdate(@Param("list")List<PlayList> list);

    @Select("SELECT url from songlist")
    List<String> getPlayListUrlAll();

    @InsertProvider(type = NeteaseMusicProvider.class,method = "batchInsertSong")
    void insertOrUpdateSong(@Param("list")List<SongDetail> list);

    @Select("select * from songlist limit #{page},#{limit}")
    List<PlayList> playListPage(@Param("page") int page, @Param("limit") int limit);

    @Select("select count(*) from songlist")
    int getTotalCountPlayList();

    @Select("select * from song GROUP BY img_url limit #{page},#{limit}")
    List<SongDetail> songListPage(@Param("page") int page, @Param("limit") int limit);

    @Select("select count(*) from song")
    int getTotalCountSongList();

    @Select("SELECT * from song where playIds=#{listId}")
    List<SongDetail> listSongPage(@Param("listId") String listId);

}
