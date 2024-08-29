import java.util.ArrayList;

public class Group {
    ArrayList<User> members;
    ArrayList<Message> messages;
    //Usuario vai ser a classe criada
    public void putUser(User new_member) {
        members.add(new_member);
    }
    public void removeUser(User member) {
        members.remove(member);
    }
    public ArrayList<User> getUsers() {
        return this.members;
    }
    public User getUser(int index) {
        return this.members.get(index);
    }
    public User getUser(Usuario usuario) {
        return this.members.get(this.members.indexOf(usuario));
    }
    public void sendMessage(Usuario user,String message) {
        Message msg = new Message(message, user);
        messages.add(msg);
    }
    public ArrayList<Message> getMessages() {
        return this.messages;
    }
}
