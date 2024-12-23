package cases.form.jte;

import java.util.List;

public class Form {
	private final String className;
	private final List<Field> fields;

	public Form(String className, List<Field> fields) {

		this.className = className;
		this.fields = fields;
	}

	public String className() {
		return className;
	}

	public List<Field> fields() {
		return fields;
	}
}
