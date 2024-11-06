package com.perdi.backend.eventpkg;

import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
/**
 * @author cristian.eidi_unesp
 */
public class Event {
    
    private String eventName;
    private LocalDate eventDate;
    private String eventLocation;
    private String eventDescription;
    
    private ArrayList<User> eventParticipants;
    private int eventNumberParticipants;
    
    private boolean eventPrivacy; // 0 publico, 1 privado 

    public Event(String eventName, String eventDate, String eventLocation, String eventDescription ) {
        this.eventName = eventName;
        this.eventDate = LocalDate.parse(eventDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
        eventParticipants = new ArrayList<User>();
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
        if( this.eventNumberParticipants == 0 ){ // se o evento estiver vazio
            eventParticipants.add(participant);
            this.eventNumberParticipants++;
            return;
        }
        
        if(this.eventPrivacy){ // evento privado, adicionara apenas se quem for adicionado tiver um amigo em comum
            ArrayList<User> arrayFriends = participant.getFriends();
            for( int counterInvited = 0; counterInvited < arrayFriends.size() ; counterInvited++){ // for para todos os amigos do convidado
                for( int counterParticipants = 0; counterParticipants < eventParticipants.size(); counterParticipants++ ){ // for para todos os
                    if( arrayFriends.get(counterInvited).equals(eventParticipants.get(counterParticipants)) ){                  // participantes do evento
                        eventParticipants.add(participant);
                        this.eventNumberParticipants++;
                        return;
                    }
                }
            }
        }else{ // evento publico
            eventParticipants.add(participant);
            this.eventNumberParticipants++;
        }
        
    }
    
    public void removeParticipant(User participant){
        for( int counter = 0; counter < eventNumberParticipants; counter++ ){
            if( participant.equals(eventParticipants.get(counter))  ){
                eventParticipants.remove(counter);
                this.eventNumberParticipants--;
            }
        }        
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

    public boolean isEventPrivacy() {
        return eventPrivacy;
    }

    public void setEventPrivacy(boolean eventPrivacy) {
        this.eventPrivacy = eventPrivacy;
    }
            
    
}
