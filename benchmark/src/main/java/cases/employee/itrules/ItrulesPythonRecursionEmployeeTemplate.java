package cases.employee.itrules;

import io.intino.itrules.template.Rule;
import io.intino.itrules.template.Template;

import java.util.ArrayList;
import java.util.List;

import static io.intino.itrules.template.condition.predicates.Predicates.*;
import static io.intino.itrules.template.outputs.Outputs.*;

public class ItrulesPythonRecursionEmployeeTemplate extends Template {

	public List<Rule> ruleSet() {
		List<Rule> rules = new ArrayList<>();
		rules.add(rule().condition(allTypes("employee")).output(literal("  \tnew Employee(\"")).output(placeholder("id")).output(literal("\", \"")).output(placeholder("name")).output(literal("\", \"")).output(placeholder("position")).output(literal("\", [")).output(expression().output(literal("\n")).output(literal("\t")).output(placeholder("employee").multiple(",\n")).output(literal("\n"))).output(literal("])")));
		return rules;
	}

	public String render(Object object) {
		return new io.intino.itrules.Engine(this).render(object);
	}

	public String render(Object object, java.util.Map<String, io.intino.itrules.Formatter> formatters) {
		return new io.intino.itrules.Engine(this).addAll(formatters).render(object);
	}
}