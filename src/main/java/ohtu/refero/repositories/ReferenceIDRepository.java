
package ohtu.refero.repositories;

import ohtu.refero.models.ReferenceID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReferenceIDRepository extends JpaRepository<ReferenceID, Long> {
    public ReferenceID findByReferenceID(String referenceID);
}
