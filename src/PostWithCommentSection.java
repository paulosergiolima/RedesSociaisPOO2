/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDateTime;

public abstract class PostWithCommentSection extends Post{
    //constantes
    private static final int TAMANHO_MAX = 300;


    //atributos
    private ArrayList<Comment> comments;


    //construtor
    PostWithCommentSection(Usuario postUser, String postText)
    {
        //WIP pd mudar sla oq esta acontecendo
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
    //WIP pd mudar sla oq esta acontecendo
    public boolean addComment(Usuario postUser, String postText)
    {
        if(comments.size() < TAMANHO_MAX)
        {
            //WIP pd mudar sla oq esta acontecendo
            Comment newComment = new Comment(postUser, postText);
            comments.add(newComment);
            return true;
        }
        return false;
    }


    //remocao de comentarios na lista
    public boolean removeComment(String targetPostID){
        for( int i = 0; i < comments.size(); i++ ){
            if( comments.get(i).getPostID().equals(targetPostID)  ){
                comments.remove(i);
                return true;
            }
        }
        return false;
    }



}
