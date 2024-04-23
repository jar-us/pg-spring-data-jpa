package jar.us.dao.dervied;

import jar.us.repos.PersonRepository;
import org.springframework.stereotype.Component;

@Component
public class PersonDerivedDaoImpl implements PersonDerivedDao {

   private final PersonRepository personRepository;

    public PersonDerivedDaoImpl(PersonRepository personRepository) {
         this.personRepository = personRepository;
    }


    @Override
    public Integer countByCountry(String country) {
        return personRepository.countByCountry(country);
    }
}
