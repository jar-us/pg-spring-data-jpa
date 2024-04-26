package jar.us.projection;

import jakarta.transaction.Transactional;
import jar.us.entities.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    @Transactional
    void findByAuthor() {

        // Save a new book in the database

        Book book = new Book();
        book.setTitle("Title");
        book.setAuthor("Author");
        book.setPageCount(100);
        bookRepository.save(book);


        List<BookSummary> books = bookRepository.findByAuthor("Author");
        assertEquals(1, books.size());
        assertEquals("Title", books.get(0).getTitle());
//        assertEquals("Author", books.get(0).getAuthor());
    }

}