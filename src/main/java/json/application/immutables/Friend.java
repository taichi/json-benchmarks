package json.application.immutables;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableFriend.class)
@JsonDeserialize(as = ImmutableFriend.class)
public interface Friend {

	int id();

	String name();
}
