package cu.sacavix.springboot.jpa.specifications.init;

import cu.sacavix.springboot.jpa.specifications.entity.Event;
import cu.sacavix.springboot.jpa.specifications.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

@Service
public class CreateEvents {

    @Autowired
    private EventRepository eventRepository ;

    @PostConstruct
    private void init() {

        if(!eventRepository.findById("11111").isPresent()) {
            Event e = new Event();
            e.setEventId("11111");
            e.setLeague("xxx");
            e.setSport("Football");
            e.setCountry("Venezuela");
            e.setTeamAwayName("A");
            e.setTeamHomeName("B");
            e.setDate(future(2).getTime());
            eventRepository.save(e);
        }

        if(!eventRepository.findById("22222").isPresent()) {
            Event e = new Event();
            e.setEventId("22222");
            e.setLeague("yyy");
            e.setSport("Football");
            e.setCountry("Cuba");
            e.setTeamAwayName("A");
            e.setTeamHomeName("B");
            e.setDate(future(3).getTime());
            eventRepository.save(e);
        }

        if(!eventRepository.findById("33333").isPresent()) {
            Event e = new Event();
            e.setEventId("33333");
            e.setLeague("zzz");
            e.setSport("Football");
            e.setCountry("EEUU");
            e.setTeamAwayName("A");
            e.setTeamHomeName("B");
            e.setDate(future(4).getTime());
            eventRepository.save(e);
        }

        if(!eventRepository.findById("44444").isPresent()) {
            Event e = new Event();
            e.setEventId("44444");
            e.setLeague("zzz");
            e.setSport("Football");
            e.setCountry("EEUU");
            e.setTeamAwayName("A");
            e.setTeamHomeName("B");
            e.setDate(future(1).getTime());
            eventRepository.save(e);
        }

        if(!eventRepository.findById("55555").isPresent()) {
            Event e = new Event();
            e.setEventId("55555");
            e.setLeague("yyy");
            e.setSport("Football");
            e.setCountry("Venezuela");
            e.setTeamAwayName("A");
            e.setTeamHomeName("B");
            e.setDate(future(10).getTime());
            eventRepository.save(e);
        }

    }

    public Date future(int days) {
        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, days);
        return c.getTime() ;

    }

}
