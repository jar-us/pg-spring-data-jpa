package jar.us.projection;

import jar.us.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<BookSummary> findByAuthor(String author);
}
