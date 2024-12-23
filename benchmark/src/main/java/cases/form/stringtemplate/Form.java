package cases.form.stringtemplate;

import java.util.List;

public class Form {
	private final String className;
	private final List<Field> fields;

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

	public static class Field {
		private final String name;
		private final String type;
		private final String defaultValue;

		public Field(String name, String type, String defaultValue) {
			this.name = name;
			this.type = type;
			this.defaultValue = defaultValue;
		}

		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}

		public String getDefaultValue() {
			return defaultValue;
		}
	}

}
