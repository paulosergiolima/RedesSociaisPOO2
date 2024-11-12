package com.perdi.backend.messagepkg;

import java.time.LocalDateTime;
import com.perdi.backend.userpkg.User;

public class TextMessage extends Message {

    private String text;
    private boolean editFlag;
    private LocalDateTime editDate;

    public TextMessage(User sender, LocalDateTime date, String text) {
        super(sender, date);
        this.text = text;
        this.editFlag = false;
    }

    @Override
    public void setContent(String text) {
        this.text = text;
    }

    public void setEditFlag(boolean editFlag) {
        this.editFlag = editFlag;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }
}
