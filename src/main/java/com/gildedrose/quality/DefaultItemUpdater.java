package com.gildedrose.quality;

import com.gildedrose.Item;

public class DefaultItemUpdater implements ItemUpdater {

	protected int qualityMaxValue = 50;
	protected int qualityMinValue = 0;

	protected int updateValueBeforeSellIn = -1;
	protected int updateValueAfterSellIn = -2;

	@Override
	public void update(Item item) {
		decrementSellIn(item);

		if (item.sellIn < 0) {
			updateQuality(item, updateValueAfterSellIn);
		} else {
			updateQuality(item, updateValueBeforeSellIn);
		}

	}

	protected void updateQuality(Item item, int n) {
		item.quality += n;
		if (item.quality > qualityMaxValue) {
			item.quality = qualityMaxValue;
		} else if (item.quality < qualityMinValue) {
			item.quality = qualityMinValue;
		}
	}

	protected void decrementSellIn(Item item) {
		item.sellIn--;
	}

}
