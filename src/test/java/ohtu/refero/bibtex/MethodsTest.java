//package ohtu.refero.bibtex;
//
//import java.lang.reflect.Method;
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//import org.junit.Test;
//
//public class MethodsTest {
//    
//    private Method notGetter;
//    private Method getter;
//    
//    public MethodsTest() {
//        
//        Method[] methods = MethodsTest.class.getDeclaredMethods();
//        
//        for (Method method : methods) {
//            
//            if (method.getName().equals("notGetter")) {
//                notGetter = method;
//            }
//            
//            if (method.getName().equals("getter")) {
//                getter = method;
//            }
//        }
//    }
//    
//    public void notGetter(String argument) {
//        
//    }
//    
//    public String getter() {
//        return "";
//    }
//    
//    @Test
//    public void isGetter() {
//        assertTrue(Methods.isGetter(getter));
//    }
//    
//    @Test
//    public void isNotGetter() {
//        assertFalse(Methods.isGetter(notGetter));
//    }
//}