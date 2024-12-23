package cases.form.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MustacheRecursionForm {

	public static void main(String[] args) throws IOException {
		System.out.println(execute(10));
	}

	public static String execute(int subForms) throws IOException {
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("templates/pojo/mustache/mustache-java-recursion-formulary.mustache");
		Map<String, Object> context = form(subForms);
		context.put("isString", new FieldTypePredicate("String"));
		context.put("isInt", new FieldTypePredicate("int"));
		StringWriter writer = new StringWriter();
		mustache.execute(writer, context).flush();
		return writer.toString();
	}


	private static Map<String, Object> form(int subFormsSize) {
		Map<String, Object> root = new HashMap<>();
		root.put("packageName", "com.example.forms");
		root.put("className", "UserForm");
		root.put("classNameLowerCase", lowerCase("UserForm"));
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title"));
		fields.add(field("int", "age", 30));
		root.put("fields", fields);
		List<Map<String, Object>> subForms = new ArrayList<>();
		subForms.add(subForm(1, subFormsSize));
		root.put("subforms", subForms);
		return root;
	}

	private static Map<String, Object> subForm(int level, int maxLevel) {
		Map<String, Object> subForm = new HashMap<>();
		subForm.put("className", "Form" + level);
		subForm.put("classNameLowerCase", lowerCase("Form" + level));
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title"));
		fields.add(field("int", "age", 30));
		subForm.put("fields", fields);
		if (level < maxLevel) {
			Map<String, Object> value = subForm(level + 1, maxLevel);
			List<Map<String, Object>> subForms = new ArrayList<>();
			subForms.add(value);
			subForm.put("subforms", subForms);
		}
		return subForm;
	}

	private static Map<String, Object> field(String type, String name, Object defaultValue) {
		Map<String, Object> f = new HashMap<>();
		f.put("type", type);
		f.put("name", name);
		f.put("nameCapitalized", nameCapitalized(name));
		f.put("defaultValue", defaultValue);
		return f;
	}

	public static String nameCapitalized(String name) {
		return name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	public static String lowerCase(String name) {
		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}

	static class FieldTypePredicate {
		private final String type;

		public FieldTypePredicate(String type) {
			this.type = type;
		}

		public boolean test(Field field) {
			return type.equals(field.type());
		}
	}
}