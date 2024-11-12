package com.perdi.backend.postpkg;

import com.perdi.backend.userpkg.User;

public class TextPost extends Post {
    private String postTextContent;

    public TextPost(User postUser, String postTextContent) {
        super(postUser);
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
