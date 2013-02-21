/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package messageio.stexamples;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;
import org.stringtemplate.v4.STGroupFile;

/**
 *
 * @author Lucas Caballero
 */
public class STExamples {
    
    public void example1() throws IOException {
        String s = "Hello, <name>!";
        ST hello = new ST(s);
        
        hello.add("name", "World");
        
        System.out.println(hello.render());
    }
    
    public void example2a() throws IOException {
        STGroup g = new STGroupDir("files/templates/");
        ST t = g.getInstanceOf("decl");
        
        t.add("type", "int");
        t.add("name", "x");
        t.add("value", 0);
        
        System.out.println(t.render());
    }
    
    public void example3() throws IOException {
        STGroup group = new STGroupFile("files/templates/test.stg");
        ST st = group.getInstanceOf("decl");
        
        st.add("type", "int");
        st.add("name", "x");
        st.add("value", 0);
        
        System.out.println(st.render());
    }
    
    public static class User {
        public int id;
        private String name;
        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public boolean isManager() {
            return true;
        }
        public String getName() {
            return name;
        }
        public String toString() {
            return id+"name";
        }
    }
    
    public void stackoverflow() throws IOException {
        STGroup g = new STGroupDir("files/templates/");
        ST st = g.getInstanceOf("report");
        
        st.add("analysis", "1");
        String result = st.render();
        System.out.println(result);
    }
    
    public void example4() {
        ST st = new ST("<b>$u.id$</b>: $u.name$", '$', '$');
        st.add("u", new User(999, "Lucas"));
        System.out.println(st.render());
    }
    
    public static String toText(String file) throws IOException {
        String s =
            Files.toString(
                new File("files/inputs/" + file), 
                Charset.defaultCharset());

        return s;
    }
}
