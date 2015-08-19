package json.benchmark;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;

import com.bluelinelabs.logansquare.LoganSquare;

import json.application.TestDataSupplier;
import json.application.pojo.PojoSupplier;
import json.application.pojo.Response;
import json.benchmark.BenchmarkBase.ParserBenchmarkBase;
import json.benchmark.BenchmarkBase.SerializerBenchmarkBase;

public class LoganSquareBenchmark {

	public static class ParserBenchmark extends ParserBenchmarkBase {
		@Benchmark
		public Response stream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return LoganSquare.parse(in, Response.class);
			}
		}

		@Benchmark
		@SuppressWarnings("rawtypes")
		public Map parse2Map() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return LoganSquare.parse(in, Map.class);
			}
		}

		@Benchmark
		public Response bufferdStream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return LoganSquare.parse(new BufferedInputStream(in), Response.class);
			}
		}
	}

	public static class SerializerBenchmark extends SerializerBenchmarkBase<Response> {

		@Override
		protected TestDataSupplier<Response> newSupplier() {
			return new PojoSupplier();
		}

		@Benchmark
		public String string() throws Exception {
			return LoganSquare.serialize(this.testdata);
		}
	}

	public static void main(String[] args) throws Exception {
		BenchmarkBase.runForDebug(LoganSquareBenchmark.class);
	}
}
