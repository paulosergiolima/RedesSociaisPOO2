/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Comment extends Post{
    //constantes
    private static final int TAMANHO_MAX = 300;


    //atributos
    private ArrayList<SubComment> subcomments;


    //construtor
    Comment(Usuario postUser, String postText)
    {
        //WIP pd mudar sla oq esta acontecendo
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
    //WIP pd mudar sla oq esta acontecendo
    public boolean addSubComment(Usuario postUser, String postText)
    {
        if(comments.size() < TAMANHO_MAX)
        {
            //WIP pd mudar sla oq esta acontecendo
            SubComment newSubComment = new SubComment(postUser, postText);
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
