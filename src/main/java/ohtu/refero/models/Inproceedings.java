package ohtu.refero.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;
import ohtu.refero.bibtex.BibTeXProperty;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Inproceedings extends Reference {

    @NotBlank(message="Booktitle cannot be empty.")
    private String bookTitle;
    @Pattern(regexp = "\\d+--\\d+|", message = "Insert the pagenumbers in a format like: 1--25")
    private String pages;


    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPages() {
        return pages;
    }

    public String getBookTitle() {
        return bookTitle;
    }



    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
   
}