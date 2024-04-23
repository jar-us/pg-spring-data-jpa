package jar.us.dao.crud;

import jar.us.entities.Person;
import jar.us.repos.PersonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonCrudDaoImpl implements PersonCrudDao {

    private final PersonRepository personRepository;

    public PersonCrudDaoImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        Optional<Person> existingPerson = personRepository.findById(person.getId());
        if (existingPerson.isPresent()) {
            return personRepository.save(person);
        } else {
            throw new RuntimeException("Person not found with id: " + person.getId());
        }
    }

    @Override
    public void deletePerson(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person getPerson(Integer id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> addAllPersons(List<Person> persons) {
        return personRepository.saveAll(persons);
    }

}
