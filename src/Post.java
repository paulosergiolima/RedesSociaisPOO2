import java.time.*;
import java.util.*;

// @author Abigail Sayury

public class Post {
    private Usuario postUser;
    private UUID postID;
    private LocalDateTime postDate;
    private String postText;
    private ArrayList<Comment> postComments;

    private boolean domainFlag;
    private Group postDomain;

    private boolean editFlag;
    private LocalDateTime editDate;

    // Constructor

    public Post(Usuario postUser, String postText) {
        setPostUser(postUser); // set user
        setPostText(postText); // set test, universal.
        setPostDate(LocalDateTime.now()); // set hour.
        setPostID(UUID.randomUUID()); // rando generated ID.

    }

    // Methods:

    public void getComments() {
        int i = 0;
        for (i = 0; i < postComments.size(); i++) {
            postComments.get(i).showComment();
        }
    }

    public void showPost() {
        System.out.println(postUser.getNickName() + " at " + postDate);
        System.out.println(postText);
        getComments();
    }

    // getters & setters

    public Usuario getPostUser() {
        return postUser;
    }

    public void setPostUser(Usuario postUser) {
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

    public ArrayList<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(ArrayList<Comment> postComments) {
        this.postComments = postComments;
    }

    public UUID getPostID() {
        return postID;
    }

    public void setPostID(UUID postID) {
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