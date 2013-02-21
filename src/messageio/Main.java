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
import messageio.parsing.MessagesParser.IoContext;
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
        
        IoContext ctx = parser.io();
      
        String name = repeater.messages.last().name;
        System.out.println(name);
        
        System.out.printf("\t%s-inputs", name);
        System.out.println();
        
        for (Property p : repeater.messages.last().inputs.getProperties())
        {
            System.out.printf("\t\t%s : %s", p.name, p.type);
            System.out.println();
        }
        
        System.out.printf("\t%s-outputs", name);
        System.out.println();
        
        for (Property p : repeater.messages.last().outputs.getProperties())
        {
            System.out.printf("\t\t%s : %s", p.name, p.type);
            System.out.println();
        }
        
        example3(repeater.messages.get(0));
    }
    
    public static void example3(Message mgs) throws IOException {
        STGroup group = new STGroupFile("files/templates/ios-csharp.stg");
        ST st = group.getInstanceOf("messages");
        
        st.add("msg", mgs);
        
        System.out.println(st.render());
    }
    
    public static String cwd() throws IOException
    {
        String current = new java.io.File( "." ).getCanonicalPath();
        
        return current;
    }
    
    public static String toMessage(String file) throws IOException
    {
        String s =
            Files.toString(
                new File("files/inputs/" + file), 
                Charset.defaultCharset());

        return s;
    }

    private static void runExamples() throws IOException {
        new STExamples().example1();
        new STExamples().example2a();
        new STExamples().example3();
        new STExamples().example4();
        new STExamples().stackoverflow();
    }
}
