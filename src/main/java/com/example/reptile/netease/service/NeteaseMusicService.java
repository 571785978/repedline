package com.example.reptile.netease.service;

import com.example.reptile.netease.entity.SongDetail;
import com.example.reptile.netease.mapper.NeteaseMusicDao;
import com.example.reptile.netease.entity.PlayList;
import com.example.util.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author
 */
@Service("neteaseMusicService")
public class NeteaseMusicService {

    @Autowired
    NeteaseMusicDao neteaseMusicDao;

    public void saveCloudMusic(List<PlayList> list){
        if(ListUtils.isNotEmpty(list)){
            neteaseMusicDao.insertOrUpdate(list);
        }
    }

    public List<String> getAllPlayListSong(){
        return neteaseMusicDao.getPlayListUrlAll();
    }

    public void insertSong(List<SongDetail> list){
        neteaseMusicDao.insertOrUpdateSong(list);
    }

    public List<PlayList> playListPage(int page,int limit){
        return neteaseMusicDao.playListPage((page-1)*limit,limit);
    }
    public int totalCountPlayList(){
        return neteaseMusicDao.getTotalCountPlayList();
    }

    public int totalCountSongList(){
        return neteaseMusicDao.getTotalCountSongList();
    }

    public List<SongDetail> songPage(int page,int limit){
        return neteaseMusicDao.songListPage((page-1)*limit,limit);
    }

    public List<SongDetail> listSongPage(String listId){
        return neteaseMusicDao.listSongPage(listId);
    }
}
