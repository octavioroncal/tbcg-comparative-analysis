package jet;

import com.tikal.codegen.jet.TemplateEmitter;
import com.tikal.maven.plugin.jet.JetMojo;
import groovy.lang.GroovyClassLoader;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Monitor;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Arrays;

public class JetForm {

	public static void main(String[] args) throws JETException, MalformedURLException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		pluginWay();
//		eclipseWay();
	}

	private static void pluginWay() throws MalformedURLException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		String templatePath = "/Users/oroncal/workspace/sandbox/engine-benchmarks/src/main/resources/templates/pojo/jet-form.template";
		TemplateEmitter emitter = new TemplateEmitter(new File(templatePath).toURL());
		Form form = new Form("Test Form", Arrays.asList("Name", "Age"));
		emitter.parse();
		String source = emitter.generate();
		GroovyClassLoader gcl = new GroovyClassLoader();
		Class clazz = gcl.parseClass(source);
		Object instance = clazz.newInstance();
		String generated = (String) clazz.getMethod("generate", Object.class).invoke(instance, "");
		System.out.println(generated.toString());
	}


	public static void eclipseWay() {
		try {
			Form form = new Form("Test Form", Arrays.asList("Name", "Age"));
			String templatePath = "/Users/oroncal/workspace/sandbox/engine-benchmarks/src/main/resources/templates/pojo/jet-form.template";
			JETEmitter emitter = new JETEmitter(templatePath, JetForm.class.getClassLoader());
			// Ejecutar la plantilla con el objeto modelo
			BasicMonitor.Printing progressMonitor = new BasicMonitor.Printing(System.out);
			emitter.initialize(progressMonitor);
			String result = emitter.generate(progressMonitor, new Object[]{form});
			System.out.println(result);
		} catch (JETException e) {
			e.printStackTrace();
		}
		String templatePath = "/path/to/your/template.jet";
		String modelPath = "/path/to/your/model.ecore";
		String[] templateArgs = new String[]{"arg1", "arg2"};

//		JETEmitter emitter = new JETEmitter(templatePath, Thread.currentThread().getContextClassLoader());
//		emitter.addVariable("MODEL", modelPath);
//
//		try {
//			String result = emitter.generate(null, templateArgs);
//			System.out.println(result);
//		} catch (JETException je) {
//			je.printStackTrace();
//		}
	}


}
