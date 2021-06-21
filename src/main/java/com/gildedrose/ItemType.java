package com.gildedrose;

import java.util.Optional;
import java.util.stream.Stream;

public enum ItemType {
	AGED_BRIE("Aged Brie"), BACKSTAGE_PASSES("Backstage passes"), SULFURAS("Sulfuras"), CONJURED("Conjured"),
	DEFAULT("*");

	private String type;

	private ItemType(String type) {
		this.type = type;
	}

	public static ItemType getItemType(String name) {

		Optional<ItemType> type = Stream.of(ItemType.values())
				.filter(i -> !i.equals(ItemType.DEFAULT) && isMatchingType(name, i.type)).findFirst();

		return type.isPresent() ? type.get() : DEFAULT;
	}

	private static boolean isMatchingType(String name, String type) {
		return name.toLowerCase().matches("^" + type.toLowerCase() + ".*$");
	}
}
