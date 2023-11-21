package org.jspiders.springmvctest.Event.Application.controller;

import jakarta.validation.Valid;
import org.jspiders.springmvctest.Event.Application.domain.Event;
import org.jspiders.springmvctest.Event.Application.service.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class EventController {
    EventService service=new EventService();
    @GetMapping("/")
    public String getAllEvents(Model model){
       model.addAttribute("eventList",service.getAllEvents());
       return "eventform";
    }

    @GetMapping("/addnewevent")
    public String addEventForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("eventType",service.getEventTypeList());
        return "addnewevent";
    }

    @PostMapping("/addevent")
    public String addEvent(@Valid Event e1, BindingResult result,Model model) {
        if(result.hasErrors()){
            model.addAttribute("eventType",service.getEventTypeList());
            return "addnewevent";
        }
        service.addEvent(e1);
        return "redirect:/";
    }

    @GetMapping("/updateEvent/{refNo}")
    public String updateEventForm(@PathVariable(value = "refNo") String refNo, Model model) {

        model.addAttribute("updateEvent", service.checkEvent(refNo));
        model.addAttribute("eventType",service.getEventTypeList());
        //SEND IT TO UPDATE EVENT FORM PAGE
        return "updateevent";
    }

    @PostMapping("/updateeventdetails")
    public String updateEvent(@Valid Event event,Model model) {
        model.addAttribute("eventType",service.getEventTypeList());
        service.updateEvent(event);
        return "redirect:/";
    }
    @GetMapping("delete/{refNo}")
    public String deleteEvent(@PathVariable (value = "refNo") String refNo){
        service.deleteEvent(refNo);
        return "redirect:/";
    }

    public void viewEvent(@PathVariable(value = "refNo") String refNo,Model model){
        Event event=service.viewEvent(refNo);
        model.addAttribute("viewevent",event);
    }

}
