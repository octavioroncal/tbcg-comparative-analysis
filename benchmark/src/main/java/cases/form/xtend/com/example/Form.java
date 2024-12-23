package cases.form.xtend.com.example;

import java.util.List;

@SuppressWarnings("all")
public class Form {
  public final String className;

  public final String packageName;

  public final List<Field> fields;

  public final List<Form> subforms;

  public Form(final String packageName, final String className, final List<Field> fields, final List<Form> subforms) {
    this.packageName = packageName;
    this.className = className;
    this.fields = fields;
    this.subforms = subforms;
  }

  public Form(final String className, final List<Field> fields, final List<Form> subforms) {
    this.packageName = "";
    this.className = className;
    this.fields = fields;
    this.subforms = subforms;
  }
}
