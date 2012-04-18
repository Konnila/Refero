package ohtu.refero.models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import ohtu.refero.bibtex.BibTeXExclude;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class JPAObject implements Serializable, Persistable<Long> {

    @Id
    @GeneratedValue
    @BibTeXExclude
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean isNew() {
        return (id == null);
    }
}