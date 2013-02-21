/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.util.ArrayList;

/**
 *
 * @author Lucas Caballero
 */
public class Message {
    public String name = "";
    public Inputs inputs = null;
    public Outputs outputs = null;
    
    public IPropertyContainer getContainer() {
        return 
        isAddingInputs()
            ? (IPropertyContainer)inputs
            :
        isAddingOutputs()
            ? (IPropertyContainer)outputs
            : null;
    }
    
    /**
     * @return true if there is a container for inputs but before there is an
     * outputs object container.
     */
    public boolean isAddingInputs() {
        return inputs != null && outputs == null;
    }
    
    /**
     * @return true if there is a container for inputs but also a container
     * for outputs.
     */
    public boolean isAddingOutputs() {
        return inputs != null && outputs != null;
    }
}
