package myCompiler;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import exceptions.SemanticException;
import parser.IsiLangLexer;
import parser.IsiLangParser;

public class Compiler {
	public static String compile(String filePath, int language) {
		String responseStr = "";
		try {
			IsiLangLexer lexer;
			IsiLangParser parser;
			
			lexer = new IsiLangLexer(CharStreams.fromFileName(filePath));
			CommonTokenStream tokenStream = new CommonTokenStream(lexer);
			
			parser = new IsiLangParser(tokenStream);
			
			parser.prog();
			
			System.out.println("Compilation Successful!");
			
			responseStr =  parser.generateCode(language);
			
		} catch (SemanticException ex) {
//			System.err.println("Semantic Error - " + ex.getMessage());
			responseStr = "Semantic Error - " + ex.getMessage();
		} catch (Exception ex) {
//			System.err.println("ERROR " + ex.getMessage());
			responseStr = "Error - " + ex.getMessage();
		}
		
		return responseStr;
		
	}
}
