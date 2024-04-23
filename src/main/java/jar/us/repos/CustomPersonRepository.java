package jar.us.repos;

import jar.us.entities.Person;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface CustomPersonRepository {

    Person save(Person person);
}
