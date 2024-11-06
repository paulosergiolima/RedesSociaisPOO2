import java.util.ArrayList;
import java.util.Random;

public class Group {
    private int id;
    private ArrayList<User> members;
    private ArrayList<Post> posts;
    //Usuario vai ser a classe criada
    public Group(int id, ArrayList<User> members, ArrayList<Post> posts) {
        Random rand = new Random()
        this.id = rand.nextInt(0,999999);
    }
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
    public User getUser(User usuario) {
        return this.members.get(this.members.indexOf(usuario));
    }
    public boolean isUserInGroup(User user) {
        return members.contains(user);
    }
    public boolean isUserInGroup(int index) {
        return members.get(index) != null;
    }
    public int getUserCount() {
        return this.members.size();
    }
    public int getId() {
        return id;
    }
}
