// Generated from IsiLang.g4 by ANTLR 4.7.2
package parser;

	import datastructures.Symbol;
	import datastructures.Variable;
	import datastructures.SymbolTable;
	import exceptions.SemanticException;
	import ast.Program;
	import ast.AbstractCommand;
	import ast.CommandLeitura;
	import ast.CommandEscrita;
	import ast.CommandAtribuicao;
	import ast.CommandDecisao;
	import ast.CommandWhile;
	import ast.CommandFor;
	import ast.CommandAtribuicaoFor;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, TEXTO=19, AP=20, FP=21, PT=22, SC=23, ATTR=24, VIR=25, ACH=26, 
		FCH=27, OPREL=28, ID=29, NUMBER=30, WS=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "TEXTO", "AP", "FP", "PT", "SC", "ATTR", "VIR", "ACH", "FCH", 
			"OPREL", "ID", "NUMBER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "'numero'", "'texto'", 
			"'leia'", "'escreva'", "'escrevaLn'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'faca'", "'para'", "'+'", "'-'", "'*'", "'/'", null, "'('", "')'", "'.'", 
			"';'", "':='", "','", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "TEXTO", "AP", "FP", "PT", 
			"SC", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		private int _tipo;
		private String _varName;
		private String _varValue;
		private SymbolTable symbolTable = new SymbolTable();
		private Symbol symbol;
		private Program program = new Program();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		
		private int leftDT;
		private int rightDT;

		private CommandAtribuicaoFor _statement1;
		private String _statement2;
		private CommandAtribuicaoFor _statement3;
		
		private String _readID;
		private String _writeID;
		private boolean _writeLn;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		
		public void verificaIDDeclarado(String id) {
			if (!symbolTable.exists(id)) {
				throw new SemanticException("Symbol " + id + " not declared");
			}
		}

		public void setVariableUsage(String id) {
			Symbol variable = symbolTable.get(id);
			variable.setUsed(true);
		}
		
		public void checkVariableHasValue(String id) {
			Variable variable = (Variable) symbolTable.get(id);
			if (variable.getValue() == null) {
				throw new SemanticException("Variable " + id + " does not have value.");
			}
		}
		
		public String generateCode(int language) {
			return program.generateTarget(language);
		}

		public void checkUnusedVariables() {
			ArrayList<Symbol> variableList = symbolTable.getAll();
			for (Symbol symbol : variableList) {
				if (!symbol.isUsed()) {
					System.out.println("Warn: declared variable " + symbol.getName() + " is not being used.");
				}
			}
		}


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00e7\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\7\24\u00ab\n\24\f\24\16\24\u00ae\13\24\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u00cc"+
		"\n\35\3\36\5\36\u00cf\n\36\3\36\7\36\u00d2\n\36\f\36\16\36\u00d5\13\36"+
		"\3\37\6\37\u00d8\n\37\r\37\16\37\u00d9\3\37\3\37\6\37\u00de\n\37\r\37"+
		"\16\37\u00df\5\37\u00e2\n\37\3 \3 \3 \3 \2\2!\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!\3\2\b\3\2$$\4\2>>@@\4"+
		"\2C\\c|\5\2\62;C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00ef\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\3A\3\2\2\2\5J\3\2\2\2\7R\3\2\2\2\tZ\3\2\2\2\13a\3\2\2\2"+
		"\rg\3\2\2\2\17l\3\2\2\2\21t\3\2\2\2\23~\3\2\2\2\25\u0081\3\2\2\2\27\u0087"+
		"\3\2\2\2\31\u008d\3\2\2\2\33\u0096\3\2\2\2\35\u009b\3\2\2\2\37\u00a0\3"+
		"\2\2\2!\u00a2\3\2\2\2#\u00a4\3\2\2\2%\u00a6\3\2\2\2\'\u00a8\3\2\2\2)\u00b1"+
		"\3\2\2\2+\u00b3\3\2\2\2-\u00b5\3\2\2\2/\u00b7\3\2\2\2\61\u00b9\3\2\2\2"+
		"\63\u00bc\3\2\2\2\65\u00be\3\2\2\2\67\u00c0\3\2\2\29\u00cb\3\2\2\2;\u00ce"+
		"\3\2\2\2=\u00d7\3\2\2\2?\u00e3\3\2\2\2AB\7r\2\2BC\7t\2\2CD\7q\2\2DE\7"+
		"i\2\2EF\7t\2\2FG\7c\2\2GH\7o\2\2HI\7c\2\2I\4\3\2\2\2JK\7h\2\2KL\7k\2\2"+
		"LM\7o\2\2MN\7r\2\2NO\7t\2\2OP\7q\2\2PQ\7i\2\2Q\6\3\2\2\2RS\7f\2\2ST\7"+
		"g\2\2TU\7e\2\2UV\7n\2\2VW\7c\2\2WX\7t\2\2XY\7g\2\2Y\b\3\2\2\2Z[\7p\2\2"+
		"[\\\7w\2\2\\]\7o\2\2]^\7g\2\2^_\7t\2\2_`\7q\2\2`\n\3\2\2\2ab\7v\2\2bc"+
		"\7g\2\2cd\7z\2\2de\7v\2\2ef\7q\2\2f\f\3\2\2\2gh\7n\2\2hi\7g\2\2ij\7k\2"+
		"\2jk\7c\2\2k\16\3\2\2\2lm\7g\2\2mn\7u\2\2no\7e\2\2op\7t\2\2pq\7g\2\2q"+
		"r\7x\2\2rs\7c\2\2s\20\3\2\2\2tu\7g\2\2uv\7u\2\2vw\7e\2\2wx\7t\2\2xy\7"+
		"g\2\2yz\7x\2\2z{\7c\2\2{|\7N\2\2|}\7p\2\2}\22\3\2\2\2~\177\7u\2\2\177"+
		"\u0080\7g\2\2\u0080\24\3\2\2\2\u0081\u0082\7g\2\2\u0082\u0083\7p\2\2\u0083"+
		"\u0084\7v\2\2\u0084\u0085\7c\2\2\u0085\u0086\7q\2\2\u0086\26\3\2\2\2\u0087"+
		"\u0088\7u\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2\u008a\u008b\7c\2\2"+
		"\u008b\u008c\7q\2\2\u008c\30\3\2\2\2\u008d\u008e\7g\2\2\u008e\u008f\7"+
		"p\2\2\u008f\u0090\7s\2\2\u0090\u0091\7w\2\2\u0091\u0092\7c\2\2\u0092\u0093"+
		"\7p\2\2\u0093\u0094\7v\2\2\u0094\u0095\7q\2\2\u0095\32\3\2\2\2\u0096\u0097"+
		"\7h\2\2\u0097\u0098\7c\2\2\u0098\u0099\7e\2\2\u0099\u009a\7c\2\2\u009a"+
		"\34\3\2\2\2\u009b\u009c\7r\2\2\u009c\u009d\7c\2\2\u009d\u009e\7t\2\2\u009e"+
		"\u009f\7c\2\2\u009f\36\3\2\2\2\u00a0\u00a1\7-\2\2\u00a1 \3\2\2\2\u00a2"+
		"\u00a3\7/\2\2\u00a3\"\3\2\2\2\u00a4\u00a5\7,\2\2\u00a5$\3\2\2\2\u00a6"+
		"\u00a7\7\61\2\2\u00a7&\3\2\2\2\u00a8\u00ac\7$\2\2\u00a9\u00ab\n\2\2\2"+
		"\u00aa\u00a9\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad"+
		"\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b0\7$\2\2\u00b0"+
		"(\3\2\2\2\u00b1\u00b2\7*\2\2\u00b2*\3\2\2\2\u00b3\u00b4\7+\2\2\u00b4,"+
		"\3\2\2\2\u00b5\u00b6\7\60\2\2\u00b6.\3\2\2\2\u00b7\u00b8\7=\2\2\u00b8"+
		"\60\3\2\2\2\u00b9\u00ba\7<\2\2\u00ba\u00bb\7?\2\2\u00bb\62\3\2\2\2\u00bc"+
		"\u00bd\7.\2\2\u00bd\64\3\2\2\2\u00be\u00bf\7}\2\2\u00bf\66\3\2\2\2\u00c0"+
		"\u00c1\7\177\2\2\u00c18\3\2\2\2\u00c2\u00cc\t\3\2\2\u00c3\u00c4\7@\2\2"+
		"\u00c4\u00cc\7?\2\2\u00c5\u00c6\7>\2\2\u00c6\u00cc\7?\2\2\u00c7\u00c8"+
		"\7?\2\2\u00c8\u00cc\7?\2\2\u00c9\u00ca\7#\2\2\u00ca\u00cc\7?\2\2\u00cb"+
		"\u00c2\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb\u00c5\3\2\2\2\u00cb\u00c7\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cc:\3\2\2\2\u00cd\u00cf\t\4\2\2\u00ce\u00cd"+
		"\3\2\2\2\u00cf\u00d3\3\2\2\2\u00d0\u00d2\t\5\2\2\u00d1\u00d0\3\2\2\2\u00d2"+
		"\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4<\3\2\2\2"+
		"\u00d5\u00d3\3\2\2\2\u00d6\u00d8\t\6\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00e1\3\2\2\2\u00db"+
		"\u00dd\7.\2\2\u00dc\u00de\t\6\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1"+
		"\u00db\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2>\3\2\2\2\u00e3\u00e4\t\7\2\2"+
		"\u00e4\u00e5\3\2\2\2\u00e5\u00e6\b \2\2\u00e6@\3\2\2\2\13\2\u00ac\u00cb"+
		"\u00ce\u00d1\u00d3\u00d9\u00df\u00e1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}