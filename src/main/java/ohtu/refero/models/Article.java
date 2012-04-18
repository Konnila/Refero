package ohtu.refero.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Article extends Reference {

    @NotBlank(message="Journal can't be empty.")
    private String journal;
    
    //@Min(0, message = "numbers plz")
    @NotNull(message="Volume can't be empty.")
    private Integer volume; 
    
    private Integer number;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

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