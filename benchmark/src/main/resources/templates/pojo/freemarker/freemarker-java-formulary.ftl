package com.example.form;

public class ${className} {
	<#list fields as field>
	private ${field.type} ${field.name};
	</#list>

	public ${className}() {
		<#list fields as field>
		<#if field.type == "String">
		this.${field.name} = "${field.defaultValue!''}";
		<#elseif field.type == "int">
		this.${field.name} = ${field.defaultValue!0};
		<#else>
		this.${field.name} = new ${field.type}();
		</#if>
		</#list>
	}

	<#list fields as field>
	public ${field.type} get${field.name?cap_first}() {
		return ${field.name};
	}

	public void set${field.name?cap_first}(${field.type} ${field.name}) {
		this.${field.name} = ${field.name};
	}
	</#list>

	public void printFormDetails() {
		System.out.println("Form Details:");
		<#list fields as field>
		System.out.println("${field.name} (${field.type}): " + ${field.name});
		</#list>
	}
}