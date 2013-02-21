/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.util.ArrayList;
import messageio.parsing.MessagesListener;
import messageio.parsing.MessagesParser;
import messageio.parsing.MessagesParser.InputsContext;
import messageio.parsing.MessagesParser.IoContext;
import messageio.parsing.MessagesParser.MessageContext;
import messageio.parsing.MessagesParser.OutputsContext;
import messageio.parsing.MessagesParser.PropertyContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author lucas.caballero
 */
public class ParseListener implements MessagesListener {
    
    public StackList<Message> messages = new StackList<Message>();

    @Override
    public void enterMessage(MessageContext ctx) {
        Message m = new Message();
        messages.add(m);
    }

    @Override
    public void exitMessage(MessageContext ctx) {
        Message m = messages.last();
        String text = ctx.ID().getText();
        m.name = text;
    }

    @Override
    public void enterProperty(PropertyContext ctx) {
        Property p = new Property();
        Message m = messages.last();
        IPropertyContainer c = m.getContainer();
        c.getProperties().add(p);
    }

    @Override
    public void exitProperty(PropertyContext ctx) {
        Property p = messages.last().getContainer().getProperties().last();
        p.type = ctx.TYPE().getText();
        p.name = ctx.ID().getText();
    }

    @Override
    public void enterIo(IoContext ctx) {
    }

    @Override
    public void exitIo(IoContext ctx) {
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
    public void enterInputs(InputsContext ctx) {
        messages.last().inputs = new Inputs();
    }

    @Override
    public void exitInputs(InputsContext ctx) {
    }

    @Override
    public void enterOutputs(OutputsContext ctx) {
        messages.last().outputs = new Outputs();
    }

    @Override
    public void exitOutputs(OutputsContext ctx) {
    }
}
