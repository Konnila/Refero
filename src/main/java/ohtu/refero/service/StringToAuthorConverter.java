/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import java.util.List;
import ohtu.refero.models.Author;

public interface StringToAuthorConverter {
    List<Author> convertToAuthor(String toConvert);
}
