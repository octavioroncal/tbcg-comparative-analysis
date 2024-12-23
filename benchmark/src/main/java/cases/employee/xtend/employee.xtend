import java.util.List

class Employee {
   public val int id
   public val String name
   public val String position
   public val List<Employee> subordinates

    new(int id, String name, String position, List<Employee> subordinates) {
        this.id = id
        this.name = name
        this.position = position
        this.subordinates = subordinates
    }
}