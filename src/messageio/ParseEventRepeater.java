/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import messageio.parsing.MessagesListener;
import messageio.parsing.MessagesParser;
import messageio.parsing.MessagesParser.IoContext;
import messageio.parsing.MessagesParser.MessageContext;
import messageio.parsing.MessagesParser.PropertyContext;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author lucas.caballero
 */
public class ParseEventRepeater implements MessagesListener {

    @Override
    public void enterMessage(MessageContext ctx) {
        System.out.println("enterMessage");
    }

    @Override
    public void exitMessage(MessageContext ctx) {
        System.out.println("exit");
    }

    @Override
    public void enterProperty(PropertyContext ctx) {
        System.out.println("enterProperty");
    }

    @Override
    public void exitProperty(PropertyContext ctx) {
        System.out.println("enterProperty");
    }

    @Override
    public void enterIo(IoContext ctx) {
        System.out.println("enterIo");
    }

    @Override
    public void exitIo(IoContext ctx) {
        System.out.println("enterIo");
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
        System.out.println("visitTerminal");
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
        System.out.println("visitErrorNode");
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
        System.out.println("enterEveryRule");
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
        System.out.println("exitEveryRule");
    }    
}
