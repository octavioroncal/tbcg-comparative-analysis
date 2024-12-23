package cases.form.xtend;

import cases.form.xtend.com.example.Form;
import cases.form.xtend.com.example.Field;
import cases.form.xtend.com.example.generator.FormRecursiveGenerator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class XtendRecursionForm {
	private static final Random random = new Random();

	public static void main(String[] args) throws IOException {
		System.out.println(execute(3));
	}

	public static String execute(int maxLevel) {
		List<Field> fields = Arrays.asList(
				new Field("String", "username", "defaultUser"),
				new Field("int", "age", random.nextInt() + "")
		);
		List<Form> subForms = new ArrayList<>();
		for (int i = 0; i < maxLevel; i++) subForms.add(subForm(i, 1, maxLevel));
		Form form = new Form("org.example", "UserForm", fields, subForms);
		FormRecursiveGenerator template = new FormRecursiveGenerator();
		return template.generate(form);
	}

	private static Form subForm(int index, int level, int maxLevel) {
		String name = "Form" + level + "_" + index;
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("String", "title", "Default Title " + level));
		fields.add(new Field("int", "age", random.nextInt() + ""));
		List<Form> subforms = new ArrayList<>();
		if (level < maxLevel) {
			for (int i = 0; i < (maxLevel - level); i++) {
				subforms.add(subForm(i, level + 1, maxLevel));
			}
		}
		return new Form(null, name, fields, subforms);
	}
}
