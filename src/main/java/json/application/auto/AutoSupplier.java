package json.application.auto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import json.application.TestDataSupplier;

public class AutoSupplier extends TestDataSupplier<Response> {
	@Override
	public Response large() {
		return make(1000);
	}

	@Override
	public Response medium() {
		return make(100);
	}

	@Override
	public Response small() {
		return make(10);
	}

	@Override
	public Response tiny() {
		return make(1);
	}

	public Response make(int times) {
		Response.Builder builder = Response.builder();
		builder.status("success").isRealJson(true);
		List<User> list = new ArrayList<>();
		for (int i = 0; i < times; i++) {
			User.Builder u = User.builder();
			u.id("54e1a2497ec861adfaf279dc");
			u.index(i);
			u.guid("bb1f1b8b-eeb2-41ea-bcb6-a0fec0118696");
			u.isActive(false);
			u.balance("$3,111.24");
			u.pictureUrl("http://placehold.it/32x32");
			u.age(i % 27);
			u.eyeColor("green");

			u.name(Name.builder().first("Lora").last("Peterson").build());
			u.company("ZENTIME");
			u.email("lora.peterson@zentime.tv");
			u.phone("+1 (846) 533-3429");
			u.address("337 Jay Street, Nadine, Alaska, 3511");
			u
					.about("Do id reprehenderit ipsum ullamco nulla cillum. Est cupidatat minim est voluptate pariatur consequat ut aliquip deserunt proident sit officia consectetur tempor. In sunt officia ea elit proident commodo deserunt.\r\n");
			u.registered("Monday, October 13, 2014 11:00 AM");
			u.latitude(-68.438885);
			u.longitude(99.273798);
			u.tags(Arrays.asList("cupidatat", "in", "aliquip", "occaecat", "fugiat", "dolore", "eu"));
			u.range(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
			u.friends(
					Arrays.asList(friend(0, "Holden Huber"), friend(1, "Perry Dawson"), friend(2, "Santiago Lester")));
			u.images(Arrays.asList(image(), image(), image(), image(), image(), image(), image(), image(), image()));
			u.greeting("Hello, Lora! You have 6 unread messages.");
			u.favoriteFruit("banana");

			list.add(u.build());
		}
		builder.users(list);
		return builder.build();
	}

	Friend friend(int id, String name) {
		return Friend.builder().id(id).name(name).build();
	}

	Image image() {
		return image("54e1a2491c441c02dda9e1a2", "<ReferenceError: png is not defined>",
				"http://ourimageserver/ff10e184-ad03-49a5-8776-60d69027a85f",
				"Quis adipisicing aute exercitation veniam aliquip do laboris dolore esse ipsum.");
	}

	Image image(String id, String format, String url, String description) {
		return Image.builder().id(id).format(format).url(url).description(description).build();
	}
}
