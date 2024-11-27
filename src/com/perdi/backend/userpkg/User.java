package com.perdi.backend.userpkg;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

import com.perdi.backend.storage.datapkg.DataCenter;
import com.perdi.backend.feed.postpkg.Post;
// import com.perdi.backend.feed.postpkg.TextPost;

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
    private Set<User> blockedUsers;
    private FollowManager followManager = new FollowersFollowing();
    private BlockManager blockManager = new BlockUser();
    private UserEdit userEdit = new UserEdit();
    
    private ArrayList<Post> userPost;

    private static DataCenter dataCenter = DataCenter.getInstance();

    /**
     * Construtor de User
     * Criar um novo usuário a partir dos dados fornecidos
     *  
     * @param userName nome verdadeiro do usuário
     * @param nickName apelido do usuário para a rede
     * @param email email cadastrado
     * @param pronouns pronome utilizado
     * @param profileDescription descrição do perfil do usuário
     * @param accountPrivacy privacidade da conta, que pode ser pública ou privada
    */ 

    protected User(String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.pronouns = pronouns;
        this.profileDescription = profileDescription;
        this.accountPrivacy = accountPrivacy;
        this.creationDate = LocalDateTime.now();

        this.userPost = new ArrayList<>();

        dataCenter.addUser(this);
    }
    
    
    /**
     * Método para seguir
     * 
     * @param user usuário que irá seguir
     * @return manipulação nos seguidores do usuário
    */
    public boolean follow(User user) {
        return followManager.follow(this, user);
    }

    /**
     * Método para parar de seguir
     * 
     * @param user usuário que quer parar de ser seguido
     * @return deixa de seguir o usuário
     */

    public boolean unfollow(User user) {
        return followManager.unfollow(this, user);
    }

    /***
     * Método para remover seguidor
     * 
     * @param user a pessoa que o usuário quer tirar de seguidor
     * @return remoção do seguidor do usuário
     */

    public boolean removeFollower(User user) {
        return followManager.removeFollower(this, user);
    }

    /**
     * Quantidade de seguidores
     * 
     * @return a quantidade de seguidores do usuário
     */

    public int getFollowersCount() {
        return followManager.getFollowersCount(this);
    }

    /**
     * Quantidade de seguidores
     * 
     * @return quantidade de pessoas que o usuário segue
     */

    public int getFollowingCount() {
        return followManager.getFollowingCount(this);
    }
   
    // Métodos de bloqueio

    /**
     * Método para bloquear usuário
     * 
     * 
     * @param user Usuário a ser bloqueado
     * @return usuário foi bloqueado
    */
    public boolean blockUser(User user) {
        return blockManager.blockUser(this, user);
    }

    /**
     * Método para desbloquear usuário 
     * 
     * @param user usuário a ser debloqueado
     * @return desbloqueio do usuário em questão
     */
    
    public boolean unblockUser(User user) {
        return blockManager.unblockUser(this, user);
    }
    
    /**
     * Verificação de bloqueio de usuário
     * 
     * @param user usuário que foi possivelmente bloqueado
     * @return se o usuário foi bloqueado ou não
     */

    public boolean isUserBlocked(User user) {
        return blockManager.isUserBlocked(this, user);
    }

    /**
     * Editor de usuário
     * Permite que algumas informações sejam alteradas após a criação da conta
     * 
     * @param userName nome verdadeiro do usuário
     * @param nickName apelido do usuário para a rede
     * @param email email cadastrado
     * @param pronouns pronome utilizado
     * @param profileDescription descrição do perfil do usuário
     * @param accountPrivacy privacidade da conta, que pode ser pública ou privada
     */

    public void editUser(String userName, String nickName, String email, String pronouns, String profileDescription, Boolean accountPrivacy){
        userEdit.editUser(this, userName, nickName, email, pronouns, profileDescription, accountPrivacy);
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
