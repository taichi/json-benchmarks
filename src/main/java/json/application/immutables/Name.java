package json.application.immutables;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableName.class)
@JsonDeserialize(as = ImmutableName.class)
public interface Name {

	String first();

	String last();
}
