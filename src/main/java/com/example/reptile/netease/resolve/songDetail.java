package com.example.reptile.netease.resolve;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl = "https://music.163.com/song?id={id}",
        pipelines = {"consolePipeline","songDetailPipeline"})
public class songDetail implements HtmlBean {

    @RequestParameter
    private String id;

    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.m-lycifo > div.f-cb > div.cnt > div.hd > div > em")
    private String name;

    @Attr("title")
    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.m-lycifo > div.f-cb > div.cnt > p:nth-child(2) > span")
    private String singer;

    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.m-lycifo > div.f-cb > div.cnt > p:nth-child(3) a")
    private String album;

    @Attr("data-src")
    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.m-lycifo > div.f-cb > div.cvrwrap.f-cb.f-pr > div.u-cover.u-cover-6.f-fl > img")
    private String img_url;

    @Attr("href")
    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-mn4 > div > div > div.m-lycifo > div.f-cb > div.cnt > p:nth-child(3) a")
    private String albumId;

    @Attr("href")
    @HtmlField(cssPath = "body > div.g-bd4.f-cb > div.g-sd4 > div.g-wrap7 > ul.m-rctlist.f-cb li div.info p.f-thide a")
    private List<String> playListId;

    public List<String> getPlayListId() {
        return playListId;
    }

    public void setPlayListId(List<String> playListId) {
        this.playListId = playListId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
