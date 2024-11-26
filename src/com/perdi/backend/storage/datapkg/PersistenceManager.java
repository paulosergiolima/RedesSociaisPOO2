package com.perdi.backend.storage.datapkg;

public class PersistenceManager {

    UserPersistence userPersistence;
    GroupPersistence groupPersistence;
    EventPersistence eventPersistence;
    PostPersistence postPersistence;
    MessagePersistence messagePersistence;

    public void saveAl(DataCenter dataCenter) {
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
