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

public class FreemarkerForm {


	public static void main(String[] args) throws IOException, TemplateException {
		execute();
	}

	public static String execute() throws IOException, TemplateException {
		Configuration cfg = new Configuration(new Version("2.3.31"));
		cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		Map<String, Object> root = new HashMap<>();
		root.put("className", "UserForm");
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
		root.put("fields", fields);
		Template template = cfg.getTemplate("templates/pojo/freemarker/freemarker-java-formulary.ftl");
		StringWriter writer = new StringWriter();
		try (Writer fileWriter = writer) {
			template.process(root, fileWriter);
		}
		return writer.toString();
	}
}
