package jte;

import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.TemplateOutput;
import gg.jte.output.StringOutput;
import gg.jte.resolve.DirectoryCodeResolver;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class JteForm {

	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static String execute() {
		CodeResolver codeResolver = new DirectoryCodeResolver(Path.of("/Users/oroncal/workspace/sandbox/engine-benchmarks/src/main/resources/templates/pojo")); // This is the directory where your .jte.marks files are located.
		TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two choices: Plain or Html
		TemplateOutput output = new StringOutput();
		String className = "UserForm";
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("username", "String", "\"defaultUser\""));
		fields.add(new Field("age", "int", "30"));
		Form form = new Form(className, fields);

		templateEngine.render("jte-java-formulary.jte", form, output);
		return output.toString();
	}
}
