package com.example.reptile.netease.resolve;

import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 单曲
 */
@Gecco(matchUrl = "https://music.163.com/playlist?id={id}",
        pipelines = {"songPipeline"})
public class song implements HtmlBean {

    @Request
    HttpRequest request;

    @RequestParameter
    String id;

    @Attr("href")
    @HtmlField(cssPath = "#song-list-pre-cache .f-hide li a")
    private List<String> href;

    public List<String> getHref() {
        return href;
    }

    public void setHref(List<String> href) {
        this.href = href;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }
}
