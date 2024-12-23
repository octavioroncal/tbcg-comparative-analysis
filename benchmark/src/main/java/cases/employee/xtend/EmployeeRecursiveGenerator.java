package cases.employee.xtend;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class EmployeeRecursiveGenerator {
  public String generate(final Employee employee) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Employee(");
    _builder.append(employee.id);
    _builder.append(", \"");
    _builder.append(employee.name);
    _builder.append("\", \"");
    _builder.append(employee.position);
    _builder.append("\", [");
    _builder.newLineIfNotEmpty();
    _builder.append("        ");
    {
      for(final Employee subordinate : employee.subordinates) {
        String _generate = this.generate(subordinate);
        _builder.append(_generate, "        ");
        {
          boolean _equals = subordinate.equals(employee.subordinates.getLast());
          boolean _not = (!_equals);
          if (_not) {
            _builder.append(",");
          }
        }
        _builder.newLineIfNotEmpty();
        _builder.append("        ");
      }
    }
    _builder.append("])");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}
