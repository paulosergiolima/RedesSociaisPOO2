import java.time.LocalDateTime;
import java.util.ArrayList;

public class Usuario {
    private String userName;
    private String nickName;
    private String email;
    private String pronouns;
    
    private String profileDescription;
    // private profilePicture;
    
    private int followers;
    private int following;
    
    private boolean accountPrivacy; 
    private LocalDateTime creationDate;
    
    // private Post post;
    private int postsQuantity;
    private ArrayList<Usuario> friends = new ArrayList<Usuario>();
    
    public Usuario(String userName, String nickName, String email, String pronouns, String profileDescription, int followers, int following, boolean accountPrivacy, LocalDateTime creationDate, int postsQuantity){
        setUserName(userName);
        setNickName(nickName);
        setEmail(email);
        setPronouns(pronouns);
        
        setProfileDescription(profileDescription);
        
        setFollowers(followers);
        setFollowing(following);
        
        setAccountPrivacy(accountPrivacy);
        setCreationDate(creationDate);
        
        setPostsQuantity(postsQuantity);
    }
    
    // Getters e Setters
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setNickName(String nickName){
        this.nickName = nickName;
    }
    
    public String getNickName(){
        return userName;
    }
    
    public void setEmail(String email){
        this.email = email; 
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setPronouns(String pronouns){
        this.pronouns = pronouns;
    }
    
    public String getPronouns(){
        return pronouns;
    }
    
    public void setProfileDescription(String profileDescription){
        this.profileDescription = profileDescription;
    }
    
    public String getProfileDescription(){
        return profileDescription;
    }
    
    public void setFollowers(int followers){
        this.followers = followers;
    }
    
    public int getFollowers(){
        return followers;
    }
    
    public void setFollowing(int following){
        this.following = following;
    }
    
    public int getFollowing(){
        return following;
    }
    
    public void setAccountPrivacy(boolean accountPrivacy){
        this.accountPrivacy = accountPrivacy;
    }
    
    public boolean getAccountPrivacy(){
        return accountPrivacy;
    }
    
    public void setCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
    }
    
    public LocalDateTime getCreationDate(){
        return creationDate;
    }
    
    public void setPostsQuantity(int postsQuantity){
        this.postsQuantity = postsQuantity;
    }
    
    public int getPostsQuantity(){
        return postsQuantity;
    }
    
    public void setFriends(ArrayList<Usuario> friends) {
        this.friends = friends;
    }
    
    public ArrayList<Usuario> getFriends() {
        return friends;
    }

}
