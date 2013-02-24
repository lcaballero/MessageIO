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
public class Outputs implements IPropertyContainer {

    private List<Property> properties;

    /**
     * Get the value of properties
     *
     * @return the value of properties
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Set the value of properties
     *
     * @param properties new value of properties
     */
    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

}
