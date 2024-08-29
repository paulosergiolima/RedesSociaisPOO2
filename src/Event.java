

import java.time.LocalDate;
import java.util.ArrayList;
/**
 * @author cristian.eidi_unesp
 */
public class Event {
    
    private String eventName;
    private LocalDate eventDate = LocalDate.parse("2022-09-21");
    private String eventLocation;
    private String eventDescription;
    
    private ArrayList<User> eventParticipants = new ArrayList<User>();
    private int eventNumberParticipants;
    
    private boolean eventPrivacy;

    public Event(String eventName, LocalDate eventDate, String eventLocation, String eventDescription ) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventDescription = eventDescription;
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
        eventParticipants.add(participant);
        this.eventNumberParticipants++;
    }
    
    public void removeParticipant(User participant){
        for( int counter = 0; counter < eventNumberParticipants; counter++ ){
            if( participant.equals(eventParticipants.get(counter))  ){
                eventParticipants.remove(counter);
            }
        }        
        this.eventNumberParticipants--;
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

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
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

    public User getEventParticipants() {
        return eventParticipants;
    }

    public void setEventParticipants(User eventParticipants) {
        this.eventParticipants = eventParticipants;
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
