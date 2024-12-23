package cases.employee.xtend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class XtendRecursionEmployee {
	private static final Random random = new Random();

	public static void main(String[] args) throws IOException {
		System.out.println(execute(3));
	}

	public static String execute(int maxLevel) {
		List<Employee> employees = new ArrayList<>();
		for (int i = 0; i < maxLevel; i++) employees.add(employee(i, 1, maxLevel));
		Employee employee = new Employee(1, "Elon Musk", "CEO", employees);
		EmployeeRecursiveGenerator template = new EmployeeRecursiveGenerator();
		return template.generate(employee);
	}

	private static Employee employee(int index, int level, int maxLevel) {
		String name = "Employee" + level + "_" + index;
		List<Employee> subordinates = new ArrayList<>();
		if (level < maxLevel) {
			for (int i = 0; i < (maxLevel - level); i++) {
				subordinates.add(employee(i, level + 1, maxLevel));
			}
		}
		return new Employee(level * 10 + index, name, "Employee " + level + "_" + index, subordinates);
	}
}
