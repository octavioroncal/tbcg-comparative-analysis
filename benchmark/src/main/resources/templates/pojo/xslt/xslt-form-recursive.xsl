<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" indent="no"/>

	<xsl:template match="/Form">
		<xsl:if test="packageName">
		package <xsl:value-of select="packageName"/>;
		</xsl:if>
		public class <xsl:value-of select="className"/> {
		<xsl:for-each select="fields/field">
			private <xsl:value-of select="concat(type, ' ', name)"/>;
		</xsl:for-each>
		<xsl:for-each select="subforms/subform">
			private <xsl:value-of select="className"/>  <xsl:value-of select="concat(translate(substring(className,1,1),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),substring(className,2))"/> = new <xsl:value-of select="className"/>();
		</xsl:for-each>

		public <xsl:value-of select="className"/>() {
		<xsl:for-each select="fields/field">
			<xsl:choose>
				<xsl:when test="type='String'">
					this.<xsl:value-of select="name"/> = "<xsl:value-of select="defaultValue"/>";
				</xsl:when>
				<xsl:when test="type='int'">
					this.<xsl:value-of select="name"/> = <xsl:value-of select="defaultValue"/>;
				</xsl:when>
				<xsl:otherwise>
					this.<xsl:value-of select="name"/> = new <xsl:value-of select="type"/>();
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
		}

		<xsl:for-each select="fields/field">
			public <xsl:value-of select="type"/> get<xsl:value-of select="concat(translate(substring(name,1,1),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),substring(name,2))"/>() {
			return <xsl:value-of select="name"/>;
			}

			public void set<xsl:value-of select="concat(translate(substring(name,1,1),'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ'),substring(name,2))"/>(<xsl:value-of select="type"/> <xsl:value-of select="name"/>) {
			this.<xsl:value-of select="name"/> = <xsl:value-of select="name"/>;
			}
		</xsl:for-each>

		<xsl:for-each select="subforms/subform">
			<xsl:call-template name="generateSubform"/>
		</xsl:for-each>

		public void printFormDetails() {
		System.out.println("Form Details:");
		<xsl:for-each select="fields/field">
			System.out.println("<xsl:value-of select="name"/> (<xsl:value-of select="type"/>): " + <xsl:value-of select="name"/>);
		</xsl:for-each>
		}

	</xsl:template>

	<xsl:template name="generateSubform">
		<xsl:param name="subform" select="."/>

		public class <xsl:value-of select="$subform/className"/> {
		<xsl:for-each select="$subform/fields/field">
			private <xsl:value-of select="type"/> <xsl:value-of select="name"/>;
		</xsl:for-each>

		<xsl:for-each select="$subform/subforms/subform">
			private <xsl:value-of select="className"/>  <xsl:value-of select="concat(translate(substring(className,1,1),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),substring(className,2))"/> = new <xsl:value-of select="className"/>();
		</xsl:for-each>

		public <xsl:value-of select="$subform/className"/>() {
		<xsl:for-each select="$subform/fields/field">
			<xsl:choose>
				<xsl:when test="type='String'">
					this.<xsl:value-of select="name"/> = "<xsl:value-of select="defaultValue"/>";
				</xsl:when>
				<xsl:when test="type='int'">
					this.<xsl:value-of select="name"/> = <xsl:value-of select="defaultValue"/>;
				</xsl:when>
				<xsl:otherwise>
					this.<xsl:value-of select="name"/> = new <xsl:value-of select="type"/>();
				</xsl:otherwise>
			</xsl:choose>
		</xsl:for-each>
		}

		public void printFormDetails() {
		System.out.println("Form Details: <xsl:value-of select="$subform/className"/>");
		<xsl:for-each select="$subform/fields/field">
			System.out.println("<xsl:value-of select="name"/> (<xsl:value-of select="type"/>): " + <xsl:value-of select="name"/>);
		</xsl:for-each>
		}

		<xsl:for-each select="$subform/subforms/subform">
			<xsl:call-template name="generateSubform"/>
		</xsl:for-each>

	</xsl:template>

</xsl:stylesheet>