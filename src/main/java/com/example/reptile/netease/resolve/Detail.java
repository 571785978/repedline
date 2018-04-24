package com.example.reptile.netease.resolve;

import com.geccocrawler.gecco.annotation.Attr;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

public class Detail implements HtmlBean {

    @Attr("href")
    @HtmlField(cssPath = ".u-cover a")
    private String url;

    @Attr("src")
    @HtmlField(cssPath = ".u-cover .j-flag")
    private String imageUrl;

    @Attr("title")
    @HtmlField(cssPath = ".u-cover a")
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "url=" + url +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
