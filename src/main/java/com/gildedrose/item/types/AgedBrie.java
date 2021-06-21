package com.gildedrose.item.types;

import com.gildedrose.Item;

public class AgedBrie extends Item implements ItemUpdater {

	public AgedBrie(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		decrementSellIn(this);

		if (this.sellIn < 0) {
			incrementQuality(this, 2);
		} else {
			incrementQuality(this, 1);
		}
	}
}
