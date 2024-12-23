package cases.form.xtend.com.example;

@SuppressWarnings("all")
public class Field {
  public final String type;

  public final String name;

  public final String defaultValue;

  public Field(final String type, final String name, final String defaultValue) {
    this.type = type;
    this.name = name;
    this.defaultValue = defaultValue;
  }
}
