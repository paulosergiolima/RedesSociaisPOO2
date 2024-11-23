package com.perdi.backend.persistencepkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.persistencepkg.LocalDateTimeAdapter;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GroupPersistence {

    private static final String FILE_NAME = "src/com/perdi/backend/database/groups.json";
    private Gson gson;

    public GroupPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void saveGroups(List<Group> groups) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(groups, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Group> loadGroups() {
        List<Group> groups = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de grupos esta vazio ou nao existe. Retornando uma lista vazia.");
            return groups;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type groupListType = new TypeToken<List<Group>>() {}.getType();
            groups = gson.fromJson(reader, groupListType);

            if (groups == null) {
                groups = new ArrayList<>();
            }

        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o JSON.  O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            groups = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de grupos.");
            e.printStackTrace();
        }
        return groups;
    }

    public void addGroup(Group group) {
        List<Group> groups = loadGroups();
        groups.add(group);
        saveGroups(groups);
    }
}
