package cases.form.mustache;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MustacheForm {

	public static void main(String[] args) throws IOException {
		System.out.println(execute());

	}

	public static String execute() throws IOException {
		List<Field> fields = Arrays.asList(
				new Field("username", "String", "defaultUser"),
				new Field("age", "int", "30")
		);
		Form form = new Form("UserForm", fields);

		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("templates/pojo/mustache/mustache-java-formulary.mustache");

		Map<String, Object> context = new HashMap<>();
		context.put("className", form.getClassName());
		context.put("fields", fields);
		context.put("isString", new FieldTypePredicate("String"));
		context.put("isInt", new FieldTypePredicate("int"));

		StringWriter writer = new StringWriter();
		mustache.execute(writer, context).flush();

		return writer.toString();
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