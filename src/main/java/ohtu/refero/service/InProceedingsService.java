package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.InProceedings;

public interface InProceedingsService {
    
    public InProceedings save(InProceedings inProceedings);
    public List<InProceedings> findAll();
    public InProceedings findById(Long id);
}