package com.perdi.backend.datapkg;

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

    private static final Gson gson;

    static {
        gson = new Gson()
    }

    public PersistenceManager() {}

    private String ensureJsonExtension(String filename) {
        return filename.endsWith(".json") ? filename : filename + ".json";
    }

    public boolean deleteFile(String filename) {
        File file = new File(ensureJsonExtension(filename));
        return file.exists() && file.delete();
    }

    public boolean fileExists(String filename) {
        return new File(ensureJsonExtension(filename)).exists();
    }

    public <T> void saveToFile(List<T> list, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(ensureJsonExtension(fileName))) {
            gson.toJson(list, writer);
        }
    }

    public <T> List<T> loadFromFile(String filename, Type type) throws IOException {
        File file = new File(ensureJsonExtension(filename));
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + file.getAbsolutePath());
        }
        try (Reader reader = new FileReader(ensureJsonExtension(filename))) {
            return gson.fromJson(reader, type);
        } catch (Exception e) {
            throw new IOException("Failed to load from file: " + filename, e);
        }
    }
    public void saveUsers(List<User> users, String filename) throws IOException {
        saveToFile(users, filename);
    }

    public List<User> loadUsers(String filename) throws IOException {
        return loadFromFile(filename, getUserListType());
    }

    public void savePosts(List<Post> posts, String filename) throws IOException {
        saveToFile(posts,filename);
    }

    public List<Post> loadPosts(String filename) throws IOException {
        return loadFromFile(filename, getPostListType());
    }

    public void saveGroups(List<Group> groups, String filename) throws IOException {
        saveToFile(groups, filename);
    }

    public List<Group> loadGroups(String filename) throws IOException {
        return loadFromFile(filename, getGroupListType());
    }
    public void saveEvents(List<Event> events, String filename) throws IOException {
        saveToFile(events, filename);
    }

    public List<Event> loadEvents(String filename) throws IOException {
        return loadFromFile(filename, getEventListType());
    }

    public void saveMessages(List<Message> messages, String filename) throws IOException {
        saveToFile(messages, filename);
    }

    public List<Message> loadMessages(String filename) throws IOException {
        return loadFromFile(filename, getMessageListType());
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

    private static Type getUserListType() {
        return new  TypeToken<List<User>>() {}.getType();
    }private static Type getPostListType() {
        return new  TypeToken<List<Post>>() {}.getType();
    }
    private static Type getGroupListType() {
        return new  TypeToken<List<Group>>() {}.getType();
    }
    private static Type getEventListType() {
        return new  TypeToken<List<Event>>() {}.getType();
    }
    private static Type getMessageListType() {
        return new  TypeToken<List<Message>>() {}.getType();
    }
}