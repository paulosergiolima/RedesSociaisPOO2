package com.perdi.backend.grouppkg;

import com.perdi.backend.postpkg.Post;
import com.perdi.backend.userpkg.User;

import java.util.ArrayList;
import java.util.UUID;

public class Group {
    private UUID id;
    private ArrayList<User> members;
    private ArrayList<Post> posts;

    //Usuario vai ser a classe criada
    public Group() {
        this.id = UUID.randomUUID();
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
