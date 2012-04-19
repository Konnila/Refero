package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Book;
import ohtu.refero.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//FIXME !!===%%%

@Service
public class ReferenceGenBook implements ReferenceGenerator {

    private char suffix;
    

    public ReferenceGenBook() {
        
        suffix = 'a';

    }


    @Override
    public String generateReferenceId(Object object, BookService bookService) {
        Book book = (Book) object;
        String rID = "";
        //append authors surnames first 2 letters
        rID += book.getAuthor().substring(0, 2);
        //append years last two digits
        String year = book.getReleaseYear() + "";
        year = year.substring(year.length() - 2, year.length());
        rID += year;

        while (checkIfConflict(rID, bookService)) {
            rID = appendSuffix(rID);
            suffix++;
        }

        return rID;

    }

    @Override
    public boolean checkIfConflict(String refID, BookService bookService) {
            if(bookService.findByReferenceId(refID) == null) return false;
            return true;
        

    }

    @Override
    public String appendSuffix(String refID) {

        if (refID.length() < 5) {
            return (refID + suffix);
        }
        if (refID.length() > 4 && refID.charAt(refID.length()) == 'z') {
            suffix = 'a';
            return refID + suffix;
        }

        return refID.replace(refID.charAt(refID.length()), suffix);
    }
}
