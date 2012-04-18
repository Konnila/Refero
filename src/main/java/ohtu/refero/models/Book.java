package ohtu.refero.models;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book extends Reference {

    @NotBlank(message="Publisher can't be empty.")
    private String publisher;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Article other = (Article) obj;
        if (this.getId() == null || other.getId() == null || this.getId() != other.getId()) {
            return false;
        }

        return true;
    }
}