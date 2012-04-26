package ohtu.refero.bibtex;

import java.util.Collection;
import java.util.Iterator;

public class BibTeXGenerator {
    
    private StringBuffer buffer;
    
    public BibTeXGenerator() {
        buffer = new StringBuffer();
    }
    
    public void writeObjectStart() {   
        buffer.append("{");
    }
    
    public void writeObjectEnd() {
        buffer.append("}");
    }
    
    public void writeIndentation() {
        buffer.append("  ");
    }
    
    public void writeSeparator() {
        buffer.append(",");
    }
    
    public void writeNewline() {
        buffer.append("\n");
    }
    
    public void writeObjectFieldStart(String name) {
        
        buffer.append("@")
              .append(name);
        
        writeObjectStart();
    }
    
    public void writeCollection(Collection collection) {
        
        Iterator iterator = collection.iterator();
            
        while (iterator.hasNext()) {
            buffer.append(iterator.next());
                
            if (iterator.hasNext()) {
                writeSeparator();
                buffer.append(" ");
            }
        }            
    }
    
    public void writeObject(Object object) {
        
        if (object instanceof Collection) {
            Collection collection = (Collection) object;
            writeCollection(collection);
            return;
        }
        
        buffer.append(object);
    }
    
    public void writeObjectField(String name, Object object) {
        
        writeIndentation();
        
        buffer.append(name)
              .append(" ")
              .append("=")
              .append(" ");
        
        writeObjectStart();
        writeObject(object);
        writeObjectEnd();
    }
    
    @Override
    public String toString() {
        return buffer.toString();
    }
}