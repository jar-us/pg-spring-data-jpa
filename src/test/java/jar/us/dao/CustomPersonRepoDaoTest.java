package jar.us.dao;

import jar.us.entities.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomPersonRepoDaoTest {


   @Autowired
    private CustomPersonRepoDao customPersonRepoDao;

    @Test
    @Transactional
    void savePerson() {
        Person person = new Person();

        person.setName("John");
        person.setEmail("john@example.com");
        person.setCountry("USA");


        Integer id = customPersonRepoDao.savePerson(person);

        assertNotNull(id);
    }
}