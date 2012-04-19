/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

public interface ReferenceGenerator {
    String generateReferenceId(Object object);
    boolean checkIfConflict(String refID);
    String appendSuffix(String refID);
    
}
