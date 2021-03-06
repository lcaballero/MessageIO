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

        String simple = toMessage("sample-files/readme-example.mio");
        StringReader in = new StringReader(simple);
        
        ANTLRInputStream input = new ANTLRInputStream(in);
        
        MessagesLexer lexer = new MessagesLexer(input);        
        CommonTokenStream tokens = new CommonTokenStream(lexer);        
        MessagesParser parser = new MessagesParser(tokens);
        
        ParseListener repeater = new ParseListener();
        parser.addParseListener(repeater);
        
        FileContext ctx = parser.file();
      
        MessageFile file = repeater.getMessageFile();

        System.out.println(toServiceFiles(file));
        System.out.println(toSql(file));
    }
    
    public static String toSql(MessageFile f) {
        STGroup g = new STGroupFile("files/templates/sql-output-postgres.stg");
        ST t = g.getInstanceOf("messageFile");
        t.add("file", f);
        
        return t.render();
    }
    
    public static String toServiceFiles(MessageFile f) {
        STGroup g = new STGroupFile("files/templates/service-idatamapping.stg");
        ST t = g.getInstanceOf("messageFile");
        t.add("file", f);
        
        return t.render();
    }
   
    public static String toMessage(String file) throws IOException
    {
        String s =
            Files.toString(
                new File("files/" + file), 
                Charset.defaultCharset());

        return s;
    }
}
