
package ohtu.refero.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ReferenceID extends JPAObject {
    
    private String referenceID;
    
    
    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }

    @Override
    public String toString() {
        return referenceID;
    }
    
    
    
    
}
