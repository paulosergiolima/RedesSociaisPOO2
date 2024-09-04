
import java.time.LocalDateTime;
import java.util.ArrayList;


public class PhotoPost extends Post {
    private final String username;
    private ArrayList<String> images_url;
    private String content;
    private final LocalDateTime date;

    PhotoPost(String username, ArrayList<String> urlImages, String content, LocalDateTime date) {
        this.username = username;
        this.images_url = urlImages;
        this.content = content;
        this.date = date;
    }

    public String getUsername() { return this.username; }
    public ArrayList<String> getImages_url() { return this.images_url; }
    public String getContent() { return this.content; }
    public LocalDateTime getDate() { return this.date; }

    public void setImage(ArrayList<String> url_images) { this.images_url = url_images; }
    public void setContent(String content) { this.content = content; }

}


