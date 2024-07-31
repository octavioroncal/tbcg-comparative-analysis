package itrules;

import io.intino.itrules.Engine;
import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;

public class ItrulesForm {

	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static String execute() {
		FormTemplate template = new FormTemplate();
		return template.render(frame());
	}

	private static Frame frame() {
		return new FrameBuilder("form")
				.add("className", "UserForm")
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
						.add("defaultValue", 30)
						.toFrame()
		};
	}
}
