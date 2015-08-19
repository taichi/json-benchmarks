package json.benchmark;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import json.application.TestDataSupplier;
import json.application.pojo.PojoSupplier;
import json.application.pojo.Response;
import json.benchmark.BenchmarkBase.ParserBenchmarkBase;
import json.benchmark.BenchmarkBase.SerializerBenchmarkBase;
import okio.Okio;

public class MoshiBenchmark {

	public static class ParserBenchmark extends ParserBenchmarkBase {
		@SuppressWarnings("rawtypes")
		JsonAdapter<Map>		mapAdapter;
		JsonAdapter<Response>	adapter;

		@Setup
		public void prepare() {
			Moshi moshi = new Moshi.Builder().build();
			this.mapAdapter = moshi.adapter(Map.class);
			this.adapter = moshi.adapter(Response.class);
		}

		@Benchmark
		public Response stream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return adapter.fromJson(Okio.buffer(Okio.source(in)));
			}
		}

		@Benchmark
		@SuppressWarnings("rawtypes")
		public Map parse2Map() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return mapAdapter.fromJson(Okio.buffer(Okio.source(in)));
			}
		}

		@Benchmark
		public Response bufferdStream() throws Exception {
			try (InputStream in = this.json.openStream()) {
				return adapter.fromJson(Okio.buffer(Okio.source(new BufferedInputStream(in))));
			}
		}
	}

	public static class SerializerBenchmark extends SerializerBenchmarkBase<Response> {

		JsonAdapter<Response> adapter;

		@Setup
		public void prepare() {
			Moshi moshi = new Moshi.Builder().build();
			this.adapter = moshi.adapter(Response.class);
		}

		@Override
		protected TestDataSupplier<Response> newSupplier() {
			return new PojoSupplier();
		}

		@Benchmark
		public String string() throws Exception {
			return this.adapter.toJson(this.testdata);
		}
	}

	public static void main(String[] args) throws Exception {
		BenchmarkBase.runForDebug(MoshiBenchmark.class);
	}
}
