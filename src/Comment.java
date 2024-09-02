/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class Comment extends Post{
    //constantes
    private static final int TAMANHO_MAX = 300;


    //atributos
    private ArrayList<SubComment> subcomments;


    //construtor
    Comment(Usuario postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain)
    {
        //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
        super(postUser, postDate, postText, postID, postFlag, postDomain, false, null);
        subcomments = new ArrayList<SubComment>();
    }


    //getters
    public ArrayList<Comment> getComments()
    {
        return this.subcomments;
    }

    public int getCommentSectionSize()
    {
        return this.subcomments.size();
    }


    //seters
    public boolean setCommentText(String newText)
    {
        //WIP gostaria de montar uma classe de utilidade para fazer verificacao desse tipo (em relacao a validez(n sei se isso eh uma palavra) de uma variavel)
        if(!newText.equals(""))
        {
            super.setEditFlag(true);
            super.setEditDate(LocalDate.now());
            super.setPostText(newText);
            return true;
        }
        return false;
    }


    //adicao de comentarios na lista
    //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
    public boolean addSubComment(Usuario postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain)
    {
        if(comments.size() < TAMANHO_MAX)
        {
            //WIP talvez mude os parametros
            SubComment newSubComment = new SubComment(postUser, postDate, postText, postID, postFlag, postDomain);
            subcomments.add(newSubComment);
            return true;
        }
        return false;
    }


    //remocao de comentarios na lista
    public boolean removeSubComment(String targetPostID){
        for( int i = 0; i < comments.size(); i++ ){
            if( subcomments.get(i).getPostID().equals(targetPostID)  ){
                subcomments.remove(i);
                return true;
            }
        }
        return false;
    }

    
}
