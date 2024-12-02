package xtend;

import xtend.com.example.Field;
import xtend.com.example.Form;
import xtend.com.example.generator.FormRecursiveGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XtendRecursionForm {
	public static void main(String[] args) throws IOException {
		System.out.println(execute(2));
	}

	public static String execute(int subForms) {
		List<Field> fields = Arrays.asList(
				new Field("username", "String", "\"defaultUser\""),
				new Field("age", "int", "30")
		);
		Form form = new Form("org.example", "UserForm", fields, subForms(1, subForms));
		FormRecursiveGenerator template = new FormRecursiveGenerator();
		return template.generate(form);
	}

	private static List<Form> subForms(int level, int maxLevel) {
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("String", "title", "Default Title " + level));
		fields.add(new Field("int", "age", level + ""));
		return List.of(new Form(null, "Form" + level, fields, level < maxLevel ? subForms(level + 1, maxLevel) : List.of()));
	}
}
