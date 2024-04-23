package jar.us;

import jar.us.entities.Person;
import jar.us.repos.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class GpSpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GpSpringDataJpaApplication.class, args);
    }

}

