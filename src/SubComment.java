/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDateTime;

public class SubComment extends Post{
    //construtor
    SubComment(Usuario postUser, String postText)
    {
        //WIP pd mudar sla oq esta acontecendo
        super(postUser, postText);
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