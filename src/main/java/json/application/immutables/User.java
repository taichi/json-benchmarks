package json.application.immutables;

import java.util.List;

import org.immutables.gson.Gson;
import org.immutables.moshi.Json;
import org.immutables.value.Value;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableUser.class)
@JsonDeserialize(as = ImmutableUser.class)
public interface User {

	@JsonProperty("_id")
	@Gson.Named("_id")
	@Json.Named("_id")
	String id();

	int index();

	String guid();

	@JsonProperty("is_active")
	@Gson.Named("is_active")
	@Json.Named("is_active")
	boolean isActive();

	String balance();

	@JsonProperty("picture")
	@Gson.Named("picture")
	@Json.Named("picture")
	String pictureUrl();

	int age();

	Name name();

	String company();

	String email();

	String address();

	String about();

	String registered();

	double latitude();

	double longitude();

	List<String> tags();

	List<Integer> range();

	List<Friend> friends();

	List<Image> images();

	String greeting();

	@JsonProperty("favorite_fruit")
	@Gson.Named("favorite_fruit")
	@Json.Named("favorite_fruit")
	String favoriteFruit();

	@JsonProperty("eye_color")
	@Gson.Named("eye_color")
	@Json.Named("eye_color")
	String eyeColor();

	String phone();
}
