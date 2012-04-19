package ohtu.refero.bibtex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class BibTeXSerializer {

    private Object object;
    private Field fieldForId;
    private Method getterForId;
    private List<String> fieldNamesToExclude;
    private Map<String, BibTeXProperty> fieldsWithProperties;
    private Map<String, Method> gettersForFieldsToSerialize;
    
    private BibTeXGenerator generator;
    
    private BibTeXSerializer(Object object) throws NoIdException {
        
        this.object = object;
        generator = new BibTeXGenerator();
        
        getFieldForId();
        getFieldNamesToExclude();
        getFieldsWithProperties();
        getGettersForFieldsToSerialize();
    }
    
    private void getFieldForId() throws NoIdException {
        
        fieldForId = null;
            
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXId.class) != null) {
                fieldForId = field;
            }
        }
        
        if (fieldForId == null) {
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
        fieldNamesToExclude.add(fieldForId.getName().toLowerCase());
    }
    
    private void getFieldsWithProperties() {
        
        fieldsWithProperties = new HashMap<String, BibTeXProperty>();
        
        for (Field field : Fields.getAllDeclaredFields(object.getClass())) {
            
            if (field.getAnnotation(BibTeXProperty.class) != null) {
                fieldsWithProperties.put(field.getName().toLowerCase(), field.getAnnotation(BibTeXProperty.class));
            }
        }
    }
   
    private boolean shouldWriteField(String fieldName, Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        // Exclude
        if (fieldNamesToExclude.contains(fieldName)) {
            return false;
        }
        
        Object value = method.invoke(object);
        
        // Don't write null objects
        if (value == null) {
            return false;
        }
        
        if (value instanceof String) {
            
            // Don't write empty strings
            if (((String) value).isEmpty()) {
                return false;
            }
        }
        
        return true;
    }
    
    private void getGettersForFieldsToSerialize() {
        
        gettersForFieldsToSerialize = new TreeMap<String, Method>();
        
        for (Method method : object.getClass().getMethods()) {
        
            if (Methods.isGetter(method)) {
                
                // Not interested in serializing the class
                if (method.getName().equals("getClass")) {
                    continue;
                }
                
                String fieldName = method.getName().replace("get", "").toLowerCase();
                
                // Getter for ID
                if (fieldName.equals(fieldForId.getName().toLowerCase())) {
                    getterForId = method;
                }
                
                try {
                    if (shouldWriteField(fieldName, method)) {
                        gettersForFieldsToSerialize.put(fieldName, method);
                    }
                } catch (Exception exception) {
                    System.out.println("BibTeXSerializer failed miserably.");
                    exception.printStackTrace();
                }
            }
        }
    }
    
    private String convertSpecialCharacters(String string) {
        
        string = string.replaceAll("Ä", "\\\\\"{A}");
        string = string.replaceAll("Ö", "\\\\\"{O}");
        string = string.replaceAll("Å", "\\\\AA");
        string = string.replaceAll("ä", "\\\\\"{a}");
        string = string.replaceAll("ö", "\\\\\"{o}");
        string = string.replaceAll("å", "\\\\aa");
        
        return string;
    }
    
    private void serializeFields() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        
        Iterator<String> current = gettersForFieldsToSerialize.keySet().iterator();
        
        while (current.hasNext()) {
            
            String fieldName = current.next();
            
            Method method = gettersForFieldsToSerialize.get(fieldName);
            Object value = method.invoke(object);
            
            // If string, convert special characters
            if (value instanceof String) {
                value = convertSpecialCharacters((String) value);
            }
            
            // Different field name for serialization
            if (fieldsWithProperties.containsKey(fieldName)) {
                fieldName = fieldsWithProperties.get(fieldName).name();
            }
            
            generator.writeObjectField(fieldName, value);
            
            if (current.hasNext()) {                
                generator.writeSeparator();
            }
            
            generator.writeNewline();
        }
    }
    
    private String serializeObject() {
        
        String className = object.getClass().getSimpleName().toLowerCase();
        
        try {
            generator.writeObjectFieldStart(className);
        
            // Id
            generator.writeObject(getterForId.invoke(object));
            
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