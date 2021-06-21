package com.gildedrose.item.types;

import com.gildedrose.Item;

public class BackstagePasses extends Item implements ItemUpdater {

	static final int SELLIN_LIMIT2 = 10;
	static final int SELLIN_LIMIT3 = 5;

	public BackstagePasses(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	@Override
	public void update() {
		decrementSellIn(this);

		if (sellIn < 0) {
			quality = 0;
		} else if (sellIn <= SELLIN_LIMIT3) {
			incrementQuality(this, 3);
		} else if (sellIn <= SELLIN_LIMIT2) {
			incrementQuality(this, 2);
		} else {
			incrementQuality(this, 1);
		}
	}
}
