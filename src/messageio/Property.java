/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.util.List;

/**
 *
 * @author Lucas Caballero
 */
public class Property {

    private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    private String type;

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Provides the name of the type but with the first letter capitalized
     * so the it can be used in a location where Pascal Casing is expected.
     * @return capitalized type name.
     */
    public String getMappedType() {
        String s = getType();
        if (s.length() > 0) {
            s = s.substring(0, 1).toUpperCase() + s.substring(1);
        }        
        if (s.endsWith("?")) {
            s = s.substring(0, s.length() - 1);
        }
        
        return s;
    }
    
    public String getPostgresType() {
        String s = getType();
        
        return s;
    }

    private List<String> attributes;

    /**
     * Get the value of attributes
     *
     * @return the value of attributes
     */
    public List<String> getAttributes() {
        return attributes;
    }

    /**
     * Set the value of attributes
     *
     * @param attributes new value of attributes
     */
    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }
}
