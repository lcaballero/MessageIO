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
public class Message {
    
    private List<Property> properties;

    /**
     * Get the value of Properties
     *
     * @return the value of Properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Set the value of Properties
     *
     * @param Properties new value of Properties
     */
    public void setProperties(List<Property> Properties) {
        this.properties = Properties;
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
