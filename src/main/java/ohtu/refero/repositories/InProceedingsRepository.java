package ohtu.refero.repositories;

import ohtu.refero.models.InProceedings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InProceedingsRepository extends JpaRepository<InProceedings, Long> {
    InProceedings findById(Long id);
}