package com.perdi;

import com.perdi.backend.eventpkg.Event;
import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.messagepkg.Message;
import com.perdi.backend.messagepkg.TextMessage;
import com.perdi.backend.persistencepkg.PersistenceManager;
import com.perdi.backend.postpkg.Post;
import com.perdi.backend.postpkg.TextPost;
import com.perdi.backend.userpkg.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws IOException {
        PersistenceManager persistence = new PersistenceManager();
        ArrayList<User> users = new ArrayList<>();
        ArrayList<Post> posts = new ArrayList<>();
        ArrayList<Message> messages = new ArrayList<>();
        ArrayList<Group> groups = new ArrayList<>();
        ArrayList<Event> events = new ArrayList<>();

        User u1 = new User(UUID.randomUUID(), "a", "b", "c", "d", null, true, null, null, null, null, null);
        User u2 = new User(UUID.randomUUID(), "a", "b", "c", "d", null, true, null, null, null, null, null);
        users.add(u1);
        users.add(u2);


        Post p1 = new TextPost(u1, "post1");
        Post p2 = new TextPost(u2, "post2");
        posts.add(p1);
        posts.add(p2);

        Message m1 = new TextMessage(u1, null,"message1");
        Message m2 = new TextMessage(u2, null, "message2");
        messages.add(m1);
        messages.add(m2);

        Group g1 = new Group();
        Group g2 = new Group();
        groups.add(g1);
        groups.add(g2);

        Event e1 = new Event(UUID.randomUUID(), "eventName", "eventDate", "eventLocation", "eventDescription", 2, u1);
        Event e2 = new Event(UUID.randomUUID(), "eventName", "eventDate", "eventLocation", "eventDescription", 2, u2);
        events.add(e1);
        events.add(e2);


        persistence.saveUsers(users, "users");
        persistence.savePosts(posts, "posts");
        persistence.saveMessages(messages, "messages");
        persistence.saveGroups(groups, "groups");
        persistence.saveEvents(events, "events");
    }
}
