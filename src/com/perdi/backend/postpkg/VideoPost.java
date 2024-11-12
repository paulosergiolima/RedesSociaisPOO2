package com.perdi.backend.postpkg;
public class VideoPost extends PostWithCommentSection  {
    private String url_video;

    public VideoPost(User postUser, String postText, String url_video) {
        super(postUser, postText);
        this.url_video = url_video;
    }
    public String getUrl_video() {
        return this.url_video;
    }
    public void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
}
