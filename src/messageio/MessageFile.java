/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas Caballero
 */
public class MessageFile {
    
    private String version;

    /**
     * Get the value of Version
     *
     * @return the value of Version
     */
    public String getVersion() {
        return version;
    }

    /**
     * Set the value of Version
     *
     * @param version new value of Version
     */
    public void setVersion(String version) {
        this.version = version;
    }

   private List<Message> messages = new ArrayList<Message>();
   
   /**
    * Get the value of service
    *
    * @return the value of service
    */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     * Gets the last message in the file.
     * @return the last Message.
     */
    public Message lastMessage() {
        return messages.get(messages.size() - 1);
    }
}
