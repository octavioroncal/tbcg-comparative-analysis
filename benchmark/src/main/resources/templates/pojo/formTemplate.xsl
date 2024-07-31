<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:xalan="http://xml.apache.org/xslt"
				exclude-result-prefixes="xalan">
	<xsl:output method="text" encoding="UTF-8"/>¡
<xsl:template match="/form">
package com.example.form;

public class <xsl:value-of select="className"/> {
<xsl:for-each select="fields/field">
	private <xsl:value-of select="type"/> <xsl:value-of select="name"/>;</xsl:for-each>

	public <xsl:value-of select="className"/>() {<xsl:for-each select="fields/field">
<xsl:choose>
	<xsl:when test="type = 'String'">
		this.<xsl:value-of select="name"/> = "<xsl:value-of select="defaultValue"/>";</xsl:when>
	<xsl:when test="type = 'int'">
		this.<xsl:value-of select="name"/> = <xsl:value-of select="defaultValue"/>;</xsl:when>
	<xsl:otherwise>
		this.<xsl:value-of select="name"/> = new <xsl:value-of select="type"/>();</xsl:otherwise>
</xsl:choose>
	</xsl:for-each>
	}
<xsl:for-each select="fields/field">
	public <xsl:value-of select="type"/> get<xsl:value-of select="substring(translate(name,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),1,1)"/><xsl:value-of select="substring(name, 2)"/>() {
		return <xsl:value-of select="name"/>;
	}

	public void set<xsl:value-of select="substring(translate(name,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),1,1)"/><xsl:value-of select="substring(name, 2)"/>(<xsl:value-of select="type"/> <xsl:value-of select="name"/>) {
		this.<xsl:value-of select="name"/> = <xsl:value-of select="name"/>;
	}
</xsl:for-each>

	public void printFormDetails() {
		System.out.println("Form Details:");<xsl:for-each select="fields/field">
		System.out.println("<xsl:value-of select="name"/> (<xsl:value-of select="type"/>): " + <xsl:value-of select="name"/>);</xsl:for-each>
	}
}
	</xsl:template>
</xsl:stylesheet>