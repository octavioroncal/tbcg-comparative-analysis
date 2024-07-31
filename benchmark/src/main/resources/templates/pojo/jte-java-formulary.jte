@import jte.Form
@import jte.Field

@param Form form

package com.example.form;

public class ${form.className()} {
@for (Field field : form.fields())
	private ${field.type()} ${field.name()};
@endfor

public ${form.className()}() {
	@for (Field field : form.fields())
	@if (field.type().equals("String"))
		this.${field.name()} = "${field.defaultValue()}";
	@elseif (field.type().equals("int"))
		this.${field.name()} = ${field.defaultValue()};
	@else
		this.${field.name()} = new ${field.type()}();
	@endif
	@endfor
	}
	
	@for (Field field : form.fields())
	public ${field.type()} get${field.name().substring(0, 1).toUpperCase() + field.name().substring(1)}() {
		return this.${field.name()};
	}

	public void set${field.name().substring(0, 1).toUpperCase() + field.name().substring(1)}(${field.type()} ${field.name()}) {
		this.${field.name()} = ${field.name()};
	}
	@endfor
	
	public void printFormDetails() {
		System.out.println("Form Details:");
		@for (Field field : form.fields())
		System.out.println("${field.name()} (${field.type()}): " + this.${field.name()});
		@endfor
	}
}