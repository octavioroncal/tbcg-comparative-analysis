package xtend;

import java.util.List;

public class Form {
	private String className;
	private List<Field> fields;

	public Form(String className, List<Field> fields) {
		this.className = className;
		this.fields = fields;
	}

	public String getClassName() {
		return className;
	}

	public List<Field> getFields() {
		return fields;
	}
}
