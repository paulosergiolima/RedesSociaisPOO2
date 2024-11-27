package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import java.util.UUID;

import com.perdi.backend.userpkg.User;

public class VideoMessage extends Message {
    
    private String url_video;

    public VideoMessage(UUID senderID, UUID recipientID, String url_video) {
        super(senderID, recipientID);
        setUrl_video(url_video);
    }

    @Override
    public Object getContent() {
        return url_video;
    }

    @Override
    public void setContent(Object content) {
        if (content instanceof String string) {
            setUrl_video(string);
        } else {
            System.out.println("Conteúdo Inválido");
        }
    }

    public String getUrl_video() {
        return url_video;
    }

    private void setUrl_video(String url_video) {
        this.url_video = url_video;
    }
}
