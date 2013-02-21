/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

/**
 *
 * @author Lucas Caballero
 */
public class Outputs implements IPropertyContainer {
    private StackList<Property> properties = new StackList<Property>();    
    public StackList<Property> getProperties() {
        return properties;
    }
}
