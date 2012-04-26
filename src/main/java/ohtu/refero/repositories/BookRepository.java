package ohtu.refero.repositories;

import ohtu.refero.models.Book;
import ohtu.refero.models.ReferenceID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Book findByReferenceID(ReferenceID id);
}