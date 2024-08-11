package mustache;

public class Field {
	private final String name;
	private final String type;
	private final String defaultValue;

	public Field(String name, String type, String defaultValue) {
		this.name = name;
		this.type = type;
		this.defaultValue = defaultValue;
	}

	public String name() {
		return name;
	}

	public String type() {
		return type;
	}

	public String defaultValue() {
		return defaultValue;
	}
	public String getNameCapitalized() {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}
}

