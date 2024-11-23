package com.perdi;

import com.perdi.backend.datapkg.GroupPersistence;
import com.perdi.backend.eventpkg.Event;
import com.perdi.backend.datapkg.EventPersistence;
import com.perdi.backend.datapkg.UserPersistence;
import com.perdi.backend.userpkg.User;

import java.util.List;
import java.util.UUID;


public class App {
    public static void main(String[] args) {
        EventPersistence eventPersistence = EventPersistence.getInstance();
        UserPersistence userPersistence = UserPersistence.getInstance();

        User user1 = new User("user1", "nickname1", "email1@example.com", "he/him", "Description1", true);
        Event event = new Event(UUID.randomUUID(), "Event Name", "23/11/2024", "Event Location", "Event Description", 0, user1);

        eventPersistence.addEvent(event);
        userPersistence.addUser(user1);

        List<Event> events = eventPersistence.loadEvents();
        for (Event e : events) {
            System.out.println("Event Name: " + e.getEventName());
            System.out.println("Event Date: " + e.getEventDate());
        }

        List<User> users = userPersistence.loadUsers();
        for (User user : users) {
            System.out.println("User Name: " + user.getUserName());
        }

    }
}
