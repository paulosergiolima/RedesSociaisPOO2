package com.perdi.backend.storage.datapkg;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import com.perdi.backend.eventpkg.Event;
import com.perdi.backend.grouppkg.Group;
import com.perdi.backend.feed.postpkg.Post;
import com.perdi.backend.userpkg.User;
import com.perdi.backend.messagepkg.Message;

/**
 * Essa classe serve para facilitar a comunicacao entre objetos de diferentes tipos
 *
 * @author arthur
 */

/*
 *      Modelo do comentario:
 *      Como deve ser usado no codigo
 *          descricao da funcao
 *
 *      DataCenter instancia = DataCenter.getInstance();
 *          retorna uma instancia(que e unica) de DataCenter
 *
 *      instancia.addUser(User);
 *          adiciona um usuario ao array list de usuarios
 *
 *      instancia.removeUser(User ou String ou UUID);
 *          remove um usuario do array list de usuarios, caso o usuario recebido como parametro esteja presente no array
 *          , a string recebida seja o username de algum usuario do array ou o UUID seja de um dos usuarios no array
 *
 *      User user = instancia.getUser(UUID ou String);
 *          retorna um usuario que tenha o mesmo UUID ou a String seja igual ao username ou nickname do mesmo
 *
 *      ArrayList<User> users = instancia.getUsers();
 *          retorna um array list com todos os usuarios
 *
 *      instancia.addPost(Post);
 *          adiciona um grupo ao array list de posts
 *
 *      instancia.removePost(UUID);
 *          remove Post do array list, que tenha o UUID recebido
 *
 *      Post post = instancia.getPost(UUID);
 *          retorna um Post do array list que tenha o mesmo UUID
 *
 *      ArrayList<Post> posts = instancia.getPosts(User);
 *          retorna um array list com todos os posts do user
 *
 *      ArrayList<Post> posts = instancia.getPosts();
 *          retorna um array list com todos os posts
 *
 *      instancia.addGroup(Group);
 *          adiciona um grupo ao array list de grupos
 *
 *      instancia.removeGroup(UUID);
 *          remove grupo do array list, que tenha o UUID recebido
 *
 *      Group group = instancia.getGroup(UUID);
 *          retorna um Grupo do array list que tenha o mesmo UUID
 *          nao recebe uma string, pois nao sei se dois grupos podem possuir o mesmo nome
 *
 *      ArrayList<Group> groups = instancia.getGroups();
 *          retorna um array list com todos os grupos
 *
 *      instancia.addEvent(Event);
 *          adiciona um evento ao array list de eventos
 *
 *      instancia.removeEvent(UUID)
 *
 *      Events event = instancia.getEvent(UUID ou String);
 *          retorna 1 evento que possui o mesmo UUID ou a String seja igual ao nome
 *
 *      ArrayList<Event> events = instancia.getEventsInLocation(String)
 *          retorna os eventos que possuem o mesmo endereco que a String
 *
 *      ArrayList<Event> events = instancia.getEventsInDate(LocalDate)
 *          retorna os eventos que possuem a mesma data que a data recebbida
 *
 *      ArrayList<Event> events = instancia.getEventsAfterDate(LocalDate)
 *          retorna os eventos que possuem data apos a data recebbida
 *
 *      ArrayList<Event> events = instancia.getEventsAfterDate(LocalDate)
 *          retorna oum array list com todos os eventos
 *
 *      instancia.setDataCenter(ArrayList<User>, ArrayList<Post>, ArrayList<Group>, ArrayList<Event>);
 *          Setta o valor dos arrays para os arrays recebidos, serve somente ao carregar da persistencia
 */

public class DataCenter {
    private static DataCenter instance;
    private ArrayList<User> users;
    private ArrayList<Post> posts; // n foi implementado
    private ArrayList<Message> messages;
    private ArrayList<Group> groups;
    private ArrayList<Event> events;

    private DataCenter()
    {
        users = new ArrayList<>();
        posts = new ArrayList<>();
        messages = new ArrayList<>();
        groups = new ArrayList<>();
        events = new ArrayList<>();
    }

    public static DataCenter getInstance()
    {
        if(instance == null)
        {
            instance = new DataCenter();
        }
        return instance;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public void removeUser(User user)
    {
        for (int i = 0; i < users.size(); i++) {
            if(user.equals(users.get(i)))
            {
                users.remove(i);
            }
        }
    }

    public void removeUser(UUID uuid)
    {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId().equals(uuid))
            {
                users.remove(i);
            }
        }
    }

    public void removeUser(String string)
    {
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(string)) //|| users.get(i).getNickName().equals(string))
            {
                users.remove(i);
            }
        }
    }

    public User getUser(UUID uuid)
    {
        for (User user : users) {
            if (user.getId().equals(uuid)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String string)
    {
        for (User user : users) {
            if (user.getUserName().equals(string) || user.getNickName().equals(string)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers()
    {
        return users;
    }

    public void addPost(Post post)
    {
        posts.add(post);
    }

    public void removePost(UUID userID, UUID uuid)
    {
        for (int i = 0; i < posts.size(); i++) {
            if(posts.get(i).getPostID().equals(uuid) && posts.get(i).getPostUserID().equals(userID))
            {
                posts.remove(i);
            }
        }
    }

    public Post getPost(UUID uuid)
    {
        for (Post post : posts)
        {
            if(post.getPostID().equals(uuid))
            {
                return post;
            }
        }
        return null;
    }

    public ArrayList<Post> getPosts()
    {
        return posts;
    }

    public void addGroup(Group group)
    {
        groups.add(group);
    }

    public void removeGroup(UUID uuid)
    {
        for (int i = 0; i < groups.size(); i++) {
            if(groups.get(i).getId().equals(uuid))
            {
                groups.remove(i);
            }
        }
    }

    public Group getGroup(UUID uuid)
    {
        for (Group group : groups)
        {
            if(group.getId().equals(uuid))
            {
                return group;
            }
        }
        return null;
    }

    public ArrayList<Group> getGroups()
    {
        return groups;
    }

    public void addEvent(Event event)
    {
        events.add(event);
    }

    public void removeEvent(UUID uuid)
    {
        for (int i = 0; i < events.size(); i++)
        {
            if(events.get(i).getEventID().equals(uuid))
            {
                events.remove(i);
            }
        }
    }

    public void removeEvent(String string)
    {
        for(int i = 0; i < events.size(); i++)
        {
            if(events.get(i).getEventName().equals(string))
            {
                events.remove(i);
            }
        }
    }

    public Event getEvent(UUID uuid)
    {
        for (Event event : events)
        {
            if(event.getEventID().equals(uuid))
            {
                return event;
            }
        }
        return null;
    }

    public Event getEvent(String name)
    {
        for (Event event : events)
        {
            if(event.getEventName().equals(name))
            {
                return event;
            }
        }
        return null;
    }

    public ArrayList<Event> getEventsInLocation(String location)
    {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events)
        {
            if(event.getEventLocation().equals(location))
            {
                result.add(event);
            }
        }
        if(result.isEmpty())
        {
            return null;
        }

        return result;
    }

    public ArrayList<Event> getEventsInDate(LocalDate date)
    {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events)
        {
            if(event.getEventDate().isEqual(date))
            {
                result.add(event);
            }
        }
        if(result.isEmpty())
        {
            return null;
        }

        return result;
    }

    public ArrayList<Event> getEventsAfterDate(LocalDate date)
    {
        ArrayList<Event> result = new ArrayList<>();
        for (Event event : events)
        {
            if(event.getEventDate().isAfter(date))
            {
                result.add(event);
            }
        }
        if(result.isEmpty())
        {
            return null;
        }

        return result;
    }

    public ArrayList<Event> getEvents()
    {
        return events;
    }

    public void addMessage(Message message)
    {
        messages.add(message);
    }

    public void removeMessage(UUID uuid)
    {
        for (int i = 0; i < messages.size(); i++) {
            if(messages.get(i).getMessageID().equals(uuid))
            {
                messages.remove(i);
            }
        }
    }

    public Message getMessage(UUID uuid)
    {
        for (Message message : messages)
        {
            if(message.getMessageID().equals(uuid))
            {
                return message;
            }
            return null;
        }
    }

    public ArrayList<Message> getMessages()
    {
        return messages;
    }

    public void setDataCenter(ArrayList<User> users, ArrayList<Post> posts, ArrayList<Group> groups, ArrayList<Event> events, ArrayList<Message> messages)
    {
        this.users = users;
        this.posts = posts;
        this.groups = groups;
        this.events = events;
        this.messages = messages;
    }

    public Boolean isFollowing(User user, UUID followedID)
    {
        return user.isFollowing(followedID);
    }
}