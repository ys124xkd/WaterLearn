package com.example.projectuas.menu;

public class video {
    String title, url,description,chanel;

    public video(String title, String url, String description, String chanel) {
        this.title = title;
        this.url = url;

    }

    public video() {

    }

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
}
