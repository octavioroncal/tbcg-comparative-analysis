package cases.form.mustache;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private final String className;
	private final List<Field> fields;
	private final List<Form> subforms;

	public Form(String className, List<Field> fields) {
		this.className = className;
		this.fields = fields;
		this.subforms = new ArrayList<>();
	}

	public void addField(Field field) {
		this.fields.add(field);
	}

	public void addSubform(Form subform) {
		this.subforms.add(subform);
	}

	public String getClassName() {
		return className;
	}

	public List<Field> getFields() {
		return fields;
	}

	public List<Form> getSubforms() {
		return subforms;
	}

	public String getClassNameCamelCase() {
		return Character.toLowerCase(className.charAt(0)) + className.substring(1);
	}
}
