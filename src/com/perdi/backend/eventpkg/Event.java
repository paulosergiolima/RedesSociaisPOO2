package com.perdi.backend.eventpkg;

import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.UUID;

import com.perdi.backend.userpkg.User;
import com.perdi.backend.grouppkg.Group;

/**
 * @author cristian.eidi_unesp
 */


public class Event {
    
    private UUID eventID;
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private String eventDescription;
    
    private ArrayList<User> eventParticipants;
    private int eventNumberParticipants;
    
    private int eventPrivacy; // 0 public, 1 only friends

    public Event(UUID eventID,String eventName, String eventDate, String eventLocation, String eventDescription, int eventPrivacy, User firstUser ) {
        this.eventID = UUID.randomUUID();
        this.eventName = eventName;
        this.eventDate = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventPrivacy = eventPrivacy;
        eventParticipants = new ArrayList<User>();
        eventParticipants.add(firstUser);
    }

    public Event(UUID eventID,String eventName, String eventDate, String eventLocation, String eventDescription, int eventPrivacy, Group firstGroup ) {
        this.eventID = UUID.randomUUID();
        this.eventName = eventName;
        this.eventDate = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        this.eventPrivacy = eventPrivacy;
        eventParticipants = new ArrayList<User>();
        for( int i = 0, n = firstGroup.getUserCount() ; i < n; i++ ){
            eventParticipants.add(firstGroup.getUser(i) );
        }
    }
    
    public void postponeEventInDays(int days){
        eventDate.plusDays(days);
    }
    
    public void advanceEventInDays(int days){
        eventDate.minusDays(days);
    }
    
    public void postponeEventInMonths(int months){
        eventDate.plusMonths(months);
    }
    
    public void advanceEventInMonths(int months){
        eventDate.minusMonths(months);
    }
    
    public void postponeEventInYears(int years){
        eventDate.plusYears(years);
    }
    
    public void advanceEventInYears(int years){
        eventDate.minusYears(years);
    }
    
    public void addParticipant(User participant){
        if(this.eventPrivacy == 1){ // evento apenas amigos
            ArrayList<User> arrayFriends = participant.getFollowing();
            for( int counterInvited = 0; counterInvited < arrayFriends.size() ; counterInvited++){ // for para todos q alguem esta seguindo
                for( int counterParticipants = 0; counterParticipants < eventParticipants.size(); counterParticipants++ ){ // for para todos os
                    if( arrayFriends.get(counterInvited).equals(eventParticipants.get(counterParticipants)) ){             // participantes do evento
                        eventParticipants.add(participant);
                        this.eventNumberParticipants++;
                        return;
                    }
                }
            }
        
        }
        if(this.eventPrivacy == 0 ){ // evento publico
            eventParticipants.add(participant);
            this.eventNumberParticipants++;
            return;
        }
        
        return;
    }
    
    
    public void removeParticipant(User participant){
        for( int counter = 0; counter < eventNumberParticipants; counter++ ){
            if( participant.equals(eventParticipants.get(counter))  ){
                eventParticipants.remove(counter);
                this.eventNumberParticipants--;
            }
        }        
    }

    public UUID getEventID() {
        return eventID;
    }
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public int getEventNumberParticipants() {
        return eventNumberParticipants;
    }

    public void setEventNumberParticipants(int eventNumberParticipants) {
        this.eventNumberParticipants = eventNumberParticipants;
    }

    public int getEventPrivacy() {
        return eventPrivacy;
    }

    public void setEventPrivacy(int eventPrivacy) {
        this.eventPrivacy = eventPrivacy;
    }
            
    
}
