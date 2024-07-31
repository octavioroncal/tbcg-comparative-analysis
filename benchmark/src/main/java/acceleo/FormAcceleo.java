package acceleo;

import org.eclipse.acceleo.module.sample.main.Generate;

public class FormAcceleo {

	public static void main(String[] args) {

		Generate.main(
				new String[]{"../emf/org.eclipse.acceleo.module.sample/bin/org/eclipse/acceleo/module/sample/main/main.uml",
						"./gen/acceleo/"});
	}
}
