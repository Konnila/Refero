package ohtu.refero.models;

import javax.persistence.Entity;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Inproceedings extends Reference {

    @NotBlank(message="Book Title can't be empty.")
    private String bookTitle;
    private String pages;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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