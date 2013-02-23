/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio;

import com.google.common.io.Files;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.Charset;
import messageio.parsing.MessagesLexer;
import messageio.parsing.MessagesParser;
import messageio.parsing.MessagesParser.FileContext;
import messageio.stexamples.STExamples;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 *
 * @author Lucas Caballero
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        parse();     
    }
    
    public static void parse() throws IOException {
        // TODO code application logic here

        String simple = toMessage("simple-message.ios");
        StringReader in = new StringReader(simple);
        
        ANTLRInputStream input = new ANTLRInputStream(in);
        
        MessagesLexer lexer = new MessagesLexer(input);        
        CommonTokenStream tokens = new CommonTokenStream(lexer);        
        MessagesParser parser = new MessagesParser(tokens);
        
        ParseListener repeater = new ParseListener();
        parser.addParseListener(repeater);
        
        FileContext ctx = parser.file();
      
        String name = repeater.getService().getName();
        System.out.println(name);
        
        System.out.printf("\t%s-inputs", name);
        System.out.println();
        
        for (Property p : repeater.getService().getInputs().getProperties())
        {
            System.out.printf("\t\t%s : %s", p.getName(), p.getType());
            System.out.println();
        }
        
        System.out.printf("\t%s-outputs", name);
        System.out.println();
        
        for (Property p : repeater.getService().getOutputs().getProperties())
        {
            System.out.printf("\t\t%s : %s", p.getName(), p.getType());
            System.out.println();
        }
    }
   
    public static String toMessage(String file) throws IOException
    {
        String s =
            Files.toString(
                new File("files/sample-files/" + file), 
                Charset.defaultCharset());

        return s;
    }
}
