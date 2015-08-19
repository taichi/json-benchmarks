package json.application.pojo;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

@JsonObject
public class User {

	@SerializedName("_id") // for GSON
	@org.boon.json.annotations.SerializedName("_id") // for Boon
	@JsonProperty("_id") // for Jackson Databind
	@JsonField(name = "_id")
	public String id;

	@JsonField
	public int index;

	@JsonField
	public String guid;

	@SerializedName("is_active") // for GSON
	@org.boon.json.annotations.SerializedName("is_active") // for Boon
	@JsonProperty("is_active") // for Jackson Databind
	@JsonField(name = "is_active")
	public boolean isActive;

	@JsonField
	public String balance;

	@SerializedName("picture") // for GSON
	@org.boon.json.annotations.SerializedName("picture") // for Boon
	@JsonProperty("picture") // for Jackson Databind
	@JsonField(name = "picture")
	public String pictureUrl;

	@JsonField
	public int age;

	@JsonField
	public Name name;

	@JsonField
	public String company;

	@JsonField
	public String email;

	@JsonField
	public String address;

	@JsonField
	public String about;

	@JsonField
	public String registered;

	@JsonField
	public double latitude;

	@JsonField
	public double longitude;

	@JsonField
	public String[] tags;

	@JsonField
	public Integer[] range;

	@JsonField
	public Friend[] friends;

	@JsonField
	public Image[] images;

	@JsonField
	public String greeting;

	@SerializedName("favorite_fruit") // for GSON
	@org.boon.json.annotations.SerializedName("favorite_fruit") // for Boon
	@JsonProperty("favorite_fruit") // for Jackson Databind
	@JsonField(name = "favorite_fruit")
	public String favoriteFruit;

	@SerializedName("eye_color") // for GSON
	@org.boon.json.annotations.SerializedName("eye_color") // for Boon
	@JsonProperty("eye_color") // for Jackson Databind
	@JsonField(name = "eye_color")
	public String eyeColor;

	@JsonField
	public String phone;
}
