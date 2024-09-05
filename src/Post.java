import java.time.LocalDateTime;
import java.util.UUID;

// @author Abigail Sayury

public class Post {
    private Usuario postUser;
    private UUID postID;
    private LocalDateTime postDate;
    private String postText;

    private boolean domainFlag;
    private Group postDomain;

    private boolean editFlag;
    private LocalDateTime editDate;

    // Constructor

    public Post(Usuario postUser, String postText) {
        setPostUser(postUser); // set user
        this.postText = postText; // set test, universal.
        postDate = LocalDateTime.now(); // set hour.
        setPostID(UUID.randomUUID()); // rando generated ID.

    }

    // Methods:

    public void showPost() {
        System.out.println(postUser.getNickName() + " at " + postDate);
        System.out.println(postText);
    }

    // getters & setters

    public Usuario getPostUser() {
        return postUser;
    }

    private void setPostUser(Usuario postUser) {
        this.postUser = postUser;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public UUID getPostID() {
        return postID;
    }

    private void setPostID(UUID postID) {
        this.postID = postID;
    }

    public boolean isDomainFlag() {
        return domainFlag;
    }

    public void setDomainFlag(boolean domainFlag) {
        this.domainFlag = domainFlag;
    }

    public Group getPostDomain() {
        return postDomain;
    }

    public void setPostDomain(Group postDomain) {
        this.postDomain = postDomain;
    }

    public boolean isEditFlag() {
        return editFlag;
    }

    public void setEditFlag(boolean editFlag) {
        this.editFlag = editFlag;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }
}