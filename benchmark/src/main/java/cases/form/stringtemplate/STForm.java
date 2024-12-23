package cases.form.stringtemplate;

import org.stringtemplate.v4.ST;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class STForm {
	public static void main(String[] args) throws IOException {
		System.out.println(execute());
	}

	public static String execute() throws IOException {
		String path = "./src/main/java/stringtemplate/Form.st";
		ST st = new ST(Files.readString(new File(path).toPath()), '<', '>');
		List<Form.Field> fields = Arrays.asList(
				new Form.Field("username", "String", "\"defaultUser\""),
				new Form.Field("age", "int", "30")
		);
		Form form = new Form("UserForm", fields);
		st.add("form", form);
		st.add("fields", fields);
		return st.render();
	}
}
