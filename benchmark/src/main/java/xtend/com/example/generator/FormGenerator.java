package xtend.com.example.generator;

import xtend.com.example.Field;
import xtend.com.example.Form;
import java.util.Objects;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FormGenerator {
  public String generate(final Form formData) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _notEquals = (!Objects.equals(formData.packageName, null));
      if (_notEquals) {
        _builder.append("package ");
        _builder.append(formData.packageName);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("public class ");
    _builder.append(formData.className);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      for(final Field field : formData.fields) {
        _builder.append("\t");
        _builder.append("private ");
        _builder.append(field.type, "\t");
        _builder.append(" ");
        _builder.append(field.name, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    _builder.append(formData.className, "\t");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    {
      for(final Field field_1 : formData.fields) {
        _builder.append("\t\t");
        _builder.append("this.");
        _builder.append(field_1.name, "\t\t");
        _builder.append(" = ");
        String _defaultValue = this.getDefaultValue(field_1);
        _builder.append(_defaultValue, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      for(final Field field_2 : formData.fields) {
        _builder.append("\t");
        _builder.append("public ");
        _builder.append(field_2.type, "\t");
        _builder.append(" get");
        String _firstUpper = StringExtensions.toFirstUpper(field_2.name);
        _builder.append(_firstUpper, "\t");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("return ");
        _builder.append(field_2.name, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(field_2.name);
        _builder.append(_firstUpper_1, "\t");
        _builder.append("(");
        _builder.append(field_2.type, "\t");
        _builder.append(" ");
        _builder.append(field_2.name, "\t");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("\t");
        _builder.append("this.");
        _builder.append(field_2.name, "\t\t");
        _builder.append(" = ");
        _builder.append(field_2.name, "\t\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public void printFormDetails() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("System.out.println(\"Form Details:\");");
    _builder.newLine();
    {
      for(final Field field_3 : formData.fields) {
        _builder.append("\t\t");
        _builder.append("System.out.println(\"");
        _builder.append(field_3.name, "\t\t");
        _builder.append(" (type: ");
        _builder.append(field_3.type, "\t\t");
        _builder.append("): \" + this.");
        _builder.append(field_3.name, "\t\t");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }

  public String getDefaultValue(final Field field) {
    final String _switchValue = field.type;
    if (_switchValue != null) {
      switch (_switchValue) {
        case "String":
          String _elvis = null;
          if (field.defaultValue != null) {
            _elvis = field.defaultValue;
          } else {
            _elvis = "";
          }
          String _plus = ("\"" + _elvis);
          return (_plus + "\"");
        case "int":
          String _elvis_1 = null;
          if (field.defaultValue != null) {
            _elvis_1 = field.defaultValue;
          } else {
            _elvis_1 = "0";
          }
          return _elvis_1;
        default:
          return (("new " + field.type) + "()");
      }
    } else {
      return (("new " + field.type) + "()");
    }
  }
}
