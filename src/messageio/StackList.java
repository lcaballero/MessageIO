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
public class StackList<E> extends ArrayList<E> {
    
    public E last() {
        return this.get(this.size() - 1);
    }
}
