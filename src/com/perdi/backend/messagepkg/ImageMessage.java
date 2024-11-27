package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import java.util.UUID;

import com.perdi.backend.userpkg.User;

public class ImageMessage extends Message {

    private String url_image;

    public ImageMessage(UUID senderID, UUID recipentID, String url_image) {
        super(senderID, recipentID);
        setUrl_image(url_image);
    }

    @Override
    public Object getContent() {
        return url_image;
    }

    @Override
    public void setContent(Object content) {
        if (content instanceof String string) {
            setUrl_image(string);
        } else {
            System.out.println("Conteúdo Inválido");
        }
    }

    public String getUrl_image() {
        return url_image;
    }

    private void setUrl_image(String url_image) {
        this.url_image = url_image;
    }
}
