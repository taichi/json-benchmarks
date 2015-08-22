package json.application.auto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Friend {

	@JsonCreator
	public static Friend create(@JsonProperty("id") int id, @JsonProperty("name") String name) {
		return builder().id(id).name(name).build();
	}

	@JsonProperty
	public abstract int id();

	@JsonProperty
	public abstract String name();

	public static Builder builder() {
		return new AutoValue_Friend.Builder();
	}

	@AutoValue.Builder
	public interface Builder {

		Builder id(int id);

		Builder name(String name);

		Friend build();
	}
}
