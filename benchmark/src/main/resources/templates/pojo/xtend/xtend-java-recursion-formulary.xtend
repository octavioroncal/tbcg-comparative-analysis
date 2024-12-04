«IF formData.packageName != null»
package «formData.packageName»;
«ENDIF»

public class «formData.className» {

  «FOR field : formData.fields»
  private «field.type» «field.name»;
  «ENDFOR»

  «FOR subform : formData.subforms»
  private «subform.className» «subform.className.toFirstLower» = new «subform.className»();
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

  «FOR subform : formData.subforms»
  «generateInnerSubform(subform)»
  «ENDFOR»
}
 public class «subform.className» {

  «FOR field : subform.fields»
  private «field.type» «field.name»;
  «ENDFOR»

  «FOR nestedSubform : subform.subforms»
  private «nestedSubform.className» «nestedSubform.className.toFirstLower» = new «nestedSubform.className»();
  «ENDFOR»

  public «subform.className»() {
	 «FOR field : subform.fields»
	 this.«field.name» = «getDefaultValue(field)»;
	 «ENDFOR»
  }

  «FOR field : subform.fields»
  public «field.type» get«field.name.toFirstUpper»() {
	 return «field.name»;
  }

  public void set«field.name.toFirstUpper»(«field.type» «field.name») {
	 this.«field.name» = «field.name»;
  }
  «ENDFOR»

  «FOR nestedSubform : subform.subforms»
  «generateInnerSubform(nestedSubform)»
  «ENDFOR»
}
def String getDefaultValue(Field field) {
   switch field.type {
	  case "String": return "\"" + (field.defaultValue ?: "") + "\""
	  case "int": return field.defaultValue ?: "0"
	  default: return "new " + field.type + "()"
   }
}