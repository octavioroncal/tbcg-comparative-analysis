package cases.employee.xtend;

import java.util.List;

@SuppressWarnings("all")
public class Employee {
  public final int id;

  public final String name;

  public final String position;

  public final List<Employee> subordinates;

  public Employee(final int id, final String name, final String position, final List<Employee> subordinates) {
    this.id = id;
    this.name = name;
    this.position = position;
    this.subordinates = subordinates;
  }
}
