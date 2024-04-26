package jar.us.repos;

import jar.us.entities.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
//    @Transactional
    void findByName() {
        // create 5 users objects with different names, emails, and ages
        Result result = getResult();

        // save the users to the database
        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        // find all users with name "John"
        assertEquals(2, userRepository.findByName("John").size());
    }

    private static Result getResult() {
        User user1 = new User();
        user1.setName("John");
        user1.setEmail("john@example.com");
        user1.setAge(25);

        User user2 = new User();
        user2.setName("Jane");
        user2.setEmail("Jane@gmail.com");
        user2.setAge(30);

        User user3 = new User();
        user3.setName("Doe");
        user3.setEmail("Doe@outlook.com");
        user3.setAge(35);

        User user4 = new User();
        user4.setName("John");
        user4.setEmail("john@hello.com");
        user4.setAge(40);

        User user5 = new User();
        user5.setName("Jane");
        user5.setEmail("Jane@world.com");
        user5.setAge(45);
        return new Result(user1, user2, user3, user4, user5);
    }

    private record Result(User user1, User user2, User user3, User user4, User user5) {
    }

    @Test
    void findByEmailIgnoreCase() {

        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(1, userRepository.findByEmailIgnoreCase("JOHN@hello.com").size());
    }

    @Test
    void findByAgeGreaterThanEqual() {
        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(4, userRepository.findByAgeGreaterThanEqual(30).size());
    }

    @Test
    void findByNameOrderByAgeDesc() {
        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(2, userRepository.findByNameOrderByAgeDesc("John").size());
    }

    @Test
    void findByAgeLessThan() {
        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(3, userRepository.findByAgeLessThan(40).toList().size());

    }

    @Test
    @Transactional
    void findAllByAgeGreaterThan() {
        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(3, userRepository.findAllByAgeGreaterThan(30).toList().size());


    }

    @Test
    void findByNameContaining() {

        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(1, userRepository.findByNameContaining("Jane", Pageable.ofSize(1)).toList().size());


    }

    @Test
    void findByEmailContaining() {
        Result result = getResult();

        userRepository.save(result.user1());
        userRepository.save(result.user2());
        userRepository.save(result.user3());
        userRepository.save(result.user4());
        userRepository.save(result.user5());

        assertEquals(1, userRepository.findByEmailContaining("world", Pageable.ofSize(1)).toList().size());
    }
}