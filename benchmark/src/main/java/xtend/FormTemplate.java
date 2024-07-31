package xtend;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.StringExtensions;

@SuppressWarnings("all")
public class FormTemplate {
  public CharSequence generate(final Form form) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package com.example.form;");
    _builder.newLine();
    _builder.newLine();
    _builder.append("public class ");
    String _className = form.getClassName();
    _builder.append(_className);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      List<Field> _fields = form.getFields();
      for(final Field field : _fields) {
        _builder.append("    ");
        _builder.append("private ");
        String _type = field.getType();
        _builder.append(_type, "    ");
        _builder.append(" ");
        String _name = field.getName();
        _builder.append(_name, "    ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public ");
    String _className_1 = form.getClassName();
    _builder.append(_className_1, "    ");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    {
      List<Field> _fields_1 = form.getFields();
      for(final Field field_1 : _fields_1) {
        {
          String _type_1 = field_1.getType();
          boolean _equals = Objects.equal(_type_1, "String");
          if (_equals) {
            _builder.append("        ");
            _builder.append("this.");
            String _name_1 = field_1.getName();
            _builder.append(_name_1, "        ");
            _builder.append(" = \"");
            String _defaultValue = field_1.getDefaultValue();
            _builder.append(_defaultValue, "        ");
            _builder.append("\";");
            _builder.newLineIfNotEmpty();
          } else {
            String _type_2 = field_1.getType();
            boolean _equals_1 = Objects.equal(_type_2, "int");
            if (_equals_1) {
              _builder.append("        ");
              _builder.append("this.");
              String _name_2 = field_1.getName();
              _builder.append(_name_2, "        ");
              _builder.append(" = ");
              String _defaultValue_1 = field_1.getDefaultValue();
              _builder.append(_defaultValue_1, "        ");
              _builder.append(";");
              _builder.newLineIfNotEmpty();
            } else {
              _builder.append("        ");
              _builder.append("this.");
              String _name_3 = field_1.getName();
              _builder.append(_name_3, "        ");
              _builder.append(" = new ");
              String _type_3 = field_1.getType();
              _builder.append(_type_3, "        ");
              _builder.append("();");
              _builder.newLineIfNotEmpty();
            }
          }
        }
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    {
      List<Field> _fields_2 = form.getFields();
      for(final Field field_2 : _fields_2) {
        _builder.append("    ");
        _builder.append("public ");
        String _type_4 = field_2.getType();
        _builder.append(_type_4, "    ");
        _builder.append(" get");
        String _firstUpper = StringExtensions.toFirstUpper(field_2.getName());
        _builder.append(_firstUpper, "    ");
        _builder.append("() {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("    ");
        _builder.append("return ");
        String _name_4 = field_2.getName();
        _builder.append(_name_4, "        ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
        _builder.newLine();
        _builder.append("    ");
        _builder.append("public void set");
        String _firstUpper_1 = StringExtensions.toFirstUpper(field_2.getName());
        _builder.append(_firstUpper_1, "    ");
        _builder.append("(");
        String _type_5 = field_2.getType();
        _builder.append(_type_5, "    ");
        _builder.append(" ");
        String _name_5 = field_2.getName();
        _builder.append(_name_5, "    ");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("    ");
        _builder.append("this.");
        String _name_6 = field_2.getName();
        _builder.append(_name_6, "        ");
        _builder.append(" = ");
        String _name_7 = field_2.getName();
        _builder.append(_name_7, "        ");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
        _builder.append("    ");
        _builder.append("}");
        _builder.newLine();
      }
    }
    _builder.newLine();
    _builder.append("    ");
    _builder.append("public void printFormDetails() {");
    _builder.newLine();
    _builder.append("        ");
    _builder.append("System.out.println(\"Form Details:\");");
    _builder.newLine();
    {
      List<Field> _fields_3 = form.getFields();
      for(final Field field_3 : _fields_3) {
        _builder.append("        ");
        _builder.append("System.out.println(\"");
        String _name_8 = field_3.getName();
        _builder.append(_name_8, "        ");
        _builder.append(" (");
        String _type_6 = field_3.getType();
        _builder.append(_type_6, "        ");
        _builder.append("): \" + ");
        String _name_9 = field_3.getName();
        _builder.append(_name_9, "        ");
        _builder.append(");");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("    ");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
