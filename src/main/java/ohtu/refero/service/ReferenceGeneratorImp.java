/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.service;

import ohtu.refero.models.Reference;
import ohtu.refero.models.ReferenceID;
import ohtu.refero.repositories.ReferenceIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author konnila
 */
@Service
public class ReferenceGeneratorImp implements ReferenceGenerator {

    @Autowired
    ReferenceIDRepository referenceIDrepo;

    @Transactional
    @Override
    public ReferenceID generateReferenceId(Reference reference) {
        //Here we shalt copy 2 first letters from Authors name to refID
        String refID = reference.getAuthor().substring(0, 2);
        //Now we append 2 last digits from references Releaseyear to ref, which we shalt return
        String year = reference.getReleaseYear() + "";
        year = year.substring(year.length() - 2, year.length());
        refID += year;

        ReferenceID referenceID = new ReferenceID();
        //loop until unique refID
        while (referenceIDrepo.findByReferenceID(refID) != null) {
            refID = appendSuffix(refID);
        }
        //Okay, refID should be unique now
        referenceID.setReferenceID(refID);
        return referenceIDrepo.save(referenceID);
    }

    public String appendSuffix(String refid) {
        if (refid.length() < 5) return refid + 'a';    
        if (refid.endsWith("z")) return refid + 'a';
        //create char[]in order to change the last char of string
        char[] refChar = refid.toCharArray();
        refChar[refChar.length-1]++;
        String returnableRefId = "";
        //convert char[] back to string
        for (int i = 0; i < refChar.length; i++) {
            returnableRefId += refChar[i];         
        }
        
        return returnableRefId;
    }

}
