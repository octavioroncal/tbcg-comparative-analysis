package jet;

import java.util.List;

public class Form {
	private String title;
	private List<String> fields;

	public Form(String title, List<String> fields) {
		this.title = title;
		this.fields = fields;
	}

	// Getters y setters
	public String getTitle() {
		return title;
	}

	public List<String> getFields() {
		return fields;
	}
}
