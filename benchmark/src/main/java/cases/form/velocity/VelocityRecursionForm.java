package cases.form.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

public class VelocityRecursionForm {
	private static final Random random = new Random();

	public static void main(String[] args) throws IOException {
		System.out.println(execute(100));
	}

	public static String execute(int subForms) throws IOException {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		Properties properties = new Properties();
		properties.load(VelocityRecursionForm.class.getClassLoader().getResourceAsStream("velocity.properties"));
		velocityEngine.init(properties);
		Template template = velocityEngine.getTemplate("templates/pojo/velocity/velocity-java-recursion-formulary.vm");
		StringWriter stringWriter = new StringWriter();
		try (Writer writer = stringWriter) {
			template.merge(form(subForms), writer);
		}
		return stringWriter.toString();
	}

	private static VelocityContext form(int maxLevel) {
		VelocityContext root = new VelocityContext();
		root.put("packageName", "com.example.forms");
		root.put("className", "UserForm");
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title"));
		fields.add(field("int", "age", random.nextInt()));
		root.put("fields", fields);
		List<Map<String, Object>> subForms = new ArrayList<>();
		for (int i = 0; i < maxLevel; i++) {
			subForms.add(subForm(1, maxLevel - 1));
		}
		root.put("subforms", subForms);
		return root;
	}

	private static Map<String, Object> subForm(int level, int maxLevel) {
		Map<String, Object> subForm = new HashMap<>();
		subForm.put("className", "Form" + level);
		List<Map<String, Object>> fields = new ArrayList<>();
		fields.add(field("String", "title", "Default Title " + level));
		fields.add(field("int", "age", random.nextInt()));
		subForm.put("fields", fields);
		if (level < maxLevel) {
			List<Map<String, Object>> subForms = new ArrayList<>();
			for (int i = 0; i < (maxLevel - level) + 1; i++) {
				subForms.add(subForm(level + 1, maxLevel));
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

