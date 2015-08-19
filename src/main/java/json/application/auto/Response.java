package json.application.auto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Response {

	@JsonCreator
	public static Response create(@JsonProperty("users") List<User> users,
			@JsonProperty("status") String status,
			@JsonProperty("is_real_json") boolean is_real_json) {
		return Response.builder().users(users).status(status).isRealJson(is_real_json).build();
	}

	@JsonProperty
	public abstract List<User> users();

	@JsonProperty
	public abstract String status();

	@JsonProperty("is_real_json")
	public abstract boolean isRealJson();

	public static Builder builder() {
		return new AutoValue_Response.Builder();
	}

	@AutoValue.Builder
	public interface Builder {

		Builder users(List<User> users);

		Builder status(String status);

		Builder isRealJson(boolean is);

		Response build();
	}

}
