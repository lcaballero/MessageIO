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
import messageio.parsing.MessagesParser.InputsContext;
import messageio.parsing.MessagesParser.OutputsContext;
import messageio.parsing.MessagesParser.PairContext;
import messageio.parsing.MessagesParser.PropertyContext;
import messageio.parsing.MessagesParser.ServiceContext;
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
    
    private Service service = new Service();

    /**
     * Get the value of service
     *
     * @return the value of service
     */
    public Service getService() {
        return service;
    }

    @Override
    public void enterService(ServiceContext ctx) {
    }

    @Override
    public void exitService(ServiceContext ctx) {
        String text = ctx.Id().getText();
        service.setName(text);
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
    public void enterInputs(InputsContext ctx) {
        
    }

    @Override
    public void exitInputs(InputsContext ctx) {
        List<PropertyContext> list = ctx.property();
        
        Inputs ins = new Inputs();
        service.setInputs(ins);
        
        if (list.size() > 0) {
            ins.setProperties(new ArrayList<Property>());            
        }

        for (PropertyContext c : list) {
            String type = c.Type().getText();
            String name = c.Id().getText();

            Property p = new Property();
            p.setType(type);
            p.setName(name);
            ins.getProperties().add(p);
        }
    }

    @Override
    public void enterOutputs(OutputsContext ctx) {
    }

    @Override
    public void exitOutputs(OutputsContext ctx) {
        List<PropertyContext> list = ctx.property();
        
        Outputs ins = new Outputs();
        service.setOutputs(ins);        
        
        if (list.size() > 0) {
            ins.setProperties(new ArrayList<Property>());            
        }

        for (PropertyContext c : list) {
            String type = c.Type().getText();
            String name = c.Id().getText();
            
            Property p = new Property();
            p.setType(type);
            p.setName(name);
            ins.getProperties().add(p);
        }
    }

    @Override
    public void enterFile(FileContext ctx) {
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
        service.setVersion(ver);
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
}
