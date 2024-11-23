package com.perdi.backend.persistencepkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.adapterpkg.LocalDateTimeAdapter;
import com.perdi.backend.userpkg.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserPersistence {

    private static final String FILE_NAME = "users.json";
    private Gson gson;

    public UserPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void saveUsers(List<User> users) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de usuarios esta vazio ou nao existe. Retornando uma lista vazia.");
            return users;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type userListType = new TypeToken<List<User>>() {}.getType();
            users = gson.fromJson(reader, userListType);

            if (users == null) {
                users = new ArrayList<>();
            }

        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o JSON. O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            users = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de usuarios.");
            e.printStackTrace();
        }
        return users;
    }

    public void addUser(User user) {
        List<User> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }
}