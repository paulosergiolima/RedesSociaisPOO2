/**
 * @author arthu
 */

 import java.util.ArrayList;
 import java.time.LocalDateTime;
 import java.util.UUID;
 
 public class Comment extends Post{
     //constantes
     private static final int TAMANHO_MAX = 300;
 

     //atributos
     private ArrayList<SubComment> subcomments;
 
 
     //construtor
     Comment(User postUser, String postText)
     {
         super(postUser, postText);
         subcomments = new ArrayList<SubComment>();
     }
 
 
     //getters
     public ArrayList<SubComment> getSubComments()
     {
         return this.subcomments;
     }
 
     public int getSubCommentSectionSize()
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
             super.setEditDate(LocalDateTime.now());
             super.setPostText(newText);
             return true;
         }
         return false;
     }
 
 
     //adicao de comentarios na lista
     public boolean addSubComment(User postUser, String postText)
     {
         if(subcomments.size() < TAMANHO_MAX)
         {
             SubComment newSubComment = new SubComment(postUser, postText);
             subcomments.add(newSubComment);
             return true;
         }
         return false;
     }
 
 
     //remocao de comentarios na lista
     public boolean removeSubComment(UUID targetPostID){
         for( int i = 0; i < subcomments.size(); i++ ){
             if( subcomments.get(i).getPostID().equals(targetPostID)  ){
                 subcomments.remove(i);
                 return true;
             }
         }
         return false;
     }
 
     
     //ferramenta de debug
     public void showComment()
     {
         System.out.println("Coments: ");
         showPost();
         System.out.println("SubComents: ");
         for(SubComment subcommentElement: subcomments)
         {
             subcommentElement.showPost();
         }
     }
 }