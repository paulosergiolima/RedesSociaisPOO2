package com.perdi.backend.postpkg;

/**
 * @author arthu
 */

 import java.time.LocalDateTime;

 public class SubComment extends Post{
     //construtor
     SubComment(User postUser, String postText)
     {
         super(postUser, postText);
     }
 
     //seters
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
 }