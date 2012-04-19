package ohtu.refero.models;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Article extends Reference {

    @NotBlank(message = "Journal can't be empty.")
    private String journal;
    @Min(value = 1, message = "Volume must be at least 1.")
    private Integer volume;
    @Min(value = 1, message = "Number must be at least 1.")
    private Integer number;
    @Pattern(regexp = "\\d+--\\d+", message = "Insert the pagenumbers in a format like: 1-25")
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
}