package com.perdi.backend.postpkg;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.ArrayList;

import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.reactionpkg.Reaction;
import com.perdi.backend.userpkg.User;

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
    private ArrayList<Reaction> postReactions;
    private ArrayList<Comment> postComments;

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
        setPostDomainFlag();
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

    private void setPostDomainFlag() {
        this.postDomainFlag = true;
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
    
    public ArrayList<Reaction> getPostReactions() {
        return postReactions;
    }

    public void setPostReactions(ArrayList<Reaction> postReactions) {
        this.postReactions = postReactions;
    }

    public ArrayList<Comment> getPostComments() {
        return postComments;
    }

    public void setPostComments(ArrayList<Comment> postComments) {
        this.postComments = postComments;
    }
}