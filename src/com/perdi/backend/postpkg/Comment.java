package com.perdi.backend.postpkg;

/**
 * @author arthu
 */

import java.util.ArrayList;
import java.util.UUID;



public class Comment {
    //constantes
    private static final int MAX_SIZE = 300;
    private static final int MAX_DEPTH = 1;

    //atributos
    private ArrayList<Post> comments;
    private Comment subcomment;
    private int depth;

    //construtor
    Comment(int depth)
    {
        this.comments = new ArrayList<Post>();
        this.depth = depth;
        if(depth < MAX_DEPTH)
        {
            subcomment = new Comment(this.depth+1);
        }
    }


    //getters
    public Comment getSubComments()
    {
        return this.subcomment;
    }

    public int getCommentsSectionSize()
    {
        return this.comments.size();
    }
    public int getSubCommentsSectionSize()
    {
        return this.subcomment.getCommentsSectionSize();
    }

    //adicao de comentarios na lista
    public boolean addComment(Post post)
    {
        if(comments.size() < MAX_SIZE)
        {
            comments.add(post);
            return true;
        }
        return false;
    }

    //adicao de subcommentarios
    public boolean addSubComment(Post post)
    {
        if(subcomment.getCommentsSectionSize() < MAX_SIZE)
        {
            return subcomment.addComment(post);
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

    //remocao de subcomentario
    public boolean removeSubComment(UUID targetPostID){
        return subcomment.removeComment(targetPostID);
    }
}