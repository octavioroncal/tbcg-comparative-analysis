package xtend;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class XtendForm {
	public static void main(String[] args) throws IOException {
		execute();
	}

	public static String  execute() {
		List<Field> fields = Arrays.asList(
				new Field("username", "String", "\"defaultUser\""),
				new Field("age", "int", "30")
		);
		Form form = new Form("UserForm", fields);
		FormTemplate template = new FormTemplate();
		return template.generate(form).toString();



	}
}
