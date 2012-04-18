package ohtu.refero.models;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Article extends Reference {

    @NotBlank(message = "Journal can't be empty.")
    private String journal;
    @Min(1)
    private Integer volume;
    @Min(1)
    private Integer number;
    private String pages;

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
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