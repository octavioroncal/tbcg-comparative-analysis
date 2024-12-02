«IF packageName != null»
package «packageName»;
«ENDIF»

class «className» {

    «FOR field : fields»
    private «field.type» «field.name»;
    «ENDFOR»

    «FOR subform : subforms»
    private «subform.className» «subform.className.toFirstLower» = new «subform.className»();
    «ENDFOR»

    def «className»() {
        «FOR field : fields»
        «SWITCH field.type»
        «CASE "String"»
        this.«field.name» = "«field.defaultValue ?: ""»";
        «CASE "int"»
        this.«field.name» = «field.defaultValue ?: "0"»;
        «DEFAULT»
        this.«field.name» = new «field.type»();
        «ENDSWITCH»
        «ENDFOR»
    }

    «FOR field : fields»
    def «field.type» get«field.name.toFirstUpper»() {
        return «field.name»;
    }

    def void set«field.name.toFirstUpper»(«field.type» «field.name») {
        this.«field.name» = «field.name»;
    }
    «ENDFOR»

    «FOR subform : subforms»
    def «subform.className» get«subform.className.toFirstUpper»() {
        return «subform.className.toFirstLower»;
    }

    def void set«subform.className.toFirstUpper»(«subform.className» «subform.className.toFirstLower») {
        this.«subform.className.toFirstLower» = «subform.className.toFirstLower»;
    }
    «ENDFOR»

    «FOR subform : subforms»
    «generateSubform(subform)»
    «ENDFOR»
}

def generateSubform(subform : Subform) '''
class «subform.className» {

    «FOR field : subform.fields»
    private «field.type» «field.name»;
    «ENDFOR»

    «FOR nestedSubform : subform.subforms»
    private «nestedSubform.className» «nestedSubform.className.toFirstLower» = new «nestedSubform.className»();
    «ENDFOR»

    def «subform.className»() {
        «FOR field : subform.fields»
        «SWITCH field.type»
        «CASE "String"»
        this.«field.name» = "«field.defaultValue ?: ""»";
        «CASE "int"»
        this.«field.name» = «field.defaultValue ?: "0"»;
        «DEFAULT»
        this.«field.name» = new «field.type»();
        «ENDSWITCH»
        «ENDFOR»
    }

    «FOR field : subform.fields»
    def «field.type» get«field.name.toFirstUpper»() {
        return «field.name»;
    }

    def void set«field.name.toFirstUpper»(«field.type» «field.name») {
        this.«field.name» = «field.name»;
    }
    «ENDFOR»

    «FOR nestedSubform : subform.subforms»
    «generateSubform(nestedSubform, packageName)»
    «ENDFOR»
}
'''