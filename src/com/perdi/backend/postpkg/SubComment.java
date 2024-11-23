package com.perdi.backend.postpkg;

/**
 * @author arthu
 */

 import com.perdi.backend.userpkg.User;

 import java.time.LocalDateTime;

 public class SubComment extends Post{
     //construtor
     SubComment(User postUser)
     {
         super(postUser);
     }

     @Override
     public Object getContent() {
         return null;
     }

     @Override
     public void setContent(Object content) {

     }

     //seters

     /*
     public boolean setSubCommentText(String newText)
     {
         //WIP gostaria de montar uma classe de utilidade para fazer verificacao desse tipo (em relacao a validez(n sei se isso eh uma palavra) de uma variavel)
         if(!newText.equals(""))
         {
             super.setEditFlag(true);
             super.setEditDate(LocalDateTime.now());
             super.setPostText(newText);
             return true;
         }
         return false;
     }

      */
 }