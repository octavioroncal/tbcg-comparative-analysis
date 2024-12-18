package itrules;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;

public class ItRulesJavaRecursionFormulary {

	public static void main(String[] args) {
		System.out.println(execute(1));
	}

	public static String execute(int subForms) {
		return new ItrulesJavaRecursionFormularyTemplate().render(frame(subForms));
	}

	private static Frame frame(int subForms) {
		return new FrameBuilder("form")
				.add("name", "UserForm")
				.add("type", "UserForm")
				.add("package", "org.example.form")
				.add("field", fields())
				.add("form", subForm(1, subForms))
				.toFrame();
	}

	private static Frame subForm(int level, int maxLevel) {
		FrameBuilder subForm = new FrameBuilder("form");
		subForm.add("name", "Form" + level);
		subForm.add("type", "Form" + level);
		subForm.add("field", fields());
		if (level < maxLevel) subForm.add("form", subForm(level + 1, maxLevel));
		return subForm.toFrame();
	}

	private static Frame[] fields() {
		return new Frame[]{
				new FrameBuilder("field", "String")
						.add("type", "String")
						.add("name", "username")
						.add("defaultValue", "admin")
						.toFrame(),
				new FrameBuilder("field", "int")
						.add("type", "int")
						.add("name", "age")
						.add("defaultValue", 30)
						.toFrame()
		};
	}
}
