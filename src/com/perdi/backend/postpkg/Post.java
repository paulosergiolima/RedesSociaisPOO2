package com.perdi.backend.postpkg;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.UUID;
import java.util.ArrayList;

import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.reactionpkg.Reaction;
import com.perdi.backend.userpkg.User;

/*
 *      Post postExample1 = new TextPost/VideoPost/PhotoPost(ExampleUser);
 *          Cria um Post para o Usuário ExampleUser, criando um ID aleatório
 *          para esse post, a data de criação desse post, configurando a
 *          quantidade de visualizações totais e semanais.
 *
 *      Post postExample2 = new TextPost/VideoPost/PhotoPost(ExampleUser2, ExampleGroup);
 *          Cria um Post para o Usuário ExampleUser2, criando um ID aleatório
 *          para esse post, a data de criação desse post, configurando a
 *          quantidade de vizualizações totais e semanais, adicionando
 *          também o inidicador que esse post pertence à um grupo, e o
 *          grupo a qual ele pertence que é o ExampleGroup.
 *
 *      postExample.setContent(PostContent);
 *          Define o conteúdo do Post com PostContent, e cada subclasse
 *          identifica se o conteúdo está de acordo com o seu tipo de
 *          conteúdo, retornando conteúdo inválido em caso de não
 *          concordância.
 *
 *      String/ArrayList<String> conteudo = postExample.getContent();
 *          Retorna ao objeto conteudo uma String ou um Array de Strings
 *          do conteúdo do postExample.
 *
 *      postExample1.addView();
 *          Adiciona ao postExample1 mais uma vizualização, e deve ser usado
 *          toda vez que um usuário vê um post, ou seja, entra no post que
 *          aparece em seu "feed".
 *
 *      postExample2.markAsEdited();
 *          Toda vez que o postExample1, por exemplo, for editado, essa função
 *          deve estar sendo chamada, para marcar que o post foi editado.
 */

/**
 * @author Sayu
 *
 * Classe Abstrata para servir de template para todos as
 * subclasses que herdam de Post.
 */

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
        this.postLastViewWeek = postLastViewWeek;
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