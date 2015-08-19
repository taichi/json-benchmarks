package json.benchmark;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;

import json.application.TestDataSupplier;
import json.application.auto.AutoSupplier;
import json.application.auto.Response;
import json.benchmark.BenchmarkBase.ParserBenchmarkBase;
import json.benchmark.BenchmarkBase.SerializerBenchmarkBase;

public class AutoBenchmark {

	public static class ParserBenchmark extends ParserBenchmarkBase {
		ObjectMapper mapper;

		@Setup
		public void prepare() {
			this.mapper = newObjectMapper();
		}

		@Benchmark
		public Response url() throws Exception {
			return this.mapper.readValue(this.json, Response.class);
		}

		@Benchmark
		public Response stream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.mapper.readValue(in, Response.class);
			}
		}

		@Benchmark
		@SuppressWarnings("rawtypes")
		public Map parse2Map() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.mapper.readValue(in, Map.class);
			}
		}

		@Benchmark
		public Response bufferdStream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.mapper.readValue(new BufferedInputStream(in), Response.class);
			}
		}

		@Benchmark
		public Response reader() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.mapper.readValue(new InputStreamReader(in, StandardCharsets.UTF_8), Response.class);
			}
		}

		@Benchmark
		public Response bufferedReader() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return this.mapper.readValue(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)),
						Response.class);
			}
		}
	}

	static ObjectMapper newObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new GuavaModule());
		return mapper;
	}

	public static class SerializerBenchmark extends SerializerBenchmarkBase<Response> {

		ObjectMapper mapper;

		@Setup
		public void prepare() {
			this.mapper = newObjectMapper();
		}

		@Override
		protected TestDataSupplier<Response> newSupplier() {
			return new AutoSupplier();
		}

		@Benchmark
		public String string() throws Exception {
			return this.mapper.writeValueAsString(this.testdata);
		}
	}

	public static void main(String[] args) throws Exception {
		BenchmarkBase.runForDebug(AutoBenchmark.class);
	}
}
