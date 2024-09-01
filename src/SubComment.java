/**
 * @author arthu
 */

import java.util.ArrayList;
import java.time.LocalDate;

public class SubComment extends Post{
    SubComment()
    {
        //WIP mudar os ultimos dois parametros(editFlag e editDate), que estao atualmente presentes, pois n vi o codigo do post
        super(User postUser, LocalDateTime postDate, String postText, String postID, boolean postFlag, Group postDomain, false, null);
    }
}