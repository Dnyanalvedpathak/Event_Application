package org.jspiders.springmvctest.Event.Application.repository;

import org.jspiders.springmvctest.Event.Application.domain.Event;

import java.util.ArrayList;
import java.util.List;

public class EventRepository {
    private List<Event> eventList=new ArrayList<>();

    private List<String> eventTypeList = new ArrayList<>();

    {
        eventTypeList.add("Movie");
        eventTypeList.add("Drama");
        eventTypeList.add("Standup Comedy");
    }


    public List<Event> getAllEvents(){
        return eventList;
    }

    public List<String> getEventTypeList(){
        return eventTypeList;
    }

    public void addEvent(Event e){
        eventList.add(e);
    }

    public void updateEvent(Event event,int index){
        eventList.set(index,event);
    }

    public void deleteEvent(Event event){
        eventList.remove(event);
    }


}
