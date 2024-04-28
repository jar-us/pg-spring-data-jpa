package jar.us.repos;

import jar.us.entities.CountryNamesOnly;
import jar.us.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);

    List<Person> findByNameAndCountry(String name, String country);

    Integer countByCountry(String country);

    Collection<CountryNamesOnly> findByCountry(String name);
}
