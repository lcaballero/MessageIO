// Generated from Messages.g4 by ANTLR 4.0

package messageio.parsing;

import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface MessagesListener extends ParseTreeListener {
	void enterMessage(MessagesParser.MessageContext ctx);
	void exitMessage(MessagesParser.MessageContext ctx);

	void enterProperty(MessagesParser.PropertyContext ctx);
	void exitProperty(MessagesParser.PropertyContext ctx);

	void enterIo(MessagesParser.IoContext ctx);
	void exitIo(MessagesParser.IoContext ctx);
}