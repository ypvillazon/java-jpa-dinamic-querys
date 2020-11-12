package cu.sacavix.springboot.jpa.specifications.web;

import cu.sacavix.springboot.jpa.specifications.entity.Event;
import cu.sacavix.springboot.jpa.specifications.service.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class EventResource {

    @Autowired
    private EventService eventService ;

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/events")
    @ApiOperation(value= "Get Players", response = Event.class)
    public ResponseEntity<?> get(
            @RequestParam(name = "sports", required = false) List<String> sports,
            @RequestParam(name = "countries", required = false) List<String> countries,
            @RequestParam(name = "leagues", required = false) List<String> leagues) {

        return ResponseEntity.ok(eventService.search((sports==null) ? new ArrayList<>() : sports, (countries==null) ? new ArrayList<>() : countries, (leagues==null) ? new ArrayList<>() : leagues)) ;

    }


}
