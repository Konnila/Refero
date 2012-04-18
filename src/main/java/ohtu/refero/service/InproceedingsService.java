package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Inproceedings;

public interface InproceedingsService {
    
    public Inproceedings save(Inproceedings inProceedings);
    public List<Inproceedings> findAll();
    public Inproceedings findById(Long id);
}