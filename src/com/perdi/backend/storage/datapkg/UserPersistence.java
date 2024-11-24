package com.perdi.backend.storage.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.userpkg.User;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Essa classe serve para armazenar os usuarios em arquivos Json
 *
 * @author miguel
 */

/*
 *      Modelo do comentario:
 *      Como deve ser usado no codigo
 *          descricao da funcao
 *
 *      UserPersistence instancia = UserPersistence.getInstance();
 *          retorna uma instancia(que e unica) de UserPersistence
 *
 *      instancia.saveUsers(List<User>);
 *          cria um arquivo Json que tera os dados do input
 *
 *      instancia.loadUsers();
 *          retorna os usuarioss do arquivo json localizado na database
 *              se o arquivo de estiver vazio ou nao existir retorna uma lista vazia
 *
 *
 *      instancia.addUser(User);
 *          carrega o arquivo json em uma lista de usuarios, adiciona o input nessa lista e salva a lista
 */

public class UserPersistence {

    private static final String FILE_NAME = "src/com/perdi/backend/storage/database/users.json";
    private static UserPersistence instance;
    private Gson gson;

    private UserPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static UserPersistence getInstance() {
        if (instance == null) {
            instance = new UserPersistence();
        }
        return instance;
    }

    public void saveUsers(ArrayList<User> users) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(users, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de usuarios esta vazio ou nao existe. Retornando uma lista vazia.");
            return users;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type userListType = new TypeToken<ArrayList<User>>() {}.getType();
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
        ArrayList<User> users = loadUsers();
        users.add(user);
        saveUsers(users);
    }

    public User loadUserByID(UUID uuid) {
        ArrayList<User> users = loadUsers();
        for (User user : users) {
            if (user.getId().equals(uuid)) {
                return user;
            }
        }
        System.out.println("Usuario com ID " + uuid + " nao encontrado.");
        return null;
    }

    public boolean removeUserByID(UUID uuid) {
        ArrayList<User> users = loadUsers();
        boolean removed = users.removeIf(user -> user.getId().equals(uuid));

        if (removed) {
            saveUsers(users);
            System.out.println("Usuario com ID " + uuid + " removido com sucesso.");
        } else {
            System.out.println("Usuario com ID " + uuid + " nao encontrado.");
        }
        return removed;
    }
}