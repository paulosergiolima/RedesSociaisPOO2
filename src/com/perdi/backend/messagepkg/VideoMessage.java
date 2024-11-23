package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import com.perdi.backend.userpkg.User;

public class VideoMessage extends Message {
    
    private String url_video;

    public VideoMessage(User sender, LocalDateTime date, String url_video) {
        super(sender, date);
        this.url_video = url_video;
    }

    @Override
    public void setContent(String url_video) {
        this.url_video = url_video;
    }

    public String getUrl_video() {
        return url_video;
    }
}
