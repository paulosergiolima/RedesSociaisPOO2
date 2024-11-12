package com.perdi.backend.postpkg;
/**
 * @author arthu
 */
import java.util.ArrayList;
import java.util.UUID;

import User;

public abstract class PostWithCommentSection extends Post{
    //constantes
    private static final int TAMANHO_MAX = 300;


    //atributos
    private ArrayList<Comment> comments;


    //construtor
    PostWithCommentSection(User postUser, String postText)
    {
        super(postUser, postText);
        comments = new ArrayList<Comment>();
    }


    //getters
    public ArrayList<Comment> getComments()
    {
        return this.comments;
    }

    public int getCommentSectionSize()
    {
        return this.comments.size();
    }

    //adicao de comentarios na lista
    public boolean addComment(User postUser, String postText)
    {
        if(comments.size() < TAMANHO_MAX)
        {
            Comment newComment = new Comment(postUser, postText);
            comments.add(newComment);
            return true;
        }
        return false;
    }


    //remocao de comentarios na lista
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
