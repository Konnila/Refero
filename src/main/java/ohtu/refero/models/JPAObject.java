package ohtu.refero.models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import ohtu.refero.bibtex.BibTeXExclude;
import ohtu.refero.bibtex.BibTeXId;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class JPAObject implements Serializable, Persistable<Long> {
    @BibTeXExclude
    @Id
    @GeneratedValue
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