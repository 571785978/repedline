package com.example.reptile.netease.entity;

public class SongDetail {
    private String id;

    private String name;

    private String singer;

    private String album;

    private String img_url;

    private String href;

    private String albumId;

    private String playIds;

    public String getPlayIds() {
        return playIds;
    }

    public void setPlayIds(String playIds) {
        this.playIds = playIds;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public String getAlbum() {
        return album;
    }

    public String getImg_url() {
        return img_url;
    }
}
