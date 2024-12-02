<#if packageName??>
package ${packageName};
</#if>

public class ${className} {
<#list fields as field>
	private ${field.type} ${field.name};
</#list>

<#if subforms??>
<#list subforms as subform>
	private ${subform.className} ${subform.className?uncap_first} = new ${subform.className}();
</#list>
</#if>

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

<#if subforms??>
<#list subforms as subform>
	public ${subform.className} get${subform.className?cap_first}() {
		return ${subform.className?uncap_first};
	}

	public void set${subform.className?cap_first}(${subform.className} ${subform.className?uncap_first}) {
		this.${subform.className?uncap_first} = ${subform.className?uncap_first};
	}
</#list>
</#if>

	public void printFormDetails() {
		System.out.println("Form Details:");
	<#list fields as field>
		System.out.println("${field.name} (${field.type}): " + ${field.name});
	</#list>
	}

<#macro generateSubform subform>
	public class ${subform.className} {
    <#list subform.fields as field>
		private ${field.type} ${field.name};
    </#list>

    <#if subform.subforms??>
        <#list subform.subforms as nestedSubform>
			private ${nestedSubform.className} ${nestedSubform.className?uncap_first} = new ${nestedSubform.className}();
        </#list>
    </#if>

		public ${subform.className}() {
		<#list subform.fields as field>
		<#if field.type == "String">
			this.${field.name} = "${field.defaultValue!''}";
		<#elseif field.type == "int">
			this.${field.name} = ${field.defaultValue!0};
		<#else>
			this.${field.name} = new ${field.type}();
		</#if>
		</#list>
		}

    <#list subform.fields as field>
		public ${field.type} get${field.name?cap_first}() {
			return ${field.name};
		}

		public void set${field.name?cap_first}(${field.type} ${field.name}) {
			this.${field.name} = ${field.name};
		}
    </#list>

    <#if subform.subforms??>
        <#list subform.subforms as nestedSubform>
		public ${nestedSubform.className} get${nestedSubform.className?cap_first}() {
			return ${nestedSubform.className?uncap_first};
		}

		public void set${nestedSubform.className?cap_first}(${nestedSubform.className} ${nestedSubform.className?uncap_first}) {
			this.${nestedSubform.className?uncap_first} = ${nestedSubform.className?uncap_first};
		}
        </#list>
    </#if>

		public void printFormDetails() {
			System.out.println("Subform Details: ${subform.className}");
		<#list subform.fields as field>
			System.out.println("${field.name} (${field.type}): " + ${field.name});
		</#list>
		}

    <#if subform.subforms??>
        <#list subform.subforms as nestedSubform>
            <@generateSubform subform=nestedSubform/>
        </#list>
    </#if>
	}
</#macro>

<#if subforms??>
    <#list subforms as subform>
        <@generateSubform subform=subform/>
    </#list>
</#if>
}