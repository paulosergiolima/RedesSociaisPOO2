package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import java.util.UUID;

import com.perdi.backend.userpkg.User;

public abstract class Message {
    
    private User sender;
    private LocalDateTime date;
    private UUID messageID;

    public Message(User sender, LocalDateTime date) {
        this.sender = sender;
        this.date = date;
        setMessageID(); // added for the sake of consistency across the project
    }

    public abstract void setContent();

    public UUID getMessageID() {
        return messageID;
    }

    private void setMessageID() {
        this.messageID = UUID.randomUUID();
    }
}
