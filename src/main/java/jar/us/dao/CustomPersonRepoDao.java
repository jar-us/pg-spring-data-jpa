package jar.us.dao;

import jar.us.entities.Person;
import jar.us.repos.CustomPersonRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomPersonRepoDao {


   private final CustomPersonRepository customPersonRepository;

    public CustomPersonRepoDao(CustomPersonRepository customPersonRepository) {
         this.customPersonRepository = customPersonRepository;
    }


    public Integer savePerson(Person person) {
        return customPersonRepository.save(person).getId();
    }



}
