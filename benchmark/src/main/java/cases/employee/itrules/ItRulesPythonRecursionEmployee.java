package cases.employee.itrules;

import io.intino.itrules.Frame;
import io.intino.itrules.FrameBuilder;

public class ItRulesPythonRecursionEmployee {

	public static void main(String[] args) {
		System.out.println(execute(2));
	}

	public static String execute(int subForms) {
		return new ItrulesPythonRecursionEmployeeTemplate().render(frame(subForms));
	}

	private static Frame frame(int levels) {
		FrameBuilder builder = new FrameBuilder("employee")
				.add("id", 1)
				.add("name", "Elon Musk")
				.add("position", "CEO");

		for (int i = 0; i < levels; i++)
			builder.add("employee", employee(i, 1, levels));
		return builder.toFrame();
	}

	private static Frame employee(int index, int level, int maxLevel) {
		FrameBuilder subForm = new FrameBuilder("employee");
		subForm.add("name", "Employee" + level + "_" + index);
		subForm.add("id", level * 10 + index);
		subForm.add("position", "Employee " + level + "_" + index);
		if (level < maxLevel) {
			for (int i = 0; i < (maxLevel - level); i++) {
				subForm.add("employee", employee(i, level + 1, maxLevel));
			}
		}
		return subForm.toFrame();
	}
}
