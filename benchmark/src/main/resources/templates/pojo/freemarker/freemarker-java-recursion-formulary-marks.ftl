<#if packageName??>
${packageName};
</#if>
${className}
<#list fields as field>
${field.type}${field.name}
</#list>

<#if subforms??>
<#list subforms as subform>
${subform.className}${subform.className?uncap_first}${subform.className}
</#list>
</#if>
${className}
	<#list fields as field>
	<#if field.type == "String">
		${field.name}${field.defaultValue!''}
	<#elseif field.type == "int">
		${field.name}${field.defaultValue!0}
	<#else>
		${field.name}${field.type}
	</#if>
	</#list>
<#list fields as field>
	${field.type} ${field.name?cap_first}
		${field.name}
	${field.name?cap_first}${field.type}${field.name}
		${field.name}${field.name}
</#list>

<#if subforms??>
<#list subforms as subform>
${subform.className}${subform.className?cap_first}
${subform.className?uncap_first}
${subform.className?cap_first}${subform.className}${subform.className?uncap_first}
${subform.className?uncap_first}${subform.className?uncap_first}
</#list>
</#if>
<#list fields as field>
${field.name}${field.type}${field.name}
	</#list>
<#macro generateSubform subform>
	${subform.className}
	<#list subform.fields as field>
	${field.type} ${field.name};
	</#list>
	<#if subform.subforms??>
		<#list subform.subforms as nestedSubform>
			private ${nestedSubform.className} ${nestedSubform.className?uncap_first} = new ${nestedSubform.className}();
		</#list>
	</#if>
	${subform.className}
		<#list subform.fields as field>
		<#if field.type == "String">
	${field.name}${field.defaultValue!''}
		<#elseif field.type == "int">${field.name}${field.defaultValue!0}
		<#else>
		${field.name}${field.type}
		</#if>
		</#list>
	<#list subform.fields as field>
		${field.type}${field.name?cap_first}${field.name}${field.name?cap_first}${field.type} ${field.name}${field.name}${field.name}
	</#list>

	<#if subform.subforms??>
		<#list subform.subforms as nestedSubform>
		${nestedSubform.className} get${nestedSubform.className?cap_first}${nestedSubform.className?uncap_first}${nestedSubform.className?cap_first}(${nestedSubform.className} ${nestedSubform.className?uncap_first}${nestedSubform.className?uncap_first} = ${nestedSubform.className?uncap_first};
		</#list>
	</#if>
	${subform.className}
		<#list subform.fields as field>
			${field.name}${field.type}${field.name}
		</#list>
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