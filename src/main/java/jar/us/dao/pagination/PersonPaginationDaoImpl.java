package jar.us.dao.pagination;

import jar.us.entities.Person;
import jar.us.repos.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;


@Component
public class PersonPaginationDaoImpl implements PersonPaginationDao {


    private PersonRepository personRepository;

    public PersonPaginationDaoImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public Page<Person> getPersons(PageRequest pageRequest) {
        return personRepository.findAll(pageRequest);
    }
}
