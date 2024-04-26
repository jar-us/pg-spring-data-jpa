package jar.us.repos;

import jar.us.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    List<User> findByEmailIgnoreCase(String email);

    List<User> findByAgeGreaterThanEqual(Integer age);

    List<User> findByNameOrderByAgeDesc(String name);


    Streamable<User> findByAgeLessThan(Integer age);

    Stream<User> findAllByAgeGreaterThan(Integer age);

    Page<User> findByNameContaining(String name, Pageable pageable);

    Slice<User> findByEmailContaining(String email, Pageable pageable);
}
