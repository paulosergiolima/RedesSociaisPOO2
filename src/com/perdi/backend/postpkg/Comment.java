package com.perdi.backend.postpkg;

/**
 * @author arthur
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;



public class Comment {
    //constantes
    private static final int MAX_SIZE = 300;

    //atributos
    private LocalDateTime date;
    private UUID postUserID;
    private Post content;
    private ArrayList<Comment> subcomment;
    private int depth;

    //construtor
    Comment(UUID postUserIDPost, Post content)
    {
        postUserID = postUserIDPost;
        date = LocalDateTime.now();
        this.content = content;
        this.subcomment = new ArrayList<Comment>();
        this.depth = 0;
    }

    Comment(Post content, int depth)
    {
        this.content = content;
        this.subcomment = new ArrayList<Comment>();
        this.depth = depth;
    }

    //getters
    public UUID getPostID()
    {
        return this.content.getPostID();
    }

    public Comment getSubComment(UUID uuid)
    {
        for (Comment comment : subcomment) {
            if (comment.getPostID().equals(uuid)) {
                return comment;
            }
        }
        return null;
    }

    public ArrayList<Comment> getSubComments()
    {
        return this.subcomment;
    }

    public int getSubCommentsSectionSize()
    {
        return this.subcomment.size();
    }

    //adicao de subcommentarios
    public void addSubComment(Post post)
    {
        if(subcomment.size() < MAX_SIZE)
        {
            subcomment.add(new Comment(post, depth+1));
        }
    }

    //remocao de subcomentario
    public void removeSubComment(UUID targetPostID){
        for( int i = 0; i < subcomment.size(); i++ ){
            if( subcomment.get(i).getPostID().equals(targetPostID)  ){
                subcomment.remove(i);
            }
        }
    }

    public LocalDateTime getDate() {
        return date;
    }

    public UUID getPostUserID() {
        return postUserID;
    }
}