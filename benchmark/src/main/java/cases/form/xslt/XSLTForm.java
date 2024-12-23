package cases.form.xslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class XSLTForm {
	public static void main(String[] args) {
		System.out.println(execute());
	}

	public static String execute() {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(new StreamSource(new File("src/main/resources/templates/pojo/xslt-java-formulary.xsl")));
			StreamSource xmlSource = new StreamSource(new File("src/main/java/xslt/form.xml"));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			transformer.transform(xmlSource, new StreamResult(output));
			return output.toString();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
