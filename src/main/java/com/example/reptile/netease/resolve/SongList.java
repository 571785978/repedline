package com.example.reptile.netease.resolve;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

/**
 * 歌单
 * @author
 */
@Gecco(matchUrl = "https://music.163.com/discover/playlist?order=hot&cat=全部&limit=35&offset={offset}",
        pipelines = {"PlayListPipeline"})
public class SongList implements HtmlBean{

    @RequestParameter
    private int offset ;

    @Request
    private HttpRequest httpRequest;

    @HtmlField(cssPath = "#m-disc-pl-c > div")
    private List<SongLists> list;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public HttpRequest getHttpRequest() {
        return httpRequest;
    }

    public void setHttpRequest(HttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    public List<SongLists> getList() {
        return list;
    }

    public void setList(List<SongLists> list) {
        this.list = list;
    }
}
