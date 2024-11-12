package com.perdi.backend.grouppkg;

import java.util.ArrayList;
import java.util.Random;

import com.perdi.backend.userpkg.User;
import com.perdi.backend.postpkg.Post;

public class Group {
    private int id;
    private ArrayList<User> members;
    private ArrayList<Post> posts;
<<<<<<< HEAD:src/Group.java
=======
    //Usuario vai ser a classe criada
    public Group() {
        Random rand = new Random()
        this.id = rand.nextInt(0,999999);
    }
>>>>>>> master:src/com/perdi/backend/grouppkg/Group.java
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
    public int getUserCount() {
        return this.members.size();
    }
    public int getId() {
        return id;
    }
}
