package com.example.form.generator;

public class Field {
	private String name;
	private String type;
	private String defaultValue;

	public Field(String name, String type, String defaultValue) {
		this.name = name;
		this.type = type;
		this.defaultValue = defaultValue;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getDefaultValue() {
		return defaultValue;
	}
}