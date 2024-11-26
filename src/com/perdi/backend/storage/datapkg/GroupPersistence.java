package com.perdi.backend.storage.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.grouppkg.Group;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Essa classe serve para armazenar os grupos em arquivos Json
 *
 * @author miguel
 */

/*
 *      Modelo do comentario:
 *      Como deve ser usado no codigo
 *          descricao da funcao
 *
 *      GroupPersistence instancia = GroupPersistence.getInstance();
 *          retorna uma instancia(que e unica) de GroupPersistence
 *
 *      instancia.saveGroups(List<Group>);
 *          cria um arquivo Json que tera os dados do input
 *
 *      instancia.loadGroups();
 *          retorna os grupos do arquivo json localizado na database
 *              se o arquivo de estiver vazio ou nao existir retorna uma lista vazia
 *
 *
 *      instancia.addGroup(Group);
 *          carrega o arquivo json em uma lista de grupos, adiciona o input nessa lista e salva a lista
 */

public class GroupPersistence {

    private static final String FILE_NAME = "src/com/perdi/backend/storage/database/groups.json";
    private static GroupPersistence instance;
    private Gson gson;

    private GroupPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static GroupPersistence getInstance() {
        if (instance == null) {
            instance = new GroupPersistence();
        }
        return instance;
    }

    public void saveGroups(List<Group> groups) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(groups, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Group> loadGroups() {
        ArrayList<Group> groups = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de grupos esta vazio ou nao existe. Retornando uma lista vazia.");
            return groups;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type groupListType = new TypeToken<ArrayList<Group>>() {}.getType();
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
        ArrayList<Group> groups = loadGroups();
        groups.add(group);
        saveGroups(groups);
    }

    public Group loadGroupByID(UUID uuid) {
        ArrayList<Group> groups = loadGroups();
        for (Group group : groups) {
            if (group.getId().equals(uuid)) {
                return group;
            }
        }
        System.out.println("Grupo com ID " + uuid + " nao encontrado.");
        return null;
    }

    public boolean removeGroupByID(UUID uuid) {
        ArrayList<Group> groups = loadGroups();
        boolean removed = groups.removeIf(group -> group.getId().equals(uuid));

        if (removed) {
            saveGroups(groups);
            System.out.println("Grupo com ID " + uuid + " removido com sucesso.");
        } else {
            System.out.println("Grupo com ID " + uuid + " nao encontrado.");
        }
        return removed;
    }
}
