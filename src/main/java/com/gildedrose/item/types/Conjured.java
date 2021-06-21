package com.gildedrose.item.types;

import com.gildedrose.Item;

public class Conjured extends Item implements ItemUpdater {

	public Conjured(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		decrementSellIn(this);

		if (sellIn >= 0) {
			decrementQuality(this, 2);
		} else {
			decrementQuality(this, 4);
		}
	}
}
