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

	@JsonProperty
	public abstract int index();

	@JsonProperty
	public abstract String guid();

	@JsonProperty("is_active")
	public abstract boolean isActive();

	@JsonProperty
	public abstract String balance();

	@JsonProperty("picture")
	public abstract String pictureUrl();

	@JsonProperty
	public abstract int age();

	@JsonProperty
	public abstract Name name();

	@JsonProperty
	public abstract String company();

	@JsonProperty
	public abstract String email();

	@JsonProperty
	public abstract String address();

	@JsonProperty
	public abstract String about();

	@JsonProperty
	public abstract String registered();

	@JsonProperty
	public abstract double latitude();

	@JsonProperty
	public abstract double longitude();

	@JsonProperty
	public abstract List<String> tags();

	@JsonProperty
	public abstract List<Integer> range();

	@JsonProperty
	public abstract List<Friend> friends();

	@JsonProperty
	public abstract List<Image> images();

	@JsonProperty
	public abstract String greeting();

	@JsonProperty("favorite_fruit")
	public abstract String favoriteFruit();

	@JsonProperty("eye_color")
	public abstract String eyeColor();

	@JsonProperty
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
