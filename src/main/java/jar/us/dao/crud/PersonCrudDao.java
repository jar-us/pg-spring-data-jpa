package jar.us.dao.crud;

import jar.us.entities.Person;

import java.util.List;

public interface PersonCrudDao {
    Person addPerson(Person person);

    List<Person> addAllPersons(List<Person> persons);

    Person getPerson(Integer id);

    List<Person> getAllPersons();

    Person updatePerson(Person person);

    void deletePerson(Integer person);
}
