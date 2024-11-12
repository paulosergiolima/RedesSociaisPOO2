package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import com.perdi.backend.userpkg.User;

public abstract class Message {
    
    private User sender;
    private LocalDateTime date;

    public Message(User sender, LocalDateTime date) {
        this.sender = sender;
        this.date = date;
    }

    public abstract void setContent();
}
