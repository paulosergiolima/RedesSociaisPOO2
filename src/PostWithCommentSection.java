/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class PostWithCommentSection extends Post{
    
    
    //constantes
    private static final int TAMANHO_MAX = 300;


    //atributos
    private ArrayList<Comment> comments;


    //construtor
    PostWithCommentSection()
    {
        //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
        super(User postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain, false, null);
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
    public boolean addComment()
    {
        if(comments.size() < TAMANHO_MAX)
        {
            Comment newComment = new Comment();
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
