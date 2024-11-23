package com.perdi.backend.postpkg;
import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
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
    
    private int postTotalViews;
    private int postWeeklyViews;
    private int postLastViewWeek;

    private ArrayList<Reaction> postReactions;
    private CommentManager comments;

    // Public Posts Constructor
    public Post(User postUser) {
        setPostID();
        setPostUser(postUser);
        setPostCreationDate();
        setPostTotalViews();
        setPostWeeklyViews();
        setPostLastViewWeek(0);
    }

    // Group Posts Constructor
    public Post(User postUser, Group postDomain) {
        setPostID();
        setPostUser(postUser);
        setPostCreationDate();
        setPostTotalViews();
        setPostWeeklyViews();
        setPostLastViewWeek(0);
        setPostDomainFlag();
        setPostDomain(postDomain);
    }

    public abstract Object getContent();
    public abstract void setContent(Object content);

    public void addView() {
        this.postTotalViews++;
        int nowWeek = LocalDateTime.now().get(WeekFields.of(Locale.getDefault()).weekOfYear());
        if (getPostLastViewWeek() != nowWeek) {
            setPostLastViewWeek(nowWeek);
            setPostWeeklyViews();
        }
        this.postWeeklyViews++;
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

    public int getPostTotalViews() {
        return postTotalViews;
    }

    private void setPostTotalViews() {
        this.postTotalViews = 0;
    }

    public int getPostWeeklyViews() {
        return postWeeklyViews;
    }

    public void setPostWeeklyViews() {
        this.postWeeklyViews = 0;
    }

    public int getPostLastViewWeek() {
        return postLastViewWeek;
    }

    public void setPostLastViewWeek(int postLastViewWeek) {
        this.postLastViewWeek = this.postLastViewWeek;
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

    public CommentManager getPostComments() {
        return comments;
    }

    public void setPostComments(CommentManager postComments) {
        this.comments = postComments;
    }
}