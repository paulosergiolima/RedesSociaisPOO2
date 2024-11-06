package com.perdi.backend.message;

import java.time.LocalDateTime;

import User;

public class Message {
    private String content;
    private User sender;
    private LocalDateTime date;
    private boolean editFlag;
    private LocalDateTime editDate;

    public Message(String content, User sender, LocalDateTime date) {
        this.content = content;
        this.sender = sender;
        this.date = date;
        this.editFlag = false;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setEditFlag(boolean editFlag) {
        this.editFlag = editFlag;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }
}
