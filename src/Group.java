import java.util.ArrayList;

public class Group {
    private ArrayList<User> members;
    private ArrayList<Post> posts;
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
    public User getUser(User user) {
        return this.members.get(this.members.indexOf(user));
    }
    public boolean isUserInGroup(User user) {
        return members.contains(user);
    }
    public boolean isUserInGroup(int index) {
        return members.get(index) != null;
    }
}
