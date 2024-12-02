package xtend;

import xtend.com.example.Field;
import xtend.com.example.Form;
import xtend.com.example.generator.FormRecursiveGenerator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class XtendRecursiveForm {
	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}

	public static String execute() {
		List<Field> fields = Arrays.asList(
				new Field("username", "String", "\"defaultUser\""),
				new Field("age", "int", "30")
		);
		Form form = new Form("org.example", "UserForm", fields, List.of());
		FormRecursiveGenerator template = new FormRecursiveGenerator();
		return template.generate(form);
	}
}
