package velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VelocityRecursionForm {

	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}

	public static String  execute() throws IOException {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		Template template = velocityEngine.getTemplate("templates/pojo/velocity/velocity-java-recursion-formulary.vm");
		StringWriter stringWriter = new StringWriter();
		try (Writer writer = stringWriter) {
			template.merge(form(), writer);
		}
		return stringWriter.toString();
	}

	private static VelocityContext form() {
		VelocityContext root = new VelocityContext();
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
		fields.add(field("String", "title", "Default Title " + level));
		fields.add(field("int", "age", 3+level));
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

