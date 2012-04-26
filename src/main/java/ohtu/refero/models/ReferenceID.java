
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReferenceID other = (ReferenceID) obj;
        if ((this.referenceID == null) ? (other.referenceID != null) : !this.referenceID.equals(other.referenceID)) {
            return false;
        }
        return true;
    }

    
    
    
    
    
    
}
