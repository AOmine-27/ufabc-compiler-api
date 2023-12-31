package ast;

public class CommandAtribuicao extends AbstractCommand {

	private String ID;
	private String expression;
	
	public CommandAtribuicao(String id, String expr) {
		this.ID = id;
		this.expression = expr;
	}
	
	public int getExpressionType() {
		String regex = "[0-9]+|[0-9]+[,][0-9]+";
		if (expression.matches(regex)) {
			return 0;
		} else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		return "CommandAtribuicao [ID=" + ID + ", expression=" + expression + "]";
	}
	
	@Override
	public String generateJavaCode() {
		if (getExpressionType() == 0) {
			if (expression.matches("[0-9]+")) {
				return ID + " = (double)" + expression.replace(",", ".") + ";";
			}
			return ID + " = " + expression.replace(",", ".") + ";";			
		} else {
			return ID + " = " + expression + ";";	
		}
	}
	
	@Override
	public String generateJavascriptCode() {
		if (getExpressionType() == 0) {
			return ID + " = " + expression.replace(",", ".");			
		} else {
			return ID + " = " + expression;	
		}
	}

}
