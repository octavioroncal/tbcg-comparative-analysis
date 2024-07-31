package com.example.form.generator;

import java.util.Arrays;
import java.util.List;

public class GenerateForm {
	   public static void main(String[] args) {
	        List<Field> fields = Arrays.asList(
	            new Field("username", "String", "defaultUser"),
	            new Field("age", "int", "30")
	        );
	        Form form = new Form("UserForm", fields);

	        // Asumimos que FormTemplate está compilado y disponible
	        FormTemplate template = new FormTemplate();
	        CharSequence result = template.generate(form);
	        System.out.println(result);
	    }
}
