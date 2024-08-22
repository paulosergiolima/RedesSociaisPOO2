import java.time.LocalDateTime;

public class VideoPost extends Post  {
    private String url_video;
    private String title;
    private final String username;
    //username vai ser substituído pelo usuário
    private String content;
    private int minutes, seconds;
    private final LocalDateTime date;


    VideoPost(String url_video, String title, String username, String content, int minutes, int seconds, LocalDateTime date) {
        this.url_video = url_video;
        this.title = title;
        this.username = username;
        this.content = content;
        this.minutes = minutes;
        this.seconds = seconds;
        this.date = date;

    }
    public String getUrl_video() {
        return this.url_video;
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
    public LocalDateTime getDate() {
        return this.date;
    }
    public void setVideo(String url_video, int minutes, int seconds) {
        this.seconds = seconds;
        this.minutes = minutes;
        this.url_video = url_video;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
