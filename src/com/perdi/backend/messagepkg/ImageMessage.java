package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import com.perdi.backend.userpkg.User;

public class ImageMessage extends Message {

    private String url_image;

    public ImageMessage(User sender, LocalDateTime date, String url_image) {
        super(sender, date);
        this.url_image = url_image;
    }

    @Override
    public void setContent(String url_video) {
        this.url_image = url_image;
    }

    public String getUrl_image() {
        return url_image;
    }
}
