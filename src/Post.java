import java.time.LocalDateTime;
import java.util.ArrayList;

// @author Abigail Sayury

public class Post {
    private String postUser;
    private String postID;
    private LocalDateTime postDate;
    private String postText;
    private ArrayList<String> postComments;

    private boolean domainFlag;
    private Group postDomain;

    private boolean editFlag;
    private LocalDateTime editDate;

    // Constructor

    public Post(String postUser, String postID, LocalDateTime postDate, String postText, ArrayList<String> postComments) {
        this.postUser = postUser;
        this.postID = postID; // criar um ID para o post
        this.postDate = postDate; // setar a data de publicação (como?)
        this.postText = postText;
        this.postComments = postComments;
    }

    // Methods:

    // Criar meodo de criação do ID

    // Criar metodo de setar a data da publicação

    // getters & setters

    public String getPostUser() {
        return postUser;
    }

    public void setPostUser(String postUser) {
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

    public ArrayList<String> getPostComments() {
        return postComments;
    }

    public void setPostComments(ArrayList<String> postComments) {
        this.postComments = postComments;
    }

    public String getPostID() {
        return postID;
    }

    public void setPostID(String postID) {
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