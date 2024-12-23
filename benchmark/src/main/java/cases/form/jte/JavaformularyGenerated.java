package cases.form.jte;

@SuppressWarnings("unchecked")
public final class JavaformularyGenerated {
	public static final String JTE_NAME = "jte-java-formulary.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,3,3,3,3,7,7,7,8,8,9,9,9,9,10,10,12,12,13,13,14,14,15,15,15,15,16,16,17,17,17,17,18,18,19,19,19,19,20,20,21,21,24,24,25,25,25,25,26,26,29,29,29,29,29,29,30,30,30,30,32,32,36,36,37,37,37,37,37,37,38,38,40,40,40,3,3,3,3};
	public static void render(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Form form) {
		jteOutput.writeContent("\npackage com.example.form;\n\npublic class ");
		jteOutput.writeUserContent(form.className());
		jteOutput.writeContent(" {\n");
		for (Field field : form.fields()) {
			jteOutput.writeContent("\n\tprivate ");
			jteOutput.writeUserContent(field.type());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(";\n");
		}
		jteOutput.writeContent("\n\npublic ");
		jteOutput.writeUserContent(form.className());
		jteOutput.writeContent("() {\n\t");
		for (Field field : form.fields()) {
			jteOutput.writeContent("\n\t");
			if (field.type().equals("String")) {
				jteOutput.writeContent("\n\t\tthis.");
				jteOutput.writeUserContent(field.name());
				jteOutput.writeContent(" = \"");
				jteOutput.writeUserContent(field.defaultValue());
				jteOutput.writeContent("\";\n\t");
			} else if (field.type().equals("int")) {
				jteOutput.writeContent("\n\t\tthis.");
				jteOutput.writeUserContent(field.name());
				jteOutput.writeContent(" = ");
				jteOutput.writeUserContent(field.defaultValue());
				jteOutput.writeContent(";\n\t");
			} else {
				jteOutput.writeContent("\n\t\tthis.");
				jteOutput.writeUserContent(field.name());
				jteOutput.writeContent(" = new ");
				jteOutput.writeUserContent(field.type());
				jteOutput.writeContent("();\n\t");
			}
			jteOutput.writeContent("\n\t");
		}
		jteOutput.writeContent("\n\t}\n\t\n\t");
		for (Field field : form.fields()) {
			jteOutput.writeContent("\n\tpublic ");
			jteOutput.writeUserContent(field.type());
			jteOutput.writeContent(" get");
			jteOutput.writeUserContent(field.name().substring(0, 1).toUpperCase() + field.name().substring(1));
			jteOutput.writeContent("() {\n\t\treturn this.");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(";\n\t}\n\n\tpublic void set");
			jteOutput.writeUserContent(field.name().substring(0, 1).toUpperCase() + field.name().substring(1));
			jteOutput.writeContent("(");
			jteOutput.writeUserContent(field.type());
			jteOutput.writeContent(" ");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(") {\n\t\tthis.");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(" = ");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(";\n\t}\n\t");
		}
		jteOutput.writeContent("\n\t\n\tpublic void printFormDetails() {\n\t\tSystem.out.println(\"Form Details:\");\n\t\t");
		for (Field field : form.fields()) {
			jteOutput.writeContent("\n\t\tSystem.out.println(\"");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(" (");
			jteOutput.writeUserContent(field.type());
			jteOutput.writeContent("): \" + this.");
			jteOutput.writeUserContent(field.name());
			jteOutput.writeContent(");\n\t\t");
		}
		jteOutput.writeContent("\n\t}\n}");
	}
	public static void renderMap(gg.jte.TemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Form form = (Form)params.get("form");
		render(jteOutput, jteHtmlInterceptor, form);
	}
}
