package ast;

import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

import datastructures.Symbol;
import datastructures.SymbolTable;

public class Program {
	private SymbolTable varTable;
	private ArrayList<AbstractCommand> comandos;
	private String programName;
	
//	Language 1 for Java and 2 for Javascript
	public String generateTarget(int language) {
		String str;
		if (language == 1) {
			str = generateJavaCode();		
		} else {
			str = generateJavascriptCode();
		}
		
//		try {
//			
//			FileWriter fr = new FileWriter(new File("./output/MainClass.java"));
//			fr.write(str.toString());
//			fr.close();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		return str.toString();
	}

	private String generateJavaCode() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class MainClass {\n");
		str.append("public static void main(String args[]){ \n");
		str.append("Scanner _key = new Scanner (System.in);\n");
		for (Symbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavaCode() + "\n");
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavaCode() + "\n");
		}
		str.append("}\n");
		str.append("}\n");	
		
		return str.toString();
	}
	
	
	private String generateJavascriptCode() {
		StringBuilder str = new StringBuilder();
		str.append("const prompt = require(\"prompt-sync\")({ sigint: true });\n\n");
		for (Symbol symbol: varTable.getAll()) {
			str.append(symbol.generateJavascriptCode() + "\n");
		}
		for (AbstractCommand command: comandos) {
			str.append(command.generateJavascriptCode() + "\n");
		}
		return str.toString();
	}
	
	public SymbolTable getVarTable() {
		return varTable;
	}

	public void setVarTable(SymbolTable varTable) {
		this.varTable = varTable;
	}

	public ArrayList<AbstractCommand> getComandos() {
		return comandos;
	}

	public void setComandos(ArrayList<AbstractCommand> comandos) {
		this.comandos = comandos;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	
}
