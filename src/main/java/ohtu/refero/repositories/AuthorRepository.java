/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.repositories;

import java.io.Serializable;
import java.util.List;
import ohtu.refero.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstNameAndSurName(String firstName, String surName);
}
