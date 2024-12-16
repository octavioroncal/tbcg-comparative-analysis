package com.example.form;

public class <form.className> {

<fields:{field |
	private <field.type> <field.name>;
}>

	public <form.className>() {
	<fields:{field |
	this.<field.name> = <if(field.defaultValue)><field.defaultValue><else>new <field.type>()<endif>;
	}>
	}

<fields:{field |
	public <field.type> get<field.name; format="cap">() {
		return this.<field.name>;
	\}

	public void set<field.name; format="cap">(<field.type> <field.name>) {
		this.<field.name> = <field.name>;
	\}

}>

	public void printFormDetails() {
		System.out.println("Form Details:");
	<fields:{field |
	System.out.println("<field.name> (<field.type>): " + this.<field.name>);
	}>
	}
}