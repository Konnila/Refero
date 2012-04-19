/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

public interface ReferenceGenerator {
    String generateReferenceId(Object object, BookService bookService);
    boolean checkIfConflict(String refID, BookService bs);
    String appendSuffix(String refID);
    
}
