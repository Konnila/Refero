package ohtu.refero.bibtex;

import java.lang.reflect.Method;

public class Methods {

    public static boolean isGetter(Method method) {
        
        if (method.getParameterTypes().length != 0) {
            return false;
        }
        
        if (!method.getName().startsWith("get")) {
            return false;
        }
        
        return true;
    }
}