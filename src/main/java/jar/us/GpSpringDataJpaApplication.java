package jar.us;

import jar.us.entities.Customer;
import jar.us.entities.Person;
import jar.us.entities.Product;
import jar.us.repos.CustomerRepository;
import jar.us.repos.PersonRepository;
import jar.us.repos.ProductRepository;
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

    @Bean
    CommandLineRunner init(CustomerRepository customerRepository, ProductRepository productRepository) {
        return args -> {
            Customer customer = new Customer();
            customer.setName("John Doe");
            customerRepository.save(customer);

            Product product = new Product();
            product.setProductName("Widget");
            product.setId(1L); // Manually setting ID
            product.setNew(true);
            productRepository.save(product);
            product.setNew(false);
            product.setProductName("Widget-2");
            productRepository.save(product);
        };
    }

}

