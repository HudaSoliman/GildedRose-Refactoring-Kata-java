package com.gildedrose;

class GildedRose {
	Item[] items;
	static final int QUALITY_MAX_VALUE = 50;
	static final int BACKSTAGE_PASSES_SELLIN_LIMIT_1 = 10;
	static final int BACKSTAGE_PASSES_SELLIN_LIMIT_2 = 5;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (Item item : items) {
			updateItem(item);
		}
	}

	private void updateItem(Item item) {
		decrementSellIn(item);

		ItemType itemType = ItemType.getItemType(item);
		switch (itemType) {
		case AGED_BRIE:
			updateAgedBrie(item);
			break;
		case BACKSTAGE_PASSES:
			updateBackstagePasses(item);
			break;
		case SULFURAS:
			// do nothing
			break;
		case CONJURED:
			updateConjured(item);
			break;
		default:
			updateDefault(item);
			break;
		}
	}

	private void incrementQuality(Item item, int n) {
		if (item.quality + n <= QUALITY_MAX_VALUE) {
			item.quality += n;
		} else {
			item.quality = QUALITY_MAX_VALUE;
		}
	}

	private void decrementQuality(Item item, int n) {
		if (item.quality - n >= 0) {
			item.quality -= n;
		} else {
			item.quality = 0;
		}
	}

	private void updateAgedBrie(Item item) {
		if (item.sellIn < 0) {
			incrementQuality(item, 2);
		} else {
			incrementQuality(item, 1);
		}
	}

	private void updateConjured(Item item) {
		if (item.sellIn >= 0) {
			decrementQuality(item, 2);
		} else {
			decrementQuality(item, 4);
		}
	}

	private void updateBackstagePasses(Item item) {
		if (item.sellIn < 0) {
			item.quality = 0;
		} else if (item.sellIn <= BACKSTAGE_PASSES_SELLIN_LIMIT_2) {
			incrementQuality(item, 3);
		} else if (item.sellIn <= BACKSTAGE_PASSES_SELLIN_LIMIT_1) {
			incrementQuality(item, 2);
		} else {
			incrementQuality(item, 1);
		}
	}

	private void updateDefault(Item item) {
		if (item.sellIn < 0) {
			decrementQuality(item, 2);
		} else {
			decrementQuality(item, 1);
		}
	}

	private void decrementSellIn(Item item) {
		if (!ItemType.getItemType(item).equals(ItemType.SULFURAS)) {
			item.sellIn--;
		}
	}

}