package com.example.generator

import com.example.Form
import com.example.Field

class FormGenerator {
	def String generate(Form formData) {
		'''
		«IF formData.packageName != null»
		package «formData.packageName»;
		«ENDIF»

		public class «formData.className» {

			«FOR field : formData.fields»
			private «field.type» «field.name»;
			«ENDFOR»

			public «formData.className»() {
				«FOR field : formData.fields»
				this.«field.name» = «getDefaultValue(field)»;
				«ENDFOR»
			}

			«FOR field : formData.fields»
			public «field.type» get«field.name.toFirstUpper»() {
				return «field.name»;
			}

			public void set«field.name.toFirstUpper»(«field.type» «field.name») {
				this.«field.name» = «field.name»;
			}
			«ENDFOR»

			public void printFormDetails() {
				System.out.println("Form Details:");
				«FOR field : formData.fields»
				System.out.println("«field.name» (type: «field.type»): " + this.«field.name»);
				«ENDFOR»
			}
		}
		'''
	}

	def String getDefaultValue(Field field) {
		switch field.type {
			case "String": return "\"" + (field.defaultValue ?: "") + "\""
			case "int": return field.defaultValue ?: "0"
			default: return "new " + field.type + "()"
		}
	}
}