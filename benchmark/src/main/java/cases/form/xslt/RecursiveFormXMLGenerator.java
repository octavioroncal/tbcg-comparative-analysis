package cases.form.xslt;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;

public class RecursiveFormXMLGenerator {

	public String generate(int levels) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		var builder = factory.newDocumentBuilder();
		var doc = builder.newDocument();
		Element form = doc.createElement("Form");
		doc.appendChild(form);
		appendTextElement(doc, form, "packageName", "com.example.forms");
		appendTextElement(doc, form, "className", "UserForm");
		Element fields = doc.createElement("fields");
		form.appendChild(fields);
		addField(doc, fields, "String", "username", "admin");
		addField(doc, fields, "int", "age", "30");
		generateRecursiveForm(doc, form, levels);
		return saveXML(doc);
	}

	private static void appendTextElement(Document doc, Element parent, String name, String value) {
		Element elem = doc.createElement(name);
		elem.setTextContent(value);
		parent.appendChild(elem);
	}

	private static void addField(Document doc, Element fields, String type, String name, String defaultValue) {
		Element field = doc.createElement("field");
		fields.appendChild(field);

		appendTextElement(doc, field, "type", type);
		appendTextElement(doc, field, "name", name);
		if (defaultValue != null) {
			appendTextElement(doc, field, "defaultValue", defaultValue);
		}
	}

	private static void addSubform(Document doc, Element subforms, String className, int level, int maxLevel) {
		Element subform = doc.createElement("subform");
		subforms.appendChild(subform);

		appendTextElement(doc, subform, "className", className);

		Element fields = doc.createElement("fields");
		subform.appendChild(fields);
		addField(doc, fields, "String", "field" + level, "default" + level);

		if (level < maxLevel) {
			Element nestedSubforms = doc.createElement("subforms");
			subform.appendChild(nestedSubforms);
			addSubform(doc, nestedSubforms, className + "Nested", level + 1, maxLevel);
		}
	}

	private static String saveXML(Document doc) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		transformer.transform(new DOMSource(doc), new StreamResult(stream));
		return stream.toString();
	}

	public static void generateRecursiveForm(Document doc, Element form, int maxRecursionLevel) {
		Element subforms = doc.createElement("subforms");
		form.appendChild(subforms);
		addSubform(doc, subforms, "SubForm", 1, maxRecursionLevel);
	}
}