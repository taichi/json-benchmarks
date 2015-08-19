package json.application.immutables;

import java.util.List;

import org.immutables.gson.Gson;
import org.immutables.moshi.Json;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableResponse.class)
@JsonDeserialize(as = ImmutableResponse.class)
public interface Response {

	List<User> users();

	String status();

	@JsonProperty("is_real_json")
	@Gson.Named("is_real_json")
	@Json.Named("is_real_json")
	boolean isRealJson();

}
