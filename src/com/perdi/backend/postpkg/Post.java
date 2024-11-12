package com.perdi.backend.postpkg;
import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.userpkg.User;
import java.time.LocalDateTime;
import java.util.UUID;

// @author Abigail Sayury

public abstract class Post {
    private UUID postID;
    private User postUser;
    private Group postDomain;
    private String postTitle;
    
    private LocalDateTime postCreationDate;
    private LocalDateTime postEditDate;
    
    private boolean postDomainFlag;
    private boolean postEditFlag;
    
    private int views;

    // Public Posts Constructor
    public Post(User postUser) {
        setPostID();
        setPostUser(postUser);
        setPostCreationDate();
        this.views = 0;
    }

    // Group Posts Constructor
    public Post(User postUser, Group postDomain) {
        setPostID();
        setPostUser(postUser);
        setPostCreationDate();
        this.views = 0;
        setPostDomainFlag(true);
        setPostDomain(postDomain);
    }

    public abstract Object getContent();
    public abstract void setContent(Object content);

    public void addViews() {
        this.views++;
    }

    public void markAsEdited() {
        setPostEditFlag(true);
        setPostEditDate();
    }

    // Getters & Setters

    public UUID getPostID() {
        return postID;
    }

    private void setPostID() {
        postID = UUID.randomUUID();
    }

    public User getPostUser() {
        return postUser;
    }

    private void setPostUser(User postUser) {
        this.postUser = postUser;
    }

    public LocalDateTime getPostCreationDate() {
        return postCreationDate;
    }

    private void setPostCreationDate() {
        postCreationDate = LocalDateTime.now();
    }

    public boolean isPostEditFlag() {
        return postEditFlag;
    }

    public void setPostEditFlag(boolean postEditFlag) {
        this.postEditFlag = postEditFlag;
    }

    public LocalDateTime getPostEditDate() {
        return postEditDate;
    }

    public void setPostEditDate() {
        postEditDate = LocalDateTime.now();
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isPostDomainFlag() {
        return postDomainFlag;
    }

    private void setPostDomainFlag(boolean postDomainFlag) {
        this.postDomainFlag = postDomainFlag;
    }

    public Group getPostDomain() {
        return postDomain;
    }

    private void setPostDomain(Group postDomain) {
        this.postDomain = postDomain;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }
}

/**
public class Post extends PostWithReaction{
    private User postUser;
    private UUID postID;
    private LocalDateTime postDate;
    private String postText;

    private boolean domainFlag;
    private Group postDomain;

    private boolean editFlag;
    private LocalDateTime editDate;

    // Constructor

    public Post(User postUser, String postText) {
        super();
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

    public User getPostUser() {
        return postUser;
    }

    private void setPostUser(User postUser) {
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
    */