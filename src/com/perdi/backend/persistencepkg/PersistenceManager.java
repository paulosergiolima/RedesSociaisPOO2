package com.perdi.backend.persistencepkg;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.perdi.backend.eventpkg.Event;
import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.messagepkg.Message;
import com.perdi.backend.postpkg.*;
import com.perdi.backend.userpkg.User;

public class PersistenceManager {

    private static final Gson gson = new Gson();

    public PersistenceManager() {}

    public void saveUsers(List<User> users, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(users, writer);
        }
    }

    public List<User> loadUsers(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        }
    }

    public void savePosts(List<Post> posts, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(posts, writer);
        }
    }

    public List<Post> loadPosts(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type postListType = new TypeToken<List<Post>>() {}.getType();
            return gson.fromJson(reader, postListType);
        }
    }

    public void saveGroups(List<Group> groups, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(groups, writer);
        }
    }

    public List<Group> loadGroups(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type groupListType = new TypeToken<List<Group>>() {}.getType();
            return gson.fromJson(reader, groupListType);
        }
    }
    public void saveEvents(List<Event> events, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(events, writer);
        }
    }

    public List<Event> loadEvents(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type eventListType = new TypeToken<List<Event>>() {}.getType();
            return gson.fromJson(reader, eventListType);
        }
    }

    public void saveMessages(List<Message> messages, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(messages, writer);
        }
    }

    public List<Message> loadMessages(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type messageListType = new TypeToken<List<Message>>() {}.getType();
            return gson.fromJson(reader, messageListType);
        }
    }

    // Methods to retrieve specific objects by ID
    public Optional<User> getUserById(UUID id, String filename) throws IOException {
        return loadUsers(filename).stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public Optional<Post> getPostById(UUID id, String filename) throws IOException {
        return loadPosts(filename).stream().filter(post -> post.getPostID().equals(id)).findFirst();
    }

    public Optional<Group> getGroupById(UUID id, String filename) throws IOException {
        return loadGroups(filename).stream().filter(group -> group.getId().equals(id)).findFirst();
    }

    public Optional<Event> getEventById(UUID id, String filename) throws IOException {
        return loadEvents(filename).stream().filter(event -> event.getEventID().equals(id)).findFirst();
    }

    public Optional<Message> getMessageById(UUID id, String filename) throws IOException {
        return loadMessages(filename).stream().filter(message -> message.getMessageID().equals(id)).findFirst();
    }
}