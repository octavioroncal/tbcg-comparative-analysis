package cases.form.xtend;

import cases.form.xtend.com.example.Form;
import cases.form.xtend.com.example.Field;
import cases.form.xtend.com.example.generator.FormGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XtendForm {
	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}

	public static String  execute() {
		List<Field> fields = Arrays.asList(
				new Field("username", "String", "\"defaultUser\""),
				new Field("age", "int", "30")
		);
		Form form = new Form("org.example", "UserForm", fields, new ArrayList<>());
		FormGenerator template = new FormGenerator();
		return template.generate(form);
	}
}
