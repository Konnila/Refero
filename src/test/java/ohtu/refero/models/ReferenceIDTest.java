/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.refero.models;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author Lauri
 */
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
    public void toStringIsValid() {
        assertEquals(testReference.toString(), "koira");
    }
    
    @Test
    public void equalsIsValid() {
        ReferenceID another = new ReferenceID();

        //obj == null
        assertEquals(testReference.equals(null), false);

        //getClass() != obj.getClass()
        assertEquals(testReference.equals(new ReferenceIDTest()), false);

        //other.getId() == null
        testReference.setReferenceID(null);
        another.setReferenceID(null);
        assertTrue(testReference.equals(another));
        
        another.setReferenceID("kissaElain");
        assertFalse(testReference.equals(another));

        //this.getId() == null
        assertFalse(another.equals(testReference));

        //this.getId() != other.getId()
        testReference.setReferenceID("koiraElain");
        assertFalse(testReference.equals(another));

        //this.getId() == other.getId() 
        assertTrue(testReference.equals(testReference));

    }
}