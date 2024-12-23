package cases.employee;

import cases.employee.itrules.ItRulesPythonRecursionEmployee;
import cases.employee.xtend.XtendRecursionEmployee;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class EmployeeRecursionBenchmarkRunner {

	public static void main(String[] args) throws RunnerException {
		Options opt = new OptionsBuilder()
				.include(EmployeeExperiment.class.getSimpleName())
				.build();
		new Runner(opt).run();
	}

	@OutputTimeUnit(TimeUnit.MILLISECONDS)
	@BenchmarkMode(Mode.AverageTime)
	@Fork(value = 2, warmups = 1)
	@Warmup(iterations = 1)
	@Measurement(iterations = 2)
	public static class EmployeeExperiment {
		public static final int SUBORDINATE_LEVELS = 3;


		@Benchmark
		public void itrules(Blackhole bh) {
			bh.consume(ItRulesPythonRecursionEmployee.execute(SUBORDINATE_LEVELS));
		}

		@Benchmark
		public void xtend(Blackhole bh) {
			bh.consume(XtendRecursionEmployee.execute(SUBORDINATE_LEVELS));
		}
	}
}
