package ohtu.refero.bibtex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fields {

    public static List<Field> getAllDeclaredFields(Class c) {
        
        ArrayList<Field> fields = new ArrayList<Field>(); 
        
        do {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
            c = c.getSuperclass();
        } while (c.getSuperclass() != null);

        return fields;
    }
}