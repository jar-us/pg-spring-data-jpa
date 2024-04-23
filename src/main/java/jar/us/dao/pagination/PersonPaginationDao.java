package jar.us.dao.pagination;

import jar.us.entities.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface PersonPaginationDao {
    Page<Person> getPersons(PageRequest pageRequest);
}
