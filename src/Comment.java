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
    Comment()
    {
        super(User postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain, false, null);
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
        //gostaria de montar uma classe de utilidade para fazer verificacao desse tipo (em relacao a validez(n sei se isso eh uma palavra) de uma variavel)
        if(!newText.equals(""))
        {
            setEditFlag(true);
            setEditDate(LocalDate.now());
            setPostText(newText);
            return true;
        }
        return false;
    }


    //adicao de comentarios na lista
    public boolean addSubComment()
    {
        if(comments.size() < TAMANHO_MAX)
        {
            SubComment newSubComment = new SubComment();
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
