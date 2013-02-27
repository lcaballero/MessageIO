/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import messageio.parsing.MessagesListener;
import messageio.parsing.MessagesParser;
import messageio.parsing.MessagesParser.AttributesContext;
import messageio.parsing.MessagesParser.ConstantParamContext;
import messageio.parsing.MessagesParser.FileContext;
import messageio.parsing.MessagesParser.MessageContext;
import messageio.parsing.MessagesParser.PairContext;
import messageio.parsing.MessagesParser.PropertyContext;
import messageio.parsing.MessagesParser.SetupContext;
import messageio.parsing.MessagesParser.VersionContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author lucas.caballero
 */
public class ParseListener implements MessagesListener {
    
    private MessageFile messageFile;

    /**
     * Get the value of messageFile
     *
     * @return the value of messageFile
     */
    public MessageFile getMessageFile() {
        return messageFile;
    }

    /**
     * Set the value of messageFile
     *
     * @param messageFile new value of messageFile
     */
    public void setMessageFile(MessageFile messageFile) {
        this.messageFile = messageFile;
    }

    @Override
    public void enterProperty(PropertyContext ctx) {
    }

    @Override
    public void exitProperty(PropertyContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
    }    

    @Override
    public void enterFile(FileContext ctx) {
        messageFile = new MessageFile();
    }

    @Override
    public void exitFile(FileContext ctx) {
    }

    @Override
    public void enterSetup(SetupContext ctx) {
    }

    @Override
    public void exitSetup(SetupContext ctx) {
    }

    @Override
    public void enterVersion(VersionContext ctx) {
    }

    @Override
    public void exitVersion(VersionContext ctx) {
        String ver = ctx.Triple().getText();
        messageFile.setVersion(ver);
    }

    @Override
    public void enterConstantParam(ConstantParamContext ctx) {
    }

    @Override
    public void exitConstantParam(ConstantParamContext ctx) {
    }

    @Override
    public void enterPair(PairContext ctx) {
    }

    @Override
    public void exitPair(PairContext ctx) {
    }

    @Override
    public void enterAttributes(AttributesContext ctx) {
    }

    @Override
    public void exitAttributes(AttributesContext ctx) {
    }

    @Override
    public void enterMessage(MessageContext ctx) {       
        messageFile.getMessages().add(new Message());
    }

    @Override
    public void exitMessage(MessageContext ctx) {
        Message m = messageFile.lastMessage();
        
        List<PropertyContext> props = ctx.property();
        
        if (props != null && props.size() > 0) {
            
            List<Property> list = new ArrayList<Property>(); 
            m.setProperties(list);            
            
            for (PropertyContext p : props) {
                
                Property newProp = new Property();
                list.add(newProp);
                
                newProp.setName(p.Id().getText());
                newProp.setType(p.Type().getText());
                
                List<AttributesContext> atts = p.attributes();
                
                if (atts != null && atts.size() > 0) {                    
                    List<String> newAtts = new ArrayList<String>();
                    newProp.setAttributes(newAtts);
                    
                    for (AttributesContext a : atts) {
                        newAtts.add(a.Id().getText());
                    }                  
                }                
            }
        }
        
        List<AttributesContext> atts = ctx.attributes();
        
        if (atts != null && atts.size() > 0) {
            
            List<String> newAtts = new ArrayList<String>();
            m.setAttributes(newAtts);
            
            for (AttributesContext a : atts) {
                newAtts.add(a.Id().getText());
            }
        }
    }
}
