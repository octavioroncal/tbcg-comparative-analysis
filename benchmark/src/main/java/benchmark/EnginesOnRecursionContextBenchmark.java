package benchmark;

import cases.form.freemarker.FreemarkerRecursionForm;
import freemarker.template.TemplateException;
import cases.form.itrules.ItRulesJavaRecursionFormulary;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import cases.form.velocity.VelocityRecursionForm;
import cases.form.xtend.XtendRecursionForm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2, warmups = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class EnginesOnRecursionContextBenchmark {

	public static final int SUB_FORMS = 5;

	@Benchmark
	public void freemarker(Blackhole bh) throws IOException, TemplateException {
		bh.consume(FreemarkerRecursionForm.execute(SUB_FORMS));
	}

	@Benchmark
	public void velocity(Blackhole bh) throws IOException {
		bh.consume(VelocityRecursionForm.execute(SUB_FORMS));
	}

	@Benchmark
	public void itrules(Blackhole bh) {
		bh.consume(ItRulesJavaRecursionFormulary.execute(SUB_FORMS));
	}

	@Benchmark
	public void xtend(Blackhole bh) {
		bh.consume(XtendRecursionForm.execute(SUB_FORMS));
	}

//	@Benchmark
//	public void acceleo(Blackhole bh) {
//		Generate.main(
//				new String[]{"../emf/org.eclipse.acceleo.module.sample/bin/org/eclipse/acceleo/module/sample/main/main.uml",
//						"./gen/acceleo/"});
//	}
}