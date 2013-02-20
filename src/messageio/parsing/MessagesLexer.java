// Generated from Messages.g4 by ANTLR 4.0

package messageio.parsing;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MessagesLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, TYPE=5, ID=6, WS=7;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'{'", "'message'", "'}'", "';'", "TYPE", "ID", "WS"
	};
	public static final String[] ruleNames = {
		"T__3", "T__2", "T__1", "T__0", "TYPE", "ID", "WS"
	};


	public MessagesLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Messages.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 6: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\t<\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6/\n\6\3\7\6\7\62\n\7\r"+
		"\7\16\7\63\3\b\6\b\67\n\b\r\b\16\b8\3\b\3\b\2\t\3\3\1\5\4\1\7\5\1\t\6"+
		"\1\13\7\1\r\b\1\17\t\2\3\2\4\5C\\aac|\5\13\f\17\17\"\"?\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\3\21\3\2\2\2\5\23\3\2\2\2\7\33\3\2\2\2\t\35\3\2\2\2\13.\3\2\2\2\r\61"+
		"\3\2\2\2\17\66\3\2\2\2\21\22\7}\2\2\22\4\3\2\2\2\23\24\7o\2\2\24\25\7"+
		"g\2\2\25\26\7u\2\2\26\27\7u\2\2\27\30\7c\2\2\30\31\7i\2\2\31\32\7g\2\2"+
		"\32\6\3\2\2\2\33\34\7\177\2\2\34\b\3\2\2\2\35\36\7=\2\2\36\n\3\2\2\2\37"+
		" \7k\2\2 !\7p\2\2!/\7v\2\2\"#\7f\2\2#$\7q\2\2$%\7w\2\2%&\7d\2\2&\'\7n"+
		"\2\2\'/\7g\2\2()\7u\2\2)*\7v\2\2*+\7t\2\2+,\7k\2\2,-\7p\2\2-/\7i\2\2."+
		"\37\3\2\2\2.\"\3\2\2\2.(\3\2\2\2/\f\3\2\2\2\60\62\t\2\2\2\61\60\3\2\2"+
		"\2\62\63\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\16\3\2\2\2\65\67\t\3\2"+
		"\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29:\3\2\2\2:;\b\b\2\2"+
		";\20\3\2\2\2\6\2.\638";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}