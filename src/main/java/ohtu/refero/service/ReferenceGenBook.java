
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
        bok.generateReferenceId(book);
    }
    @Override
    public String generateReferenceId(Object object) {
        try {
        book = (Book) object;
        } catch(Exception e){
            System.out.println("Faulty parameter");
        }
        refID += book.getAuthor().substring(0, 2);
        System.out.println(refID);
        return "lol";
        
        
        
        
        }
    
    
        
    
    
}
