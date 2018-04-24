package com.example.reptile.netease.resolve;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

public class SongLists implements HtmlBean {

    @HtmlField(cssPath = "ul li")
    private List<Detail> li;

    public List<Detail> getLi() {
        return li;
    }

    public void setLi(List<Detail> li) {
        this.li = li;
    }

    @Override
    public String toString() {
        return "SongLists{" +
                "li=" + li +
                '}';
    }
}
