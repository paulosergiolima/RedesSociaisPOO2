package com.perdi.backend.datapkg;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.perdi.backend.eventpkg.Event;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Essa classe serve para facilitar armazenar os eventos em arquivos Json
 *
 * @author miguel
 */

/*
 *      Modelo do comentario:
 *      Como deve ser usado no codigo
 *          descricao da funcao
 *
 *      EventPersistence instancia = EventPersistence.getInstance();
 *          retorna uma instancia(que e unica) de EventPersistence
 *
 *      instancia.saveEvents(List<Event>);
 *          cria um arquivo Json que tera os dados do input
 *
 *      instancia.loadEvents();
 *          retorna os eventos do arquivo json localizado na database
 *              se o arquivo de estiver vazio ou nao existir retorna uma lista vazia
 *
 *
 *      instancia.addEvent(Event);
 *          carrega o arquivo json em uma lista de eventos, adiciona o input nessa lista e salva a lista
 */


public class EventPersistence {

    private static final String FILE_NAME = "src/com/perdi/backend/database/events.json";
    private static EventPersistence instance;
    private Gson gson;

    private EventPersistence() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .setPrettyPrinting()
                .create();
    }

    public static EventPersistence getInstance()  {
        if (instance == null) {
            instance = new EventPersistence();
        }
        return instance;
    }

    public void saveEvents(ArrayList<Event> events) {
        try (Writer writer = new FileWriter(FILE_NAME)){
            gson.toJson(events, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Event> loadEvents() {
        ArrayList<Event> events = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists() || file.length() == 0) {
            System.out.println("O arquivo de eventos esta vazio ou nao existe. Retornando uma lista vazia.");
            return events;
        }

        try (Reader reader = new FileReader(FILE_NAME)){
            Type eventListType = new TypeToken<ArrayList<Event>>() {}.getType();
            events = gson.fromJson(reader, eventListType);

            if (events == null) {
                events = new ArrayList<>();
            }

        } catch (JsonSyntaxException | EOFException e) {
            System.out.println("Erro ao interpretar o JSON. O arquivo pode estar corrompido ou vazio.");
            e.printStackTrace();
            events = new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo de eventos.");
            e.printStackTrace();
        }
        return events;
    }

    public void addEvent(Event event) {
        ArrayList<Event> events = loadEvents();
        events.add(event);
        saveEvents(events);
    }

    public Event loadEventByID(UUID uuid) {
        ArrayList<Event> events = loadEvents();
        for (Event event : events) {
            if (event.getEventID().equals(uuid)) {
                return event;
            }
        }
        System.out.println("Evento com ID " + uuid + " nao encontrado.");
        return null;
    }
}