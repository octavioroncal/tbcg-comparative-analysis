package benchmark;

import cases.form.freemarker.FreemarkerForm;
import freemarker.template.TemplateException;
import cases.form.itrules.ItRulesJavaFormulary;
import cases.form.jte.JteForm;
import cases.form.mustache.MustacheForm;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import cases.form.pebble.PebbleForm;
import cases.form.stringtemplate.STForm;
import cases.form.velocity.VelocityForm;
import cases.form.xslt.XSLTForm;
import cases.form.xtend.XtendForm;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@OutputTimeUnit(TimeUnit.MILLISECONDS)
@BenchmarkMode(Mode.AverageTime)
@Fork(value = 2, warmups = 1)
@Warmup(iterations = 1)
@Measurement(iterations = 3)
public class EnginesBenchmark {
	@Benchmark
	public void freemarker(Blackhole bh) throws IOException, TemplateException {
		bh.consume(FreemarkerForm.execute());
	}

	@Benchmark
	public void pebble(Blackhole bh) throws IOException {
		bh.consume(PebbleForm.execute());
	}

	@Benchmark
	public void stringtemplate(Blackhole bh) throws IOException {
		bh.consume(STForm.execute());
	}

	@Benchmark
	public void jte(Blackhole bh) {
		bh.consume(JteForm.execute());
	}

	@Benchmark
	public void velocity(Blackhole bh) throws IOException {
		bh.consume(VelocityForm.execute());
	}

	@Benchmark
	public void itrules(Blackhole bh) {
		bh.consume(ItRulesJavaFormulary.execute());
	}

	@Benchmark
	public void xtend(Blackhole bh) {
		bh.consume(XtendForm.execute());
	}

	@Benchmark
	public void xslt(Blackhole bh) {
		bh.consume(XSLTForm.execute());
	}

	@Benchmark
	public void mustache(Blackhole bh) throws IOException {
		bh.consume(MustacheForm.execute());
	}

	@Benchmark
	public void acceleo(Blackhole bh) {
//		org.eclipse.acceleo.module.sample.main.Generate.main(
//				new String[]{"../emf/org.eclipse.acceleo.module.sample/bin/org/eclipse/acceleo/module/sample/main/main.uml",
//						"./gen/acceleo/"});
	}
}