package com.berke.AkdenizSosyal.Model;

public class Event {
    private String eventTitle, eventDate, eventPlace, eventQuota, eventDescription, eventId;

    public Event(String eventTitle, String eventDate, String eventPlace, String eventQuota, String eventDescription, String eventId) {
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventPlace = eventPlace;
        this.eventQuota = eventQuota;
        this.eventDescription = eventDescription;
        this.eventId = eventId;

    }
    public  Event(){

    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventQuota() {
        return eventQuota;
    }

    public void setEventQuota(String eventQuota) {
        this.eventQuota = eventQuota;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }


}
