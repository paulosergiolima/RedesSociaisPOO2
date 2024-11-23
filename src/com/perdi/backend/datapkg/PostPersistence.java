package com.perdi.backend.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;


import com.perdi.backend.postpkg.PhotoPost;
import com.perdi.backend.postpkg.Post;
import com.perdi.backend.postpkg.TextPost;
import com.perdi.backend.postpkg.VideoPost;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class PostPersistence {

    public static final  String FILE_PATH = "src/com/perdi/backend/database/posts.json";
    private static PostPersistence instance;
    private Gson gson;

    private PostPersistence() {

        RuntimeTypeAdapterFactory<Post> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Post.class, "type")
                .registerSubtype(TextPost.class, "TextPost")
                .registerSubtype(PhotoPost.class, "PhotoPost")
                .registerSubtype(VideoPost.class, "VideoPost");

        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
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

    public ArrayList<Post> loadPosts() {
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
        ArrayList<Post> posts = loadPosts();
        posts.add(post);
        savePosts(posts);
    }

    public Post loadPostByID(UUID uuid) {
        ArrayList<Post> posts = loadPosts();
        for (Post post : posts) {
            if (post.getPostID().equals(uuid)) {
                return post;
            }
        }

        System.out.println("Post com ID " + uuid + " nao encontrado.");
        return null;
    }

    public boolean removePostByID(UUID uuid) {
        ArrayList<Post> posts = loadPosts();
        boolean removed = posts.removeIf(post -> post.getPostID().equals(uuid));

        if (removed) {
            savePosts(posts);
            System.out.println("Post com ID " + uuid + " removido com sucesso.");
        } else {
            System.out.println("Post com ID " + uuid + " nao encontrado.");
        }
        return removed;
    }
}
