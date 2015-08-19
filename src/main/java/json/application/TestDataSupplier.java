package json.application;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class TestDataSupplier<T> implements Function<String, T> {

	protected Map<String, Supplier<T>> mapping = new HashMap<>();

	public TestDataSupplier() {
		this.mapping.put("large", this::large);
		this.mapping.put("medium", this::medium);
		this.mapping.put("small", this::small);
		this.mapping.put("tiny", this::tiny);
	}

	@Override
	public T apply(String t) {
		return this.mapping.get(t).get();
	}

	public abstract T large();

	public abstract T medium();

	public abstract T small();

	public abstract T tiny();

}
