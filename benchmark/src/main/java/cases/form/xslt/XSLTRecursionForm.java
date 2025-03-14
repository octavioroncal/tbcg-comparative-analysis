package cases.form.xslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import static benchmark.EnginesOnRecursionContextBenchmark.SUB_FORMS;

public class XSLTRecursionForm {
	public static void main(String[] args) {
		System.out.println(execute(SUB_FORMS));
	}

	public static String execute(int subForms) {
		try {
			String schema = new RecursiveFormXMLGenerator().generate(subForms);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/templates/pojo/xslt/xslt-form-recursive.xsl")));
			StreamSource xmlSource = new StreamSource(new ByteArrayInputStream(schema.getBytes()));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			transformer.transform(xmlSource, new StreamResult(output));
			return output.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
