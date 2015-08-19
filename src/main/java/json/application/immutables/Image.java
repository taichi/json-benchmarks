package json.application.immutables;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableImage.class)
@JsonDeserialize(as = ImmutableImage.class)
public interface Image {

	String id();

	String format();

	String url();

	String description();

}
