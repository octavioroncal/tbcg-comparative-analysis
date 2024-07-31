package com.example.generator

import com.example.form.Form
import com.example.form.Field

class FormTemplate {
	def generate(Form form) '''
		package com.example.form;

		public class «form.className» {

			«FOR field : form.fields»
			private «field.type» «field.name»;
			«ENDFOR»

			public «form.className»() {
				«FOR field : form.fields»
				«IF field.type == "String"»
				this.«field.name» = "«field.defaultValue»";
				«ELSEIF field.type == "int"»
				this.«field.name» = «field.defaultValue»;
				«ELSE»
				this.«field.name» = new «field.type»();
				«ENDIF»
				«ENDFOR»
			}

			«FOR field : form.fields»
			public «field.type» get«field.name.toFirstUpper»() {
				return «field.name»;
			}

			public void set«field.name.toFirstUpper»(«field.type» «field.name») {
				this.«field.name» = «field.name»;
			}
			«ENDFOR»

			public void printFormDetails() {
				System.out.println("Form Details:");
				«FOR field : form.fields»
				System.out.println("«field.name» («field.type»): " + «field.name»);
				«ENDFOR»
			}
		}
	'''
}