package org.jspiders.springmvctest.Event.Application.domain;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jspiders.springmvctest.Event.Application.validation.RefNo;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Event {
    @NotBlank(message = "INVALID REF NO")
    @Size(min = 8,max = 8,message = "REF NUMBER SHOULD CONTAINS EXACTLY 8 CHARACTERS")
    @RefNo(value = "MTB",message = "REF NUMBER SHOULD BE START WITH 'MTB'")
    private String ticketRefNo;
    @NotBlank(message = "INVALID EVENT NAME")
    @Size(min = 5,message = "EVENT NAME MUST CONTAINS ATLEAST 5 CHARACTERS")
    @Pattern(regexp = "^[A-Za-z ]+$",message = "EVENT NAME SHOULD CONTAINS ONLY LETTERS")
    private String eventName;
    @NotNull(message = "INVALID EVENT TYPE")
    private String eventType;
    @Future(message = " JOIN DATE MUST BE IN THE FUTURE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    public String getFormattedEventDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(eventDate);
    }
    @Max(value = 150, message = "MAXIMUM AVAILABLE TICKETS CAN BE 150")
    @NotNull(message = "INVALID TICKET COUNT")
    private int availableTickets;
    @NotBlank(message = "INVALID EVENT LOCATION")
    @Size(min = 3,message = "EVENT LOCATION MUST CONTAINS ATLEAST 3 CHARACTERS")
    private String eventLocation;

}
