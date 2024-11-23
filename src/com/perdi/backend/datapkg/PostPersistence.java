package com.perdi.backend.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.postpkg.Post;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PostPersistence {

    public static final  String FILE_PATH = "src/com/perdi/backend/database/posts.json";
    private static PostPersistence instance;
    private Gson gson;

    private PostPersistence() {
        this.gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    public static PostPersistence getInstance() {
        if (instance == null) {
            instance = new PostPersistence();
        }
        return instance;
    }

    public void savePosts(ArrayList<Post> posts) {
        try (Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(posts, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Post> loadPost() {
       ArrayList<Post> posts = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de posts esta vazio ou nao existe. Retornando uma lista vazia.");
            return posts;
        }

        try (Reader reader = new FileReader(FILE_PATH)){
            Type postListType = new TypeToken<ArrayList<Post>>() {}.getType();
            posts = gson.fromJson(reader, postListType);

            if (posts == null) {
                posts = new ArrayList<>();
            }
        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o Json. O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            posts = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de posts.");
            e.printStackTrace();
        }
        return posts;
    }

    public void addPost(Post post) {
        ArrayList<Post> posts = loadPost();
        posts.add(post);
        savePosts(posts);
    }

    public Post loadPostByID(UUID uuid) {
        ArrayList<Post> posts = loadPost();
        for (Post post : posts) {
            if (post.getPostID().equals(uuid)) {
                return post;
            }
        }

        System.out.println("Post com ID " + uuid + " nao encontrado.");
        return null;
    }
}
