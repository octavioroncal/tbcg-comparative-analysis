package cases.form.freemarker;

import freemarker.template.*;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class FreemarkerRecursionForm {

	private static final Random random = new Random();
	static int count = 0;

	public static void main(String[] args) throws IOException, TemplateException {
		execute(3);
		System.out.println(count);
	}

	public static String execute(int recursionLevel) throws IOException, TemplateException {
		Configuration cfg = new Configuration(new Version("2.3.31"));
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Map<String, Object> root = form(recursionLevel);
		Template template = cfg.getTemplate("templates/pojo/freemarker/freemarker-java-recursion-formulary.ftl");
		StringWriter writer = new StringWriter();
		try (Writer fileWriter = writer) {
			template.process(root, fileWriter);
		}
		return writer.toString();
	}

	private static Map<String, Object> form(int maxLevel) {
		Map<String, Object> root = new HashMap<>();
		root.put("packageName", "com.example.forms");
		root.put("className", "UserForm");
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title"));
		fields.add(field("int", "age", random.nextInt()));
		root.put("fields", fields);
		List<Map<String, Object>> subForms = new ArrayList<>();
		for (int i = 0; i < maxLevel; i++)
			subForms.add(subForm(i, 1, maxLevel));
		root.put("subforms", subForms);
		return root;
	}

	private static Map<String, Object> subForm(int index, int level, int maxLevel) {
		Map<String, Object> subForm = new HashMap<>();
		String name = "Form" + level + "_" + index;
		subForm.put("className", name);
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title " + level));
		fields.add(field("int", "age", random.nextInt()));
		subForm.put("fields", fields);
		if (level < maxLevel) {
			List<Map<String, Object>> subForms = new ArrayList<>();
			for (int i = 0; i < (maxLevel - level); i++) {
				count++;
				subForms.add(subForm(i, level + 1, maxLevel));
			}
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
