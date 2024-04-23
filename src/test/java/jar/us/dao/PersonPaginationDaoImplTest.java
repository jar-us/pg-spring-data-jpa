package jar.us.dao;

import jar.us.dao.crud.PersonCrudDao;
import jar.us.dao.pagination.PersonPaginationDao;
import jar.us.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class PersonPaginationDaoImplTest {


    @Autowired
    private PersonPaginationDao personPaginationDao;

    @Autowired
    private PersonCrudDao personCrudDao;


    @Test
    void getPersons() {

        List<Person> persons = getPeople();

        personCrudDao.addAllPersons(persons);

        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Person> personsPage = personPaginationDao.getPersons(pageRequest);

        assertEquals(5, personsPage.getSize());
        assertEquals(4, personsPage.getTotalPages());
        assertEquals(20, personsPage.getTotalElements());
        assertEquals(0, personsPage.getNumber());
        assertEquals(5, personsPage.getContent().size());

        personsPage.getContent().forEach(System.out::println);

        // Page 2

        pageRequest = PageRequest.of(1, 5);
        personsPage = personPaginationDao.getPersons(pageRequest);

        assertEquals(5, personsPage.getSize());
        assertEquals(4, personsPage.getTotalPages());
        assertEquals(20, personsPage.getTotalElements());
        assertEquals(1, personsPage.getNumber());
        assertEquals(5, personsPage.getContent().size());

        personsPage.getContent().forEach(System.out::println);

        // Page 3

        pageRequest = PageRequest.of(2, 5);
        personsPage = personPaginationDao.getPersons(pageRequest);

        assertEquals(5, personsPage.getSize());
        assertEquals(4, personsPage.getTotalPages());
        assertEquals(20, personsPage.getTotalElements());
        assertEquals(2, personsPage.getNumber());
        assertEquals(5, personsPage.getContent().size());

        personsPage.getContent().forEach(System.out::println);

        // Page 4

        pageRequest = PageRequest.of(3, 5);
        personsPage = personPaginationDao.getPersons(pageRequest);

        assertEquals(5, personsPage.getSize());
        assertEquals(4, personsPage.getTotalPages());
        assertEquals(20, personsPage.getTotalElements());
        assertEquals(3, personsPage.getNumber());
        assertEquals(5, personsPage.getContent().size());

        personsPage.getContent().forEach(System.out::println);

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


    private static Person createPerson(String name, String email, String country) {
        return new Person(name, email, country);
    }


}