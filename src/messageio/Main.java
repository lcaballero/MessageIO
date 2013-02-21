/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import java.io.IOException;
import java.io.StringReader;
import messageio.parsing.MessagesLexer;
import messageio.parsing.MessagesParser;
import messageio.parsing.MessagesParser.IoContext;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

/**
 *
 * @author Lucas Caballero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        System.out.println("Here");
        StringReader in = new StringReader("message SqlIO { string Name; int Id; }");
        
        ANTLRInputStream input = new ANTLRInputStream(in);
        
        MessagesLexer lexer = new MessagesLexer(input);
        
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        MessagesParser parser = new MessagesParser(tokens);
        
        IoContext ctx = parser.io();
        
        System.out.println(ctx.toStringTree(parser));
    }
}
