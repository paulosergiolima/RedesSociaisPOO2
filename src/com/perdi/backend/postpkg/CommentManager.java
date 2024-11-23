package com.perdi.backend.postpkg;

import java.util.ArrayList;
import java.util.UUID;

public class CommentManager {
    //constantes
    private static final int MAX_SIZE = 300;

    //atributos
    private ArrayList<Comment> comments;

    public CommentManager() {
        comments = new ArrayList<Comment>();
    }
    //getters
    public Comment getSubComment(UUID uuid)
    {
        for (Comment comment : comments) {
            if (comment.getSubComment(uuid) != null) {
                return comment.getSubComment(uuid);
            }
        }
        return null;
    }

    //adicao de comentario
    public boolean addComment(Post post)
    {
        if(comments.size() < MAX_SIZE)
        {
            return comments.add(new Comment(post));
        }
        return false;
    }

    //adcao de subcomentario
    public void addSubComment(UUID uuid, Post post)
    {
        Comment comment = getSubComment(uuid);
        comment.addSubComment(post);
    }

    //remocao de comentario
    public boolean removeComment(UUID targetPostID){
        for( int i = 0; i < comments.size(); i++ ){
            if( comments.get(i).getPostID().equals(targetPostID)  ){
                comments.remove(i);
                return true;
            }
        }
        return false;
    }
}
