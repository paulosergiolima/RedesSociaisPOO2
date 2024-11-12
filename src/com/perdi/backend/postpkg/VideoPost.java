package com.perdi.backend.postpkg;

import com.perdi.backend.userpkg.User;

public class VideoPost extends Post  {
    private String url_video;

    public VideoPost(User postUser, String postText, String url_video) {
        super(postUser);
        this.url_video = url_video;
    }
    public String getUrl_video() {
        return this.url_video;
    }
    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }

}
