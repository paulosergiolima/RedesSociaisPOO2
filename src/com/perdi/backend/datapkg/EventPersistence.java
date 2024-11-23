package com.perdi.backend.persistencepkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.persistencepkg.LocalDateAdapter;
import com.perdi.backend.persistencepkg.LocalDateTimeAdapter;
import com.perdi.backend.eventpkg.Event;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventPersistence {

    private static final String FILE_NAME = "src/com/perdi/backend/database/users.json";
    private Gson gson;

    public EventPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void saveEvents(List<Event> events) {
        try (Writer writer = new FileWriter(FILE_NAME)){
            gson.toJson(events, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Event> loadEvents() {
        List<Event> events = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de eventos esta vazio ou nao existe. Retornando uma lista vazia.");
            return events;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type eventListType = new TypeToken<List<Event>>() {}.getType();
            events = gson.fromJson(reader, eventListType);

            if (events == null) {
                events = new ArrayList<>();
            }

        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o JSON.  O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            events = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de eventos.");
            e.printStackTrace();
        }
        return events;
    }

    public void addEvent(Event event) {
        List<Event> events = loadEvents();
        events.add(event);
        saveEvents(events);
    }
}