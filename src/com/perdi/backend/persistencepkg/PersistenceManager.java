package com.perdi.backend.persistencepkg;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

import com.perdi.backend.postpkg.*;

public class PersistenceManager {

    private static final Gson gson = new Gson();

    public static void saveUsers(List<User> users, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(users, writer);
        }
    }

    public static List<User> loadUsers(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type userListType = new TypeToken<List<User>>() {}.getType();
            return gson.fromJson(reader, userListType);
        }
    }

    public static void savePosts(List<Post> posts, String filename) throws IOException {
        try (Writer writer = new FileWriter(filename)) {
            gson.toJson(posts, writer);
        }
    }

    public static List<Post> loadUsers(String filename) throws IOException {
        try (Reader reader = new FileReader(filename)) {
            Type postListType = new TypeToken<List<Post>>() {}.getType();
            return gson.fromJson(reader, postListType);
        }
    }
}
