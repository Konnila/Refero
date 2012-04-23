
package ohtu.refero.models;

import java.io.Serializable;
import javax.persistence.Id;

public class ReferenceID implements Serializable {
    private String referenceID;
    
    @Id
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(String referenceID) {
        this.referenceID = referenceID;
    }
    
    
    
}
