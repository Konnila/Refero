package ohtu.refero.models;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import ohtu.refero.bibtex.BibTeXProperty;
import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class Reference extends JPAObject {
    
    @NotBlank(message="Author can't be empty.")
    private String author;
    
    @NotBlank(message="Title can't be empty.")
    private String title;
    
    @NotNull(message="Year can't be empty.")
    @BibTeXProperty(name = "year")
    private Integer releaseYear;
    
    private String publisher;
    
    private String address;
    
    public Long getReferenceId() {
        return this.getId();
    }
    
    public void setReferenceId(Long referenceId) {
        this.setId(referenceId);
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}