import java.util.ArrayList;

public class PrivateMessage {
    
    private Usuario contact; //usuário que recebe a mensagem, "contact" provavelmente é provisório
    private ArrayList<Message> messages;
    
    public PrivateMessage(Usuario contact) {
        this.contact = contact;
        this.messages = new ArrayList<>();
    }
    
    public void newMessage(Usuario user, String content) {
        Message message = new Message(content, user);
        messages.add(message);
    }
    
    public void removeMessage(Message message) {
        messages.remove(message);
    }
    
    public Usuario getContact() {
        return contact;
    }
    
    public ArrayList<Message> getMessages() {
        return messages;
    }
    
    public void setContact(Usuario contact) {
        this.contact = contact;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

}
