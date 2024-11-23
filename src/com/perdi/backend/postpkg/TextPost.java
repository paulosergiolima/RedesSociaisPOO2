package com.perdi.backend.postpkg;

import com.perdi.backend.grouppkg.Group;

import java.util.UUID;

public class TextPost extends Post {
    private String postTextContent;

    public TextPost(UUID postUserID, String postTextContent) {
        super(postUserID);
        setPostTextContent(postTextContent);
    }

    public TextPost(UUID postUserID, Group postGroup, String postTextContent) {
        super(postUserID, postGroup);
        setPostTextContent(postTextContent);
    }

    @Override
    public Object getContent() {
        return postTextContent;
    }

    @Override
    public void setContent(Object content) {
        if (content instanceof String string) {
            setPostTextContent(string);
            markAsEdited();
        } else {
            System.out.println("Conteúdo Inválido");
        }
    }

    public String getPostTextContent() {
        return postTextContent;
    }

    private void setPostTextContent(String postTextContent) {
        this.postTextContent = postTextContent;
    }


}
