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
public class Service {

    private Inputs inputs;

    /**
     * Get the value of inputs
     *
     * @return the value of inputs
     */
    public Inputs getInputs() {
        return inputs;
    }

    /**
     * Set the value of inputs
     *
     * @param inputs new value of inputs
     */
    public void setInputs(Inputs inputs) {
        this.inputs = inputs;
    }
 
    private Outputs outputs;

    /**
     * Get the value of outputs
     *
     * @return the value of outputs
     */
    public Outputs getOutputs() {
        return outputs;
    }

    /**
     * Set the value of outputs
     *
     * @param outputs new value of outputs
     */
    public void setOutputs(Outputs outputs) {
        this.outputs = outputs;
    }
    
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
    
    private String version;

    /**
     * Get the value of version
     *
     * @return the value of version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the value of version
     *
     * @param version new value of version
     */
    public void setVersion(String version) {
        this.version = version;
    }

}
