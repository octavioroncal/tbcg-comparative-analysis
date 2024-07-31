[module generate('http://www.eclipse.org/emf/2002/Ecore')/]
[template public generateClass(aClass : EClass)]
[file (aClass.name.concat('.java'), false, 'UTF-8')]
package com.example.form;

public class [aClass.name/] {

[for (attribute : EAttribute | aClass.eAllAttributes)]
	private [attribute.eType.instanceClassName/] [attribute.name/];
[/for]

	public [aClass.name/]() {
[for (attribute : EAttribute | aClass.eAllAttributes)]
	[if (attribute.eType.instanceClassName = 'java.lang.String')]
		this.[attribute.name/] = "[attribute.defaultValue/]";
	[elseif (attribute.eType.instanceClassName = 'int' or attribute.eType.instanceClassName = 'Integer')]
		this.[attribute.name/] = [attribute.defaultValue/];
	[else]
		this.[attribute.name/] = new [attribute.eType.instanceClassName/]();
	[endif]
[/for]
	}

[for (attribute : EAttribute | aClass.eAllAttributes)]
	public [attribute.eType.instanceClassName/] get[attribute.name.toFirstUpper()/]() {
		return this.[attribute.name/];
	}

	public void set[attribute.name.toFirstUpper()/]([attribute.eType.instanceClassName/] [attribute.name/]) {
		this.[attribute.name/] = [attribute.name/];
	}
[/for]

	public void printFormDetails() {
		System.out.println("Form Details:");
		[for (attribute : EAttribute | aClass.eAllAttributes)]
			System.out.println("[attribute.name/] ([attribute.eType.instanceClassName/]): " + this.[attribute.name/]);
		[/for]
	}
}
[/file]
[/template]