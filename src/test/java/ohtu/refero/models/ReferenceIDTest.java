package ohtu.refero.models;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ReferenceIDTest {

    ReferenceID testReference;

    @Before
    public void initialize() {
        testReference = new ReferenceID();
        testReference.setReferenceID("koira");
    }

    @Test
    public void gettersAndSetters() {
        assertEquals(testReference.getReferenceID(), "koira");
    }

    @Test
    public void equalsIsValid() {
        ReferenceID b = new ReferenceID();

        //obj == null
        assertEquals(testReference.equals(null), false);

        //getClass() != obj.getClass()
        assertEquals(testReference.equals(new ArticleTest()), false);

        //other.getId() == null
        testReference.setReferenceID(null);
        b.setReferenceID(null);     
        assertTrue(testReference.equals(b));
        
        b.setReferenceID("kissa");
        assertFalse(testReference.equals(b));

        //this.getId() == null
        assertFalse(b.equals(testReference));

        //this.getId() != other.getId()
        testReference.setReferenceID("koira");
        assertFalse(testReference.equals(b));

        //this.getId() == other.getId() 
        assertTrue(testReference.equals(testReference));

    }
}
