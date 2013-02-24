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
