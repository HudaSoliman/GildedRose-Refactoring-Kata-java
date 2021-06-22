package com.gildedrose.quality;

import com.gildedrose.Item;
import com.gildedrose.ItemType;

public class QualityManager {

	DefaultItemUpdater defaultItemUpdater;
	AgedBrieItemUpdater agedBrieItemUpdater;
	BackstagePassesItemUpdater backstagePassesItemUpdater;
	SulfurasItemUpdater sulfurasItemUpdater;
	ConjuredItemUpdater conjuredItemUpdater;

	public QualityManager() {
		this.defaultItemUpdater = new DefaultItemUpdater();
		this.agedBrieItemUpdater = new AgedBrieItemUpdater();
		this.backstagePassesItemUpdater = new BackstagePassesItemUpdater();
		this.sulfurasItemUpdater = new SulfurasItemUpdater();
		this.conjuredItemUpdater = new ConjuredItemUpdater();
	}

	public void updateItem(Item item) {

		ItemType itemType = ItemType.getItemType(item.name);
		switch (itemType) {
		case AGED_BRIE:
			agedBrieItemUpdater.update(item);
			break;
		case BACKSTAGE_PASSES:
			backstagePassesItemUpdater.update(item);
			break;
		case SULFURAS:
			sulfurasItemUpdater.update(item);
			break;
		case CONJURED:
			conjuredItemUpdater.update(item);
			break;
		case DEFAULT:
			defaultItemUpdater.update(item);
			break;
		default:
			defaultItemUpdater.update(item);
			break;
		}

	}

}
