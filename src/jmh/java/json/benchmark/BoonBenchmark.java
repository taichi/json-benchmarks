package json.benchmark;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.boon.json.JsonParserAndMapper;
import org.boon.json.JsonParserFactory;
import org.boon.json.JsonSerializer;
import org.boon.json.JsonSerializerFactory;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import json.application.TestDataSupplier;
import json.application.pojo.PojoSupplier;
import json.application.pojo.Response;
import json.benchmark.BenchmarkBase.ParserBenchmarkBase;
import json.benchmark.BenchmarkBase.SerializerBenchmarkBase;

public class BoonBenchmark {

	public static class ParserBenchmark extends ParserBenchmarkBase {
		JsonParserAndMapper parser;

		@Setup
		public void prepare() {
			JsonParserFactory factory = new JsonParserFactory();
			this.parser = factory.createFastParser();
		}

		@Benchmark
		public Response stream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.parser.parse(Response.class, in);
			}
		}

		@Benchmark
		@SuppressWarnings("rawtypes")
		public Map parse2Map() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return (Map) this.parser.parse(in);
			}
		}

		@Benchmark
		public Response bufferdStream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.parser.parse(Response.class, new BufferedInputStream(in));
			}
		}

		@Benchmark
		public Response reader() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.parser.parse(Response.class, new InputStreamReader(in, StandardCharsets.UTF_8));
			}
		}

		@Benchmark
		public Response bufferedReader() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.parser.parse(Response.class,
						new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)));
			}
		}
	}

	public static class SerializerBenchmark extends SerializerBenchmarkBase<Response> {

		JsonSerializer serializer;

		@Setup
		public void prepare() {
			this.serializer = new JsonSerializerFactory().setSerializeAsSupport(false).useFieldsOnly().create();
		}

		@Override
		protected TestDataSupplier<Response> newSupplier() {
			return new PojoSupplier();
		}

		@Benchmark
		public CharSequence string() throws Exception {
			return this.serializer.serialize(this.testdata);
		}
	}

	public static void main(String[] args) throws Exception {
		BenchmarkBase.runForDebug(BoonBenchmark.class);
	}
}
