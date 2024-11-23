package com.perdi.backend.postpkg;

/**
 * @author arthur
 */

import java.util.ArrayList;
import java.util.UUID;

import com.perdi.backend.postpkg.Post;

/*
*      Modelo do comentario:
*      Como deve ser usado no codigo
*          descricao da funcao
*
*       Comentario(atributo de post).addComment(Post post);
*           Adiciona um post para a lista de comentarios
*
*       Comment
*
*/

public class Comment {
    //constantes
    private static final int MAX_SIZE = 300;

    //atributos
    private Post content;
    private ArrayList<Comment> subcomment;
    private int depth;

    //construtor
    Comment(Post content)
    {
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
    public boolean addSubComment(Post post)
    {
        if(subcomment.size() < MAX_SIZE)
        {
            return subcomment.add(new Comment(post, depth+1));
        }
        return false;
    }

    //remocao de subcomentario
    public boolean removeSubComment(UUID targetPostID){
        for( int i = 0; i < subcomment.size(); i++ ){
            if( subcomment.get(i).getPostID().equals(targetPostID)  ){
                subcomment.remove(i);
                return true;
            }
        }
        return false;
    }

}