package cases.form.jte;

import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;

import java.util.ArrayList;
import java.util.List;

public class JteForm {

	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static String execute() {
		String className = "UserForm";
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("username", "String", "\"defaultUser\""));
		fields.add(new Field("age", "int", "30"));
		Form form = new Form(className, fields);
		TemplateOutput output = new StringOutput();
		JavaformularyGenerated.render(output, null, form);
		return output.toString();
	}
}
