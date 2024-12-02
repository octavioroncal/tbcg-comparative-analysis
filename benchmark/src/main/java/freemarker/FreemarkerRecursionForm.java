package freemarker;

import freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerRecursionForm {


	public static void main(String[] args) throws IOException, TemplateException {
		System.out.println(execute());
	}

	public static String execute() throws IOException, TemplateException {
		Configuration cfg = new Configuration(new Version("2.3.31"));
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Map<String, Object> root = form();
		Template template = cfg.getTemplate("templates/pojo/freemarker/freemarker-java-recursion-formulary.ftl");
		StringWriter writer = new StringWriter();
		try (Writer fileWriter = writer) {
			template.process(root, fileWriter);
		}
		return writer.toString();
	}

	private static Map<String, Object> form() {
		Map<String, Object> root = new HashMap<>();
		root.put("packageName", "com.example.forms");
		root.put("className", "UserForm");
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title"));
		fields.add(field("int", "age", 30));
		root.put("fields", fields);
		List<Map<String, Object>> subForms = new ArrayList<>();
		subForms.add(subForm(1, 2));
		root.put("subforms", subForms);
		return root;
	}

	private static Map<String, Object> subForm(int level, int maxLevel) {
		Map<String, Object> subForm = new HashMap<>();
		subForm.put("className", "Form" + level);
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title " +level));
		fields.add(field("int", "age", level));
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
		f.put("defaultValue", defaultValue);
		return f;
	}
}
