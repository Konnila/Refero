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
        year.substring(year.length() - 3, year.length() - 1);
        refID += year;

        ReferenceID referenceID = new ReferenceID();
        //loop until unique refID
        while (referenceIDrepo.findByReferenceID(refID) != null) {
            refID = appendSuffix(refID);
        }
        //Okay, refID should be unique
        referenceID.setReferenceID(refID);
        return referenceIDrepo.save(referenceID);
    }

    public String appendSuffix(String refid) {
//        char appendent;

        if (refid.length() < 5) return refid + 'a';
        
        if (refid.endsWith("z")) return refid + 'a';
        
//        appendent = refid.charAt(refid.length()-1);
//        appendent++;
        char[] refChar = refid.toCharArray();
        refChar[refChar.length-1]++;
        String returnableRefId = "";
        for (int i = 0; i < refChar.length; i++) {
            returnableRefId += refChar[i];         
        }
        return returnableRefId;
    }

}
