import java.time.LocalDateTime;
import java.util.ArrayList;


public class PhotoPost extends Post {
    private ArrayList<String> urls;

    public PhotoPost(Usuario postUser, String postText, LocalDateTime date, String content, ArrayList<String> urls, String username) {
        super(postUser, postText);
        this.urls = urls;
    }

    public ArrayList<String> getUrls() { return this.urls; }
    public void setImage(ArrayList<String> url_images) { this.urls = url_images; }

    public int getImageIndex(String url) {
        for (int i = 0; i < urls.size(); i++) {
            if (url.equals(urls.get(i))) {
                return i;
            }
        }
        return -1;
    }

    public void addImage(String new_url) {
        urls.add(new_url);
    }

    public boolean removeImageByIndex(int index) {
        if (index >= 0 && index < urls.size()) {
            urls.remove(index);
            return true;
        }
        return false;
    }

    public boolean removeImageByUrl(String url) {
        int index = this.getImageIndex(url);
        return this.removeImageByIndex(index);
    }
}
