import java.util.ArrayList;
import java.time.LocalDateTime;

public class PrivateMessage {
    
    private User contact; //usuário que recebe a mensagem, "contact" provavelmente é provisório
    private ArrayList<Message> messages;
    
    public PrivateMessage(User contact) {
        this.contact = contact;
        this.messages = new ArrayList<>();
    }
    
    public void newMessage(User user, String content) {
        Message message = new Message(content, user);
        messages.add(message);
    }
    
    public void removeMessage(Message message) {
        messages.remove(message);
    }

    public void editMessage(Message message, String newContent, LocalDateTime editDate) {
        message.setContent(newContent);
        message.setEditFlag(true);
        message.setEditDate(editDate);
    }
    
    public Usuario getContact() {
        return contact;
    }
    
    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    public void setContact(User contact) {
        this.contact = contact;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}
