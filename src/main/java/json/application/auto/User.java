package json.application.auto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class User {

	@JsonCreator
	public static User create(@JsonProperty("_id") String id,
			@JsonProperty("index") int index,
			@JsonProperty("guid") String guid,
			@JsonProperty("is_active") boolean isActive,
			@JsonProperty("balance") String balance,
			@JsonProperty("picture") String pictureUrl,
			@JsonProperty("age") int age,
			@JsonProperty("name") Name name,
			@JsonProperty("company") String company,
			@JsonProperty("email") String email,
			@JsonProperty("address") String address,
			@JsonProperty("about") String about,
			@JsonProperty("registered") String registered,
			@JsonProperty("latitude") double latitude,
			@JsonProperty("longitude") double longitude,
			@JsonProperty("tags") List<String> tags,
			@JsonProperty("range") List<Integer> range,
			@JsonProperty("friends") List<Friend> friends,
			@JsonProperty("images") List<Image> images,
			@JsonProperty("greeting") String greeting,
			@JsonProperty("favorite_fruit") String favoriteFruit,
			@JsonProperty("eye_color") String eyeColor,
			@JsonProperty("phone") String phone) {
		return builder()
				.id(id)
				.index(index)
				.guid(guid)
				.isActive(isActive)
				.balance(balance)
				.pictureUrl(pictureUrl)
				.age(age)
				.name(name)
				.company(company)
				.email(email)
				.address(address)
				.about(about)
				.registered(registered)
				.latitude(latitude)
				.longitude(longitude)
				.tags(tags)
				.range(range)
				.friends(friends)
				.images(images)
				.greeting(greeting)
				.favoriteFruit(favoriteFruit)
				.eyeColor(eyeColor)
				.phone(phone)
				.build();

	}

	@JsonProperty("_id")
	public abstract String id();

	public abstract int index();

	public abstract String guid();

	@JsonProperty("is_active")
	public abstract boolean isActive();

	public abstract String balance();

	@JsonProperty("picture")
	public abstract String pictureUrl();

	public abstract int age();

	public abstract Name name();

	public abstract String company();

	public abstract String email();

	public abstract String address();

	public abstract String about();

	public abstract String registered();

	public abstract double latitude();

	public abstract double longitude();

	public abstract List<String> tags();

	public abstract List<Integer> range();

	public abstract List<Friend> friends();

	public abstract List<Image> images();

	public abstract String greeting();

	@JsonProperty("favorite_fruit")
	public abstract String favoriteFruit();

	@JsonProperty("eye_color")
	public abstract String eyeColor();

	public abstract String phone();

	public static Builder builder() {
		return new AutoValue_User.Builder();
	}

	@AutoValue.Builder
	public interface Builder {

		Builder id(String id);

		Builder index(int index);

		Builder guid(String guid);

		Builder isActive(boolean isActive);

		Builder balance(String balance);

		Builder pictureUrl(String pictureUrl);

		Builder age(int age);

		Builder name(Name name);

		Builder company(String company);

		Builder email(String email);

		Builder address(String address);

		Builder about(String about);

		Builder registered(String registered);

		Builder latitude(double latitude);

		Builder longitude(double longitude);

		Builder tags(List<String> tags);

		Builder range(List<Integer> range);

		Builder friends(List<Friend> friends);

		Builder images(List<Image> images);

		Builder greeting(String greeting);

		Builder favoriteFruit(String favoriteFruit);

		Builder eyeColor(String eyeColor);

		Builder phone(String phone);

		User build();

	}
}
