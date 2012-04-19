
package ohtu.refero.service;

import ohtu.refero.models.Book;
import org.springframework.beans.factory.annotation.Autowired;


public class ReferenceGenBook implements ReferenceGenerator{



    @Autowired
    BookService bookServ;
    
    private Book book;
    private String refID = "";
    
    
    public static void main(String[] args) {
        ReferenceGenBook bok = new ReferenceGenBook();
        Book book = new Book();
        book.setAuthor("Jasper");
        book.setReleaseYear(2012);
        System.out.println(bok.generateReferenceId(book));
        
        
    }
    @Override
    public String generateReferenceId(Object object) {
        try {
        book = (Book) object;
        } catch(Exception e){
            System.out.println("Faulty parameter");
        }
        //append authors surnames first 2 letters
        refID += book.getAuthor().substring(0, 2);
        //append years last two digits
        String year = book.getReleaseYear()+"";
        year = year.substring(year.length()-2, year.length());
        refID += year;
        
        return refID;
        
        
        
        
        }

    @Override
    public boolean checkIfConflict(String refID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String appendSuffix(String refID) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
        
    
    
}
