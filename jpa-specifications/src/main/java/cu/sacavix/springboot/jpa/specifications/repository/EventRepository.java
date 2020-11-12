package cu.sacavix.springboot.jpa.specifications.repository;

import cu.sacavix.springboot.jpa.specifications.entity.Event;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event, String>, JpaSpecificationExecutor<Event> {

}
