package com.perdi.backend.feed.postpkg;

import java.util.UUID;

public class TextPost extends Post {
    private String postTextContent;

    public TextPost(UUID postUserID, String postTextContent) {
        super(postUserID);
        setPostTextContent(postTextContent);
    }

    public TextPost(UUID postUserID, UUID postGroupID, String postTextContent) {
        super(postUserID, postGroupID);
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
