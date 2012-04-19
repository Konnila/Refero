/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import ohtu.refero.models.Book;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    
    
    public static void main(String[] args) {
        ReferenceGenBook refGen = new ReferenceGenBook();
        Book book = new Book();
        book.setAuthor("Jammu");
        book.setReleaseYear(2012);
        
        refGen.generateReferenceId(book);
        
    }
}
