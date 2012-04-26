/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import ohtu.refero.models.Author;
import org.springframework.stereotype.Service;

@Service
public class StringToAuthorConverterImp implements StringToAuthorConverter {

    @Override
    public List<Author> convertToAuthor(String toConvert) {
        List<Author> listOfAuthors = new ArrayList<Author>();
        String[] authors = toConvert.split(",");
        for (String string : authors) {
            String[] firstAndSurnames = string.split(" ");
            Author author = new Author();
            if (firstAndSurnames.length == 2) {
                author.setFirstName(firstAndSurnames[0]);
                author.setSurName(firstAndSurnames[1]);
            }
            else author.setSurName(firstAndSurnames[0]);
            listOfAuthors.add(author);
        }
        return listOfAuthors;
    }
}
