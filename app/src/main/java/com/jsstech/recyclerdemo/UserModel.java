package com.jsstech.recyclerdemo;

public class UserModel {
    private String url;
    private String explanation;


    public UserModel(String url,String explanation) {
        this.url = url;
        this.explanation=explanation;
    }

    public UserModel() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return explanation;
    }

    public void setDescription(String explanation) {
        this.explanation = explanation;
    }
}

