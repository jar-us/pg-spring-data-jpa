package jar.us.dao.dervied;

import jar.us.dao.crud.PersonCrudDao;
import jar.us.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonDerivedDaoImplIntegrationTest {

    @Autowired
    private PersonDerivedDao personDerivedDao;

    @Autowired
    private PersonCrudDao personCrudDao;

    @Test
    void countByCountry() {
        List<Person> persons = getPeople();

        personCrudDao.addAllPersons(persons);

        Integer count = personDerivedDao.countByCountry("USA");
        assertEquals(4, count);
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