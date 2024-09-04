/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class SubComment extends Post{
    //construtor
    SubComment(Usuario postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain)
    {
        //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
        super(postUser, postDate, postText, postID, postFlag, postDomain, false, null);
    }

    //seters
    public boolean setSubCommentText(String newText)
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
}