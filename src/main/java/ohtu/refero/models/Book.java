package ohtu.refero.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import ohtu.refero.bibtex.BibTeXProperty;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book extends Reference {

    @NotBlank(message = "Publisher can't be empty.")
    private String publisher;
    

    @Override
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }
}