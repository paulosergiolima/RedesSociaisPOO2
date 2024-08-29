public class Message {
    private String content;
    private User sender;
    public Message(String content, Usuario sender) {
        this.content = content;
        this.sender = sender;
    }
}
