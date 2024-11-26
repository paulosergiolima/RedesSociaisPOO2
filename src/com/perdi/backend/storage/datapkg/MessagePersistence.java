package com.perdi.backend.storage.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;


import com.perdi.backend.messagepkg.Message;
import com.perdi.backend.messagepkg.TextMessage;
import com.perdi.backend.messagepkg.ImageMessage;
import com.perdi.backend.messagepkg.VideoMessage;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class MessagePersistence {
    
    public static final String FILE_NAME = "src/com/perdi/backend/storage/database/messages.json";
    private static MessagePersistence instance;
    private Gson gson;

    private MessagePersistence() {

        RuntimeTypeAdapterFactory<Message> typeAdapterFactory = RuntimeTypeAdapterFactory
                .of(Message.class, "type")
                .registerSubtype(TextMessage.class, "TextMessage")
                .registerSubtype(ImageMessage.class, "ImageMessage")
                .registerSubtype(VideoMessage.class, "VideoMessage");

        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeAdapterFactory)
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static MessagePersistence getIntance() {
        if (instance == null) {
            instance = new MessagePersistence();
        }
        return instance;
    }

    public void saveMessages(ArrayList<Message> messages) {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            gson.toJson(messages, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Message> loadMessages() {
        ArrayList<Message> messages = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de mensagens esta vazio ou nao existe. Retornando uma lista vazia.");
            return messages;
        }

        try (Reader reader = new FileReader(FILE_NAME)) {
            Type messageListType = new TypeToken<ArrayList<Message>>() {}.getType();
            messages = gson.fromJson(reader, messageListType);

            if (messages == null) {
                messages = new ArrayList<>();
            }
        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o Json. O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            messages = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de posts.");
            e.printStackTrace();
        }
        return messages;
    }

    public void addMessage(Message message) {
        ArrayList<Message> messages = loadMessages();
        messages.add(message);
        saveMessages(messages);
    }

    public Message loadMessageByID(UUID uuid) {
        ArrayList<Message> messages = loadMessages();
        for (Message message : messages) {
            if (message.getMessageID().equals(uuid)) {
                return message;
            }
        }

        System.out.println("Mensagem com ID " + uuid + " nao encontrada.");
        return null;
    }

    public boolean removeMessageByID(UUID uuid) {
        ArrayList<Message> messages = loadMessages();
        boolean removed = messages.removeIf(message -> message.getMessageID().equals(uuid));

        if (removed) {
            saveMessages(messages);
            System.out.println("Mensagem com ID " + uuid + " removida com sucesso.");
        } else {
            System.out.println("Mensagem com ID " + uuid + " nao encontrada.");
        }
        return removed;
    }
}
