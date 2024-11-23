package com.perdi.backend.grouppkg;

import java.util.ArrayList;
import java.util.UUID;

import com.perdi.backend.userpkg.User;
import com.perdi.backend.feed.postpkg.Post;

public class Group {
    private UUID id;
    private String name;
    private ArrayList<User> members;
    private ArrayList<Post> posts;
    //Usuario vai ser a classe criada
    public Group() {this.id = UUID.randomUUID();}
    public Group(String name) {
        this.id = UUID.randomUUID();
        this.name = name;// altered for persistence, and consistency across the project
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
    public String getName() {return this.name;}
    public boolean isUserInGroup(User user) {
        return members.contains(user);
    }
    public boolean isUserInGroup(int index) {
        return members.get(index) != null;
    }
    public int getUserCount() {
        return this.members.size();
    }
    public UUID getId() {
        return id;
    }
}
