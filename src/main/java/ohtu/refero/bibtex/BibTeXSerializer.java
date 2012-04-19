package ohtu.refero.bibtex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibTeXSerializer {

    private Object object;
    private String fieldNameForId;
    private List<String> fieldNamesToExclude;
    private Map<String, BibTeXProperty> fieldsWithProperties;
    private Map<String, Method> getters;
    
    private BibTeXGenerator generator;
    
    private BibTeXSerializer(Object object) throws NoIdException {
        
        this.object = object;
        generator = new BibTeXGenerator();
        
        getFieldNameForId();
        getFieldNamesToExclude();
        getFieldsWithProperties();
        getGetters();
    }
    
    private void getFieldNameForId() throws NoIdException {
        
        fieldNameForId = null;
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXId.class) != null) {
                fieldNameForId = field.getName();
            }
        }
        
        if (fieldNameForId == null) {
            throw new NoIdException("The class hierarchy doesn't seem to have a required @BibTeXId annotation.");
        }
    }
    
    private void getFieldNamesToExclude() {
        
        fieldNamesToExclude = new ArrayList<String>();     
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXExclude.class) != null) {
                fieldNamesToExclude.add(field.getName().toLowerCase());
            }
        }
        
        // Exclude @BibTexId
        fieldNamesToExclude.add(fieldNameForId);
    }
    
    private void getFieldsWithProperties() {
        
        fieldsWithProperties = new HashMap<String, BibTeXProperty>();
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXProperty.class) != null) {
                fieldsWithProperties.put(field.getName().toLowerCase(), field.getAnnotation(BibTeXProperty.class));
            }
        }
    }
    
    private void getGetters() {
        
        getters = new TreeMap<String, Method>();
        
        for (Method method : object.getClass().getMethods()) {
        
            if (Methods.isGetter(method)) {
                
                // Not interested in serializing the class
                if (method.getName().equals("getClass")) {
                    continue;
                }
                
                String fieldName = method.getName().replace("get", "").toLowerCase();
                getters.put(fieldName, method);
            }
        }
    }
    
    private boolean shouldWriteField(String fieldName) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        // Exclude
        if (fieldNamesToExclude.contains(fieldName)) {
            return false;
        }
        
        Method method = getters.get(fieldName);
        Object value = method.invoke(object);
        
        // Don't write null objects
        if (value == null) {
            return false;
        }
        
        return true;
    }
    
    private void serializeFields() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Iterator<String> current = getters.keySet().iterator();
        Iterator<String> following = getters.keySet().iterator();
        
        if (current.hasNext()) {
            following.next();
        }
        
        while (current.hasNext()) {
            
            String fieldName = current.next();
            
            // Skip
            if (!shouldWriteField(fieldName)) {
                continue;
            }
            
            Method method = getters.get(fieldName);
            Object value = method.invoke(object);
            
            // Different field name for serialization
            if (fieldsWithProperties.containsKey(fieldName)) {
                fieldName = fieldsWithProperties.get(fieldName).name();
            }
            
            generator.writeObjectField(fieldName, value);
            
            if (current.hasNext()) {
                
                String nextFieldName = following.next();
                
                // Write separator only if the next field will be serialized
                if (shouldWriteField(nextFieldName)) {
                    generator.writeSeparator();
                }
            }
            
            generator.writeNewline();
        }
    }
    
    private String serializeObject() {
        
        String className = object.getClass().getSimpleName().toLowerCase();
        
        try {
            generator.writeObjectFieldStart(className);
        
            // Id
            Method method = getters.get(fieldNameForId.toLowerCase());
            generator.writeObject(method.invoke(object));
            
            generator.writeSeparator();
            generator.writeNewline();

            // Fields
            serializeFields();
        
            generator.writeObjectEnd();
        } catch (Exception exception) {
            System.out.println("BibTeXSerializer failed miserably.");
            exception.printStackTrace();
        }
        
        return generator.toString();
    }
    
    public static String serialize(Object object) throws NoIdException {
        
        BibTeXSerializer serializer = new BibTeXSerializer(object);
        return serializer.serializeObject();
    }
}