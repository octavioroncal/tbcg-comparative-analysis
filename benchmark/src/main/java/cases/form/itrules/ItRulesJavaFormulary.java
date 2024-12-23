package cases.form.itrules;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;

import java.util.Random;

public class ItRulesJavaFormulary {
	private static final Random random = new Random();

	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static String execute() {
		ItRulesJavaFormularyTemplate template = new ItRulesJavaFormularyTemplate();
		return template.render(frame());
	}

	private static Frame frame() {
		return new FrameBuilder("form")
				.add("className", "UserForm")
				.add("package", "org.example.form")
				.add("field", fields())
				.toFrame();
	}

	private static Frame[] fields() {
		return new Frame[]{
				new FrameBuilder("field", "String")
						.add("name", "username")
						.add("defaultValue", "admin")
						.toFrame(),
				new FrameBuilder("field", "int")
						.add("name", "age")
						.add("defaultValue", random.nextInt())
						.toFrame()
		};
	}
}
