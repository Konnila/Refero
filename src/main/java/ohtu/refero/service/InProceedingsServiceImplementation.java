package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Inproceedings;
import ohtu.refero.repositories.InproceedingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InproceedingsServiceImplementation implements InproceedingsService {

    @Autowired
    InproceedingsRepository inproceedingsRepository;

    @Transactional
    @Override
    public Inproceedings save(Inproceedings inProceedings) {
        
        if (inProceedings == null) {
            return null;
        }
        
        inProceedings = inproceedingsRepository.save(inProceedings);
        
        return inProceedings;
    }

    @Override
    public List<Inproceedings> findAll() {
        return inproceedingsRepository.findAll();
    }
    
    @Override
    public Inproceedings findById(Long id) {
        return inproceedingsRepository.findOne(id);
    }
}