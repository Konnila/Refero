package ohtu.refero.repositories;

import ohtu.refero.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
