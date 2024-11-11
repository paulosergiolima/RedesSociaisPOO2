package com.perdi.backend.userpkg;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.perdi.backend.postpkg.Post;

public class User {
    private UUID id;
    private String userName;
    private String nickName;
    private String email;
    private String pronouns;
    private String profileDescription;
    private Boolean accountPrivacy; 
    private LocalDateTime creationDate;

    private ArrayList<User> followers; 
    private ArrayList<User> following;
    private Set<User> blockedUsers; // evita duplicatas e é mais eficiente nesse caso
    private ArrayList<Post> userPost; 


    public User(UUID id, String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy, LocalDateTime creationDate, ArrayList<User> followers, ArrayList<User> following, Set<User> blockedUsers, ArrayList<Post> userPost) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.pronouns = pronouns;
        this.profileDescription = profileDescription;
        this.accountPrivacy = accountPrivacy;
        this.creationDate = LocalDateTime.now();

        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.blockedUsers = new HashSet<>();
        this.userPost = new ArrayList<>();
    }
    
    
    // Editar perfil
    private void editProfile(String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy){
        // se o parâmetro for nulo, significa que o usuário não quer alterar esse parâmetro
        if(userName != null){
            setUserName(userName);
        }

        if(nickName != null){
            setNickName(nickName);
        }

        if(email != null){
            setEmail(email);
        }

        if(pronouns != null){
            setPronouns(pronouns);
        }

        if(profileDescription != null){
            setProfileDescription(profileDescription);
        }

        if(accountPrivacy != null){
            setAccountPrivacy(accountPrivacy);
        }
    }

    // Possibilidade de seguir um novo usuário
    public void followUser(User user){
        if(user == null || blockedUsers.contains(user)){ // usuário não existe ou está bloqueado
            return;
        }

        // função inspirada na do Arthur + Miguel
        if(!this.equals(user)){ // evita que o usuário siga a si mesmo
            this.following.add(user);
            user.followers.add(this);
        }
    }

    public void removeFollower(User user){
        if(user == null){
            return;
        }

        if(followers.contains(user)){
            followers.remove(user);
            user.following.remove(this);
        }

        return;
    }

    public int followersQuantity(){
        return followers.size();
    }

    public int followingQuanitty(){
        return following.size();
    }

    // Bloquear outro usuário
    public void blockUser(User user){
        if(user == null){
            return;
        }

        blockedUsers.add(user);
        following.remove(user);
        followers.remove(user);

        // o this se refere ao próprio objeto (isabella help)
        user.followers.remove(this);
        user.following.remove(this);
    }

    public void unblockUser(User user){
        if(user == null){ 
            return; 
        }

        if(!blockedUsers.contains(user)){ // ()== false) usuário não está bloqueado
            return;
        }

        blockedUsers.remove(user);

        // não necessariamente o usuário quer seguir e ser seguido
        return; 
    }

    // Adicionar post
    public void addPost(String postText){
        Post newPost = new Post(this, postText);
        userPost.add(newPost);

        return;
    }

    // Remover post
    public void removePost(UUID postID){ // procura o post pelo seu ID

        Post postToRemove = null;

        // vasculhar cada um dos posts procurando pelo ID
        for(int i = 0; i < userPost.size(); i++){ 
            if(userPost.get(i).getPostID().equalsIgnoreCase(postID)){ // encontrou o post
                postToRemove = userPost.get(i); // posição do post
                break; // não precisa continuar a iteração 
            }
        }

        if(postToRemove == null){ // não encontrou
            return;
        }else{
            userPost.remove(postToRemove); // remove o post
            return;
        }
    }
    
    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPronouns() {
        return pronouns;
    }

    public void setPronouns(String pronouns) {
        this.pronouns = pronouns;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public Boolean isAccountPrivacy() {
        return accountPrivacy;
    }

    public void setAccountPrivacy(Boolean accountPrivacy) {
        this.accountPrivacy = accountPrivacy;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public Set<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(Set<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public ArrayList<Post> getUserPost() {
        return userPost;
    }

    public void setUserPost(ArrayList<Post> userPost) {
        this.userPost = userPost;
    }
    
    
    
}
