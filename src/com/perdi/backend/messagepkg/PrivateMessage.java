package com.perdi.backend.messagepkg;

import java.util.ArrayList;
import java.time.LocalDateTime;
import com.perdi.backend.userpkg.User;

public class PrivateMessage {
    
    private User contact;
    private ArrayList<Message> messages;
    
    public PrivateMessage(User contact) {
        this.contact = contact;
        this.messages = new ArrayList<>();
    }
    
    public void newTextMessage(User user, String text) {
        Message message = new TextMessage(user, LocalDateTime.now(), text);
        messages.add(message);
    }

    public void newImageMessage(User user, String url_image) {
        Message message = new TextMessage(user, LocalDateTime.now(), url_image);
        messages.add(message);
    }

    public void newVideoMessage(User user, String video_url) {
        Message message = new VideoMessage(user, LocalDateTime.now(), url_video);
        messages.add(message);
    }
    
    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public void editTextMessage(Message message, String newText, LocalDateTime editDate) {
        if(message instanceof TextMessage) {
            message.setContent(newText);
            message.setEditFlag(true);
            message.setEditDate(editDate);
        }
    }
    
    public Usuario getContact() {
        return contact;
    }
    
    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    public void setContact(User contact) {
        this.contact = contact;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}
