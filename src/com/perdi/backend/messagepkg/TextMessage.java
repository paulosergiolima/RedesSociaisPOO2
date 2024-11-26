package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import java.util.UUID;

import com.perdi.backend.userpkg.User;

public class TextMessage extends Message {

    private String messageTextContent;

    public TextMessage(UUID senderID, UUID recipientID, String messageTextContent) {
        super(senderID, recipientID);
        setMessageTextContent(messageTextContent);
    }

    @Override
    public Object getContent() {
        return messageTextContent;
    }

    @Override
    public void setContent(Object content) {
        if (content instanceof String string) {
            setMessageTextContent(string);
        } else {
            System.out.println("Conteúdo Inválido");
        }
    }

    public String getMessageTextContent() {
        return messageTextContent;
    }

    private void setMessageTextContent(String messageTextContent) {
        this.messageTextContent = messageTextContent;
    }
}
