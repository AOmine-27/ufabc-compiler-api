package datastructures;

public class Variable extends Symbol {
	public static final int NUMBER = 0;
	public static final int TEXT = 1;
	
	private int type;
	private String value = null;
	
	public Variable(String name, int type, String value) {
		super(name);
		this.type = type;
		this.value = value;
	}
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Variable [name = " + name + ", type = " + type + ", value = " + value + "]";
	}

	@Override
	public String generateJavaCode() {
		String str;
		
		if (type == NUMBER) {
			str = "Double ";
		} else {
			str = "String ";
		}
		
		
		return str + " " + super.name + ";";
	}
	
	@Override
	public String generateJavascriptCode() {
		
		return "let " + super.name;
	}
}
