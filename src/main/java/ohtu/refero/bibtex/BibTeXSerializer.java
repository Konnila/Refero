package ohtu.refero.bibtex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibTeXSerializer {

    private BibTeXGenerator generator;
    
    private BibTeXSerializer() {
        generator = new BibTeXGenerator();
    }
    
    private List<String> getFieldNamesToExclude(Object object) {
        
        ArrayList<String> fieldNamesToExclude = new ArrayList<String>();     
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXExclude.class) != null) {
                fieldNamesToExclude.add(field.getName().toLowerCase());
            }
        }
        
        fieldNamesToExclude.add("referenceid");
        
        return fieldNamesToExclude;
    }
    
    private Map<String, BibTeXProperty> getFieldsWithProperties(Object object) {
        
        HashMap<String, BibTeXProperty> fieldsWithProperties = new HashMap<String, BibTeXProperty>();
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXProperty.class) != null) {
                fieldsWithProperties.put(field.getName().toLowerCase(), field.getAnnotation(BibTeXProperty.class));
            }
        }
        
        return fieldsWithProperties;
    }
    
    private Map<String, Method> getGetters(Object object) {
        
        TreeMap<String, Method> getters = new TreeMap<String, Method>();
        
        for (Method method : object.getClass().getMethods()) {
        
            if (Methods.isGetter(method) && !method.getName().equals("getClass")) {
                String fieldName = method.getName().replace("get", "").toLowerCase();
                getters.put(fieldName, method);
            }
        }
        
        return getters;
    }
    
    private void writeVariables(Map<String, Method> getters, Object object) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        List<String> fieldNamesToExclude = getFieldNamesToExclude(object);
        Map<String, BibTeXProperty> fieldsWithProperties = getFieldsWithProperties(object);
        
        Set<String> fieldNames = getters.keySet();
        Iterator<String> fieldNamesIterator = fieldNames.iterator();
        
        while (fieldNamesIterator.hasNext()) {
            
            String fieldName = fieldNamesIterator.next();
            
            // Exclude
            if (fieldNamesToExclude.contains(fieldName)) {
                continue;
            }
            
            Method method = getters.get(fieldName);
            Object value = method.invoke(object);
            
            // Don't write null objects
            if (value == null) {
                continue;
            }
            
            // Field name
            if (fieldsWithProperties.containsKey(fieldName)) {
                fieldName = fieldsWithProperties.get(fieldName).name();
            }
            
            generator.writeObjectField(fieldName, value);
            
            if (fieldNamesIterator.hasNext()) {
                generator.writeSeparator();
            }
            
            generator.writeNewline();
        }
    }
    
    private String serializeObject(Object object) throws NoReferenceIdException {
        
        String className = object.getClass().getSimpleName().toLowerCase();        
        Map<String, Method> getters = getGetters(object);
        
        if (!getters.containsKey("referenceid")) {
            throw new NoReferenceIdException("The object doesn't seem to contain a getter (getReferenceId) for a required reference id.");
        }
        
        try {
            generator.writeObjectFieldStart(className);
        
            Method method = getters.get("referenceid");
            generator.writeObject(method.invoke(object));
        
            if (getters.size() > 1) {
                generator.writeSeparator();
                generator.writeNewline();
            }

            writeVariables(getters, object);
        
            generator.writeObjectEnd();
        } catch (Exception exception) {
            System.out.println("BibTexSerializer failed miserably.");
            exception.printStackTrace();
        }
        
        return generator.toString();
    }
    
    public static String serialize(Object object) throws NoReferenceIdException {
        
        BibTeXSerializer serializer = new BibTeXSerializer();
        return serializer.serializeObject(object);
    }
}