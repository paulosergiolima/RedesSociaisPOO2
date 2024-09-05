import java.time.LocalDateTime;
import java.util.ArrayList;


public class PhotoPost extends Post {
    private ArrayList<String> images_url;

    public PhotoPost(Usuario postUser, String postText, LocalDateTime date, String content, ArrayList<String> images_url, String username) {
        super(postUser, postText);
        this.images_url = images_url;
    }

    public ArrayList<String> getImages_url() { return this.images_url; }
    public void setImage(ArrayList<String> url_images) { this.images_url = url_images; }

    public void addImage(String new_url) {
        images_url.add(new_url);
    }

    public void removeImageByIndex(int index) {
        if (index >= 0 && index < images_url.size()) {
            images_url.remove(index);
        }
    }

    public int getImageIndex(String url) {
        for (int i = 0; i < images_url.size(); i++) {
            if (url.equals(images_url.get(i))) {
                return i;
            }
        }
        return -1;
    }
}
