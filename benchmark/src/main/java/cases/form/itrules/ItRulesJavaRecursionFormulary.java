package cases.form.itrules;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;

public class ItRulesJavaRecursionFormulary {
	static int subFormsCount = 0;

	public static void main(String[] args) {
		System.out.println(execute(2));
		System.out.println(subFormsCount);

	}

	public static String execute(int subForms) {
		return new ItrulesJavaRecursionFormularyTemplate().render(frame(subForms));
	}

	private static Frame frame(int levels) {
		FrameBuilder builder = new FrameBuilder("form")
				.add("name", "UserForm")
				.add("type", "UserForm")
				.add("package", "org.example.form")
				.add("field", fields());
		for (int i = 0; i < levels; i++)
			builder.add("form", subForm(i, 1, levels ));
		return builder.toFrame();
	}

	private static Frame subForm(int index, int level, int maxLevel) {
		FrameBuilder subForm = new FrameBuilder("form");
		subForm.add("name", "Form" + level + "_" + index);
		subForm.add("type", "Form" + level + "_" + index);
		subForm.add("field", fields());
		if (level < maxLevel) {
			for (int i = 0; i < (maxLevel - level) ; i++) {
				subForm.add("form", subForm(i, level + 1, maxLevel));
			}
		}
		subFormsCount++;
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
