«DEFINE class FOR ecore::EClass»

package com.example.form;

public class «this.name» {

	«FOREACH this.eAttributes AS attr»
	private «attr.eType.instanceClassName» «attr.name»;
	«ENDFOREACH»

	public «this.name»() {
		«FOREACH this.eAttributes AS attr»
		«IF attr.eType.instanceClassName == 'java.lang.String'»
		this.«attr.name» = "«attr.defaultValue»";
		«ELSEIF attr.eType.instanceClassName == 'int' OR attr.eType.instanceClassName == 'java.lang.Integer'»
		this.«attr.name» = «attr.defaultValue»;
		«ELSE»
		this.«attr.name» = new «attr.eType.instanceClassName»();
		«ENDIF»
		«ENDFOREACH»
	}

	«FOREACH this.eAttributes AS attr»
	public «attr.eType.instanceClassName» get«attr.name.toFirstUpper()»() {
		return this.«attr.name»;
	}

	public void set«attr.name.toFirstUpper()»(«attr.eType.instanceClassName» «attr.name») {
		this.«attr.name» = «attr.name»;
	}
	«ENDFOREACH»

	public void printFormDetails() {
		System.out.println("Form Details:");
		«FOREACH this.eAttributes AS attr»
		System.out.println("«attr.name» («attr.eType.instanceClassName»): " + this.«attr.name»);
		«ENDFOREACH»
	}
}
«ENDDEFINE»