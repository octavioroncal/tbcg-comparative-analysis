package velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VelocityForm {

	public static void main(String[] args) throws IOException {
		execute();
	}

	public static String  execute() throws IOException {
		VelocityEngine velocityEngine = new VelocityEngine();
		velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		velocityEngine.init();
		VelocityContext context = new VelocityContext();
		context.put("className", "UserForm");
		List<Map<String, Object>> fields = new ArrayList<>();
		Map<String, Object> field1 = new HashMap<>();
		field1.put("type", "String");
		field1.put("name", "username");
		field1.put("defaultValue", "admin");
		fields.add(field1);
		Map<String, Object> field2 = new HashMap<>();
		field2.put("type", "int");
		field2.put("name", "age");
		field2.put("defaultValue", 30);
		fields.add(field2);
		context.put("fields", fields);
		Template template = velocityEngine.getTemplate("templates/pojo/velocity/velocity-java-formulary.vm");

		StringWriter stringWriter = new StringWriter();
		try (Writer writer = stringWriter) {
			template.merge(context, writer);
		}
		return stringWriter.toString();
	}
}

