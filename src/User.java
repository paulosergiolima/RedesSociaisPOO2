import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID id;
    private String userName;
    private String nickName;
    private String email;
    private String pronouns;
    private String profileDescription;
    private boolean accountPrivacy; 
    private LocalDateTime creationDate;

    private ArrayList<User> followers; 
    private ArrayList<User> following;
    private Set<User> blockedUsers; // evita duplicatas e é mais eficiente nesse caso
    private ArrayList<Post> userPost; 


    public User(UUID id, String userName, String nickName, String email, String pronouns, String profileDescription, boolean accountPrivacy, LocalDateTime creationDate, ArrayList<User> followers, ArrayList<User> following, Set<User> blockedUsers, ArrayList<Post> userPost) {
        this.id = UUID.randomUUID();
        this.userName = userName;
        this.nickName = nickName;
        this.email = email;
        this.pronouns = pronouns;
        this.profileDescription = profileDescription;
        this.accountPrivacy = accountPrivacy;
        this.creationDate = creationDate;

        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.blockedUsers = new HashSet<>();
        this.userPost = new ArrayList<>();
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

    public boolean isAccountPrivacy() {
        return accountPrivacy;
    }

    public void setAccountPrivacy(boolean accountPrivacy) {
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
