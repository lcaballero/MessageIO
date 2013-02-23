/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

/**
 *
 * @author Lucas Caballero
 */
public class Inputs implements IPropertyContainer {

    private StackList<Property> properties;

    /**
     * Get the value of properties
     *
     * @return the value of properties
     */
    public StackList<Property> getProperties() {
        return properties;
    }

    /**
     * Set the value of properties
     *
     * @param properties new value of properties
     */
    public void setProperties(StackList<Property> properties) {
        this.properties = properties;
    }
}
