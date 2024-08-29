import java.time.LocalDateTime;

public class VideoPost extends Post  {
    private String[] url_videos;
    private String title;
    private final String username;
    //username vai ser substituído pelo usuário
    private String content;
    private int minutes, seconds;


    VideoPost(String[] urlVideos, String title, String username, String content, int minutes, int seconds) {
        this.url_videos = urlVideos;
        this.title = title;
        this.username = username;
        this.content = content;
        this.minutes = minutes;
        this.seconds = seconds;

    }
    public String[] getUrl_videos() {
        return this.url_videos;
    }
    public int getMinutes() {
        return this.minutes;
    }
    public int getSeconds() {
        return this.seconds;
    }
    public String getTitle() {
        return this.title;
    }
    public String getUsername() {
        return this.username;
    }
    public String getContent() {
        return this.content;
    }
    public void setVideo(String[] url_videos, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.url_videos = url_videos;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
