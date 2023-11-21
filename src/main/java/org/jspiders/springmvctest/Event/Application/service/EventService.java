package org.jspiders.springmvctest.Event.Application.service;

import org.jspiders.springmvctest.Event.Application.domain.Event;
import org.jspiders.springmvctest.Event.Application.repository.EventRepository;

import java.util.List;

public class EventService {

    EventRepository repository=new EventRepository();
    public List<Event> getAllEvents(){
        return repository.getAllEvents();
    }

    public List<String> getEventTypeList(){
        return repository.getEventTypeList();
    }

    public void addEvent(Event e1){
        repository.addEvent(e1);
    }

    public Event checkEvent(String refNo){
        List<Event> bookList=repository.getAllEvents();
       Event event=null;
        for(Event e:bookList){
            if(e.getTicketRefNo().equalsIgnoreCase(refNo)){
                event=e;
            }
        }
        return event;
    }

    public void updateEvent(Event event){
        List<Event> eventList=repository.getAllEvents();
        int index=0;
        for (Event e:eventList){
            if(e.getTicketRefNo().equalsIgnoreCase(event.getTicketRefNo())){
                index=eventList.indexOf(e);
                break;
            }
        }
        repository.updateEvent(event,index);
    }

    public void deleteEvent(String refNo){
        List<Event> eventList=repository.getAllEvents();
        Event event=null;
        for (Event e:eventList){
            if(e.getTicketRefNo().equalsIgnoreCase(refNo)){
                event=e;
                break;
            }
        }
        repository.deleteEvent(event);
    }

    public  Event viewEvent(String refNo){
        List<Event> eventList=repository.getAllEvents();
        Event event=null;
        for (Event e:eventList){
            if (e.getTicketRefNo().equalsIgnoreCase(refNo)){
                event=e;
            }
        }
        return event;
    }

}
