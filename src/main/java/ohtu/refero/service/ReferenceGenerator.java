/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import ohtu.refero.models.Reference;
import ohtu.refero.models.ReferenceID;


public interface ReferenceGenerator {
    ReferenceID generateReferenceId(Reference reference);
}
