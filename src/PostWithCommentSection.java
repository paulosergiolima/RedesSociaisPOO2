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
    PostWithCommentSection(Usuario postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain)
    {
        //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
        super(postUser, postDate, postText, postID, postFlag, postDomain, false, null);
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
    //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
    public boolean addComment(Usuario postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain)
    {
        if(comments.size() < TAMANHO_MAX)
        {
            //WIP talvez mude os parametros
            Comment newComment = new Comment(postUser, postDate, postText, postID, postFlag, postDomain);
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
