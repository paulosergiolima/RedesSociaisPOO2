package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import java.util.UUID;

import com.perdi.backend.userpkg.User;

public abstract class Message {
    
    private UUID messageID;
    private UUID senderID;
    private UUID recipentID;
    private LocalDateTime sendDate;

    public Message(UUID senderID, UUID recipentID) {
        setMessageID();
        setSenderID(senderID);
        setRecipientID(recipentID);
        setSendDate();
    }

    public abstract Object getContent();

    public abstract void setContent(Object content);

    public UUID getMessageID() {
        return messageID;
    }

    public UUID getSenderID() {
        return senderID;
    }

    public UUID getRecipientID() {
        return recipentID;
    }

    private void setMessageID() {
        this.messageID = UUID.randomUUID();
    }

    private void setSenderID(UUID senderID) {
        this.senderID = senderID;
    }

    private void setRecipientID(UUID recipientID) {
        this.recipentID = recipientID;
    }

    private void setSendDate() {
        this.sendDate = LocalDateTime.now();
    }
}
