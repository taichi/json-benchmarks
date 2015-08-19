package json.benchmark;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import json.application.TestDataSupplier;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Thread)
/**
 * @author taichi
 * @see <a href="http://java-performance.info/jmh/">Introduction to JMH</a>
 * @see <a href="http://java-performance.info/introduction-jmh-profilers/">
 *      Introduction to JMH Profilers</a>
 */
public class BenchmarkBase {

	@Param({ "large", /* "medium", "small", "tiny" */ })
	public String type;

	@State(Scope.Thread)
	public static class ParserBenchmarkBase extends BenchmarkBase {

		protected URL json;

		@Setup
		public void findResource() throws Exception {
			this.json = BenchmarkBase.class.getClassLoader().getResource(type + "sample.json");
		}
	}

	@State(Scope.Thread)
	public static abstract class SerializerBenchmarkBase<T> extends BenchmarkBase {
		protected T testdata;

		protected abstract TestDataSupplier<T> newSupplier();

		@Setup
		public void make() {
			this.testdata = newSupplier().apply(this.type);
		}
	}

	public static void runForDebug(Class<?> clazz) throws Exception {
		Options options = new OptionsBuilder()
				.include(clazz.getCanonicalName())
				.warmupIterations(2)
				.measurementIterations(2)
				.forks(2)
				.build();
		new Runner(options).run();
	}

	public static void main(String[] args) throws Exception {
		Options options = new OptionsBuilder()
				.include(".*Benchmark")
				.warmupIterations(2)
				.measurementIterations(2)
				.forks(2)
				.build();
		new Runner(options).run();
	}
}
