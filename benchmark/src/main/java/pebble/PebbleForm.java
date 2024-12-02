package pebble;

import io.pebbletemplates.pebble.PebbleEngine;
import io.pebbletemplates.pebble.template.PebbleTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PebbleForm {

    public static void main(String[] args) throws IOException {
        execute();
    }

    public static String  execute() throws IOException {
        PebbleEngine engine = new PebbleEngine.Builder().build();
        PebbleTemplate compiledTemplate = engine.getTemplate("templates/pojo/pebble-java-formulary.peb");
        Map<String, Object> context = new HashMap<>();
        context.put("className", "UserForm");
        List<Map<String, Object>> fields = new ArrayList<>();
        Map<String, Object> field1 = new HashMap<>();
        field1.put("type", "String");
        field1.put("name", "username");
        field1.put("defaultValue", "defaultUser");
        fields.add(field1);

        Map<String, Object> field2 = new HashMap<>();
        field2.put("type", "int");
        field2.put("name", "age");
        field2.put("defaultValue", 30);
        fields.add(field2);

        context.put("fields", fields);

        Writer writer = new StringWriter();
        compiledTemplate.evaluate(writer, context);
        return writer.toString();
    }
}
