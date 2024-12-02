package com.example

import java.util.List

class Form {
   public val String className
   public val String packageName
   public val List<Field> fields
   public val List<Form> subforms

    new(String packageName, String className, List<Field> fields, List<Form> subforms) {
        this.packageName = packageName
        this.className = className
        this.fields = fields
        this.subforms = subforms
    }

    new(String className, List<Field> fields, List<Form> subforms) {
    	this.packageName =""
		this.className = className
		this.fields = fields
		this.subforms = subforms
	}
}