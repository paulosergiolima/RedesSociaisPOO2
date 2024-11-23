package com.perdi.backend.postpkg;

import java.util.UUID;

public class VideoPost extends Post  {
    private String url_video;

    public VideoPost(UUID postUserID, String postText, String url_video) {
        super(postUserID);
        this.url_video = url_video;
    }
    public String getUrl_video() {
        return this.url_video;
    }
    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

    @Override
    public Object getContent() {
        return null;
    }

    @Override
    public void setContent(Object content) {

    }
}
