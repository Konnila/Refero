package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.InProceedings;
import ohtu.refero.repositories.InProceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InProceedingsServiceImplementation implements InProceedingsService {

    @Autowired
    InProceedingsRepository inProceedingsRepository;

    @Transactional
    @Override
    public InProceedings save(InProceedings inProceedings) {
        
        if (inProceedings == null) {
            return null;
        }
        
        inProceedings = inProceedingsRepository.save(inProceedings);
        
        return inProceedings;
    }

    @Override
    public List<InProceedings> findAll() {
        return inProceedingsRepository.findAll();
    }
    
    @Override
    public InProceedings findById(Long id) {
        return inProceedingsRepository.findById(id);
    }
}