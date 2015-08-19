package json.application.auto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Name {

	@JsonCreator
	public static Name create(@JsonProperty("first") String first, @JsonProperty("last") String last) {
		return builder().first(first).last(last).build();
	}

	public abstract String first();

	public abstract String last();

	public static Builder builder() {
		return new AutoValue_Name.Builder();
	}

	@AutoValue.Builder
	public interface Builder {

		Builder first(String first);

		Builder last(String last);

		Name build();
	}
}
