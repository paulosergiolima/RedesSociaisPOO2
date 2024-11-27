package com.perdi.backend.grouppkg;
import com.perdi.backend.userpkg.User;

import java.util.ArrayList;
import java.util.UUID;

public class Group {
	private final UUID id;
	private ArrayList<UUID> members;
	private ArrayList<UUID> posts;
	private String description;
	private String name;
	private UUID admin;

	public Group() {this.id = UUID.randomUUID();}
	public Group(String name, String description) {
		this.id = UUID.randomUUID();
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UUID getAdmin() {
		return admin;
	}
	public void setAdmin(UUID admin) {
		this.admin = admin;
	}
	public void putUser(UUID new_member) {
		members.add(new_member);
	}
	public void removeUser(UUID member) {
		members.remove(member);
	}
	public ArrayList<UUID> getUsers() {
		return this.members;
	}
	public UUID getUser(int index) {
		return this.members.get(index);
	}
	public UUID getUser(UUID user) {
		return this.members.get(this.members.indexOf(user));
	}
	public String getName() {return this.name;}
	public boolean isUserInGroup(UUID user) {
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
	public void putPost(UUID post) {
		posts.add(post);
	}
	public void removePost(UUID post) {
		posts.remove(post);
	}
	public ArrayList<UUID> getPosts() {
		return this.posts;
	}
}
