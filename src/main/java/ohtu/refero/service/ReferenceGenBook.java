
package ohtu.refero.service;

import ohtu.refero.models.Book;
import org.springframework.beans.factory.annotation.Autowired;


public class ReferenceGenBook implements ReferenceGenerator{

    @Override
    public String generateReferenceId(Object object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

//    @Autowired
//    BookService bookServ;
//    private Book book;
//    @Override
//    public String generateReferenceId(Object object) {
//        try {
//        book = (Book) object;
//        } catch(Exception e){
//            System.out.println("Faulty parameter");
//        }
//        }
    
    
        
    
    
}
