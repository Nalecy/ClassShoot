package com.xuhuaixin.classshoot;

public class NewsInfo {
    private String icon;        //图片路径
    private String title;       //新闻标题
    private String content;     //新闻描述
    private int type;           //新闻类型
    private long comment;       //新闻评论数

    public NewsInfo(String icon, String title, String content, int type, long comment) {
        this.icon = icon;
        this.title = title;
        this.content = content;
        this.type = type;
        this.comment = comment;
    }

    public NewsInfo(){

    }

    public String getIcon() {
        return icon;
    }

    public NewsInfo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public NewsInfo setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public NewsInfo setContent(String content) {
        this.content = content;
        return this;
    }

    public int getType() {
        return type;
    }

    public NewsInfo setType(int type) {
        this.type = type;
        return this;
    }

    public long getComment() {
        return comment;
    }

    public NewsInfo setComment(long comment) {
        this.comment = comment;
        return this;
    }
}
