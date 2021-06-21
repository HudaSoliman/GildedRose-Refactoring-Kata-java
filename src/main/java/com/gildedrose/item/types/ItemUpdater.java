package com.gildedrose.item.types;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public interface ItemUpdater {

	static final int QUALITY_MAX_VALUE = 50;

	public void update();

	public default void incrementQuality(Item item, int n) {
		if (item.quality + n <= QUALITY_MAX_VALUE) {
			item.quality += n;
		} else {
			item.quality = QUALITY_MAX_VALUE;
		}
	}

	public default void decrementQuality(Item item, int n) {
		if (item.quality - n >= 0) {
			item.quality -= n;
		} else {
			item.quality = 0;
		}
	}

	public default void decrementSellIn(Item item) {
		if (!ItemType.getItemType(item.name).equals(ItemType.SULFURAS)) {
			item.sellIn--;
		}
	}
}
