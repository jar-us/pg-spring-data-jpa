package jar.us.dao;

import jar.us.dao.crud.PersonCrudDao;
import jar.us.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
public class PersonCrudDaoImplIntegrationTest {

    @Autowired
    private PersonCrudDao personCrudDao;


    @Test
    void testAddPerson() {
        Person person = createPerson("John Doe", "john@example.com", "USA");
        Person savedPerson = personCrudDao.addPerson(person);
        assertPerson(person, savedPerson);
    }

    @Test
    void testUpdatePerson() {
        Person person = createPerson("John Doe", "john@example.com", "USA");
        Person savedPerson = personCrudDao.addPerson(person);
        savedPerson.setName("Jane Doe");
        Person updatedPerson = personCrudDao.updatePerson(savedPerson);
        assertEquals("Jane Doe", updatedPerson.getName());
    }

    @Test
    void testUpdatePersonNotFound() {
        Person person = createPerson("John Doe", "john@example.com", "USA");
        person.setId(1000);
        assertThrows(RuntimeException.class, () -> personCrudDao.updatePerson(person));
    }

    @Test
    void testDeletePerson() {
        Person person = createPerson("John Doe", "john@example.com", "USA");
        Person savedPerson = personCrudDao.addPerson(person);
        personCrudDao.deletePerson(savedPerson.getId());
        assertNull(personCrudDao.getPerson(savedPerson.getId()));
    }

    @Test
    void testGetPersonById() {
        Person person = createPerson("John Doe", "john@gmail.com", "USA");
        Person savedPerson = personCrudDao.addPerson(person);
        Person retrievedPerson = personCrudDao.getPerson(savedPerson.getId());
        assertPerson(person, retrievedPerson);
    }

    @Test
    void testGetPersonByIdNotFound() {
        assertNull(personCrudDao.getPerson(1000));
    }

    @Test
    void testGetAllPersons() {
        personCrudDao.addPerson(createPerson("John Doe", "john@gmail.com", "USA"));
        personCrudDao.addPerson(createPerson("Jane Doe", "jane@outlook.com", "UK"));
        assertEquals(2, personCrudDao.getAllPersons().size());
    }

    @Test
    void testAddAllPersons() {
        List<Person> persons = getPeople();
        List<Person> savedPersons = personCrudDao.addAllPersons(persons);
        assertEquals(20, savedPersons.size());
    }

    private static Person createPerson(String name, String email, String country) {
        return new Person(name, email, country);
    }

    private void assertPerson(Person expected, Person actual) {
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getCountry(), actual.getCountry());
    }

    private static List<Person> getPeople() {
        List<Person> persons = new ArrayList<>();
        String[] names = {"John Doe", "Jane Smith", "Alice Johnson", "Robert Brown", "David Wilson"};
        String[] countries = {"USA", "UK", "Canada", "Australia", "Germany"};
        String[] emailProviders = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "aol.com"};

        for (int i = 1; i <= 20; i++) {
            String name = names[i % names.length];
            String email = name.toLowerCase().replace(" ", ".") + i + "@" + emailProviders[i % emailProviders.length];
            String country = countries[i % countries.length];
            persons.add(createPerson(name, email, country));
        }
        return persons;
    }


//    @Test
//    @Transactional
//    void testAddPerson() {
//        Person person = new Person("John Doe", "john@example.com", "USA");
//        Person savedPerson = personCrudDao.addPerson(person);
//
//        assertNotNull(savedPerson);
//
//        int id = savedPerson.getId();
//
//        Person person1 = personCrudDao.getPerson(id);
//
//        assertEquals(person.getName(), person1.getName());
//        assertEquals(person.getEmail(), person1.getEmail());
//        assertEquals(person.getCountry(), person1.getCountry());
//    }
//
//    @Test
//    @Transactional
//    void testUpdatePerson() {
//        Person person = new Person("John Doe", "john@example.com", "USA");
//
//        Person savedPerson = personCrudDao.addPerson(person);
//
//        assertNotNull(savedPerson);
//
//        int id = savedPerson.getId();
//
//        Person person1 = personCrudDao.getPerson(id);
//
//        person1.setName("Jane Doe");
//
//        Person updatedPerson = personCrudDao.updatePerson(person1);
//
//        assertEquals("Jane Doe", updatedPerson.getName());
//
//    }
//
//    @Test
//    @Transactional
//    void testUpdatePersonNotFound() {
//
//        Person person = new Person("John Doe", "john@example.com", "USA");
//
//        person.setId(1000);
//
//        try {
//            personCrudDao.updatePerson(person);
//        } catch (RuntimeException e) {
//            assertEquals("Person not found with id: 1000", e.getMessage());
//        }
//    }
//
//    @Test
//    @Transactional
//    void testDeletePerson() {
//        Person person = new Person("John Doe", "john@example.com", "USA");
//
//        Person savedPerson = personCrudDao.addPerson(person);
//
//        assertNotNull(savedPerson);
//
//        int id = savedPerson.getId();
//
//        personCrudDao.deletePerson(id);
//
//        Person person1 = personCrudDao.getPerson(id);
//
//        assertNull(person1);
//
//    }
//
//    @Test
//    @Transactional
//    void testGetPersonById() {
//        Person person = new Person("John Doe", "john@gmail.com", "USA");
//
//        Person savedPerson = personCrudDao.addPerson(person);
//
//        assertNotNull(savedPerson);
//
//        int id = savedPerson.getId();
//
//        Person person1 = personCrudDao.getPerson(id);
//
//        assertNotNull(person1);
//
//        assertEquals(person.getName(), person1.getName());
//    }
//
//    @Test
//    @Transactional
//    void testGetPersonByIdNotFound() {
//        Person person = personCrudDao.getPerson(1000);
//
//        assertNull(person);
//    }
//
//    @Test
//    @Transactional
//    void testGetAllPersons() {
//        Person person1 = new Person("John Doe", "john@gmail.com", "USA");
//
//        Person person2 = new Person("Jane Doe", "jane@outlook.com", "UK");
//
//        personCrudDao.addPerson(person1);
//        personCrudDao.addPerson(person2);
//
//        assertEquals(2, personCrudDao.getAllPersons().size());
//
//    }
//
//
//    @Test
//    @Transactional
//    void testAddAllPersons() {
//        List<Person> persons = getPeople();
//
//        List<Person> people = personCrudDao.addAllPersons(persons);
//
//        assertEquals(20, people.size());
//
//    }
//
//    private static List<Person> getPeople() {
//        List<Person> persons = new ArrayList<>();
//        String[] names = {"John Doe", "Jane Smith", "Alice Johnson", "Robert Brown", "David Wilson"};
//        String[] countries = {"USA", "UK", "Canada", "Australia", "Germany"};
//        String[] emailProviders = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "aol.com"};
//
//        for (int i = 1; i <= 20; i++) {
//            String name = names[i % names.length];
//            String email = name.toLowerCase().replace(" ", ".") + i + "@" + emailProviders[i % emailProviders.length];
//            String country = countries[i % countries.length];
//            Person person = new Person(name, email, country);
//            persons.add(person);
//        }
//        return persons;
//    }
}





