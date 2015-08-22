package json.application.auto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Image {

	@JsonCreator
	public static Image create(@JsonProperty("id") String id,
			@JsonProperty("format") String format,
			@JsonProperty("url") String url,
			@JsonProperty("description") String description) {
		return builder().id(id).format(format).url(url).description(description).build();
	}

	@JsonProperty
	public abstract String id();

	@JsonProperty
	public abstract String format();

	@JsonProperty
	public abstract String url();

	@JsonProperty
	public abstract String description();

	public static Builder builder() {
		return new AutoValue_Image.Builder();
	}

	@AutoValue.Builder
	public interface Builder {

		Builder id(String id);

		Builder format(String format);

		Builder url(String url);

		Builder description(String description);

		Image build();
	}
}
