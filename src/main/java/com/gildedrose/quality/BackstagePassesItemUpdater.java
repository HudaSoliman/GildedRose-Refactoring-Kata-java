package com.gildedrose.quality;

import com.gildedrose.Item;

public class BackstagePassesItemUpdater extends DefaultItemUpdater {

	static final int SELLIN_LIMIT_DAYS_1 = 5;
	static final int SELLIN_LIMIT_DAYS_2 = 10;
	
	

	@Override
	public void update(Item item) {
		decrementSellIn(item);

		if (item.sellIn < 0) {
			item.quality = 0;
		} else if (item.sellIn <= SELLIN_LIMIT_DAYS_2) {
			updateQuality(item, 3);
		} else if (item.sellIn <= SELLIN_LIMIT_DAYS_1) {
			updateQuality(item, 2);
		} else {
			updateQuality(item, 1);
		}
	}
}
