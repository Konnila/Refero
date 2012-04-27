package ohtu.refero.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import ohtu.refero.bibtex.BibTeXId;
import ohtu.refero.bibtex.BibTeXProperty;
import org.hibernate.validator.constraints.NotBlank;

@MappedSuperclass
public abstract class Reference extends JPAObject {
    
   
    
    @NotBlank(message = "Title can't be empty.")
    private String title;
    
    @BibTeXProperty(name = "year")
    @NotNull(message = "Year can't be empty.")
    private Integer releaseYear;
    
    private String publisher;
    
    private String address;
    @ManyToMany
    @BibTeXProperty(name = "author")
    private List<Author> authors;
    @OneToOne
    @BibTeXId
    private ReferenceID referenceID;

//    private String referenceID;
//    public String getReferenceID() {
//        return referenceID;
//    }
//
//    public void setReferenceID(String referenceID) {
//        this.referenceID = referenceID;
//    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReferenceID getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(ReferenceID referenceID) {
        this.referenceID = referenceID;
    }
    

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Reference other = (Reference) obj;
        if (this.getId() == null || other.getId() == null || this.getId() != other.getId()) {
            return false;
        }

        return true;
    }
}