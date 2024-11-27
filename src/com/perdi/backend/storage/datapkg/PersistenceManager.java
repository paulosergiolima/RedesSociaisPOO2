package com.perdi.backend.storage.datapkg;

import com.perdi.backend.userpkg.User;

public class PersistenceManager {

    private UserPersistence userPersistence;
    private GroupPersistence groupPersistence;
    private EventPersistence eventPersistence;
    private PostPersistence postPersistence;
    private MessagePersistence messagePersistence;

    public PersistenceManager() {
        this.userPersistence = UserPersistence.getInstance();
        this.groupPersistence = GroupPersistence.getInstance();
        this.eventPersistence = EventPersistence.getInstance();
        this.postPersistence = PostPersistence.getInstance();
        this.messagePersistence = MessagePersistence.getInstance();
    }

    public void saveAll(DataCenter dataCenter) {
        userPersistence.saveUsers(dataCenter.getUsers());
        groupPersistence.saveGroups(dataCenter.getGroups());
        eventPersistence.saveEvents(dataCenter.getEvents());
        postPersistence.savePosts(dataCenter.getPosts());
        messagePersistence.saveMessages(dataCenter.getMessages());
    }

    public void loadAll(DataCenter dataCenter) {
       dataCenter.setDataCenter(userPersistence.loadUsers(), postPersistence.loadPosts(), groupPersistence.loadGroups(), eventPersistence.loadEvents(), messagePersistence.loadMessages());
    }
}
