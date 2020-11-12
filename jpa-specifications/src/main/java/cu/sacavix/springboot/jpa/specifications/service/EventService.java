package cu.sacavix.springboot.jpa.specifications.service;

import cu.sacavix.springboot.jpa.specifications.entity.Event;
import cu.sacavix.springboot.jpa.specifications.repository.EventRepository;
import cu.sacavix.springboot.jpa.specifications.search.SearchCriteria;
import cu.sacavix.springboot.jpa.specifications.search.SearchOperation;
import cu.sacavix.springboot.jpa.specifications.search.SearchSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository ;

    /**
     * Buscar todos los eventos donde los deportes, paises y ligas coincidan con sports, countries, leagues y que sea despues de la fecha actual
     * @param sports
     * @param countries
     * @param leagues
     * @return
     */
    public List<Event> search(List<String> sports, List<String> countries, List<String> leagues) {
        SearchSpecifications<Event> searchSpecifications = new SearchSpecifications<>();
        if(sports.size()>0){
            searchSpecifications.add(new SearchCriteria("sport",sports, SearchOperation.IN));
        }
        if(countries.size()>0){
            searchSpecifications.add(new SearchCriteria("country",countries, SearchOperation.IN));
        }
        if(leagues.size()>0){
            searchSpecifications.add(new SearchCriteria("league",leagues, SearchOperation.IN));
        }
        searchSpecifications.add(new SearchCriteria("date", new Date().getTime(), SearchOperation.GREATER_THAN));

        return eventRepository.findAll(searchSpecifications) ;
    }

}
