package com.gildedrose;

import com.gildedrose.item.types.AgedBrie;
import com.gildedrose.item.types.BackstagePasses;
import com.gildedrose.item.types.Conjured;
import com.gildedrose.item.types.Default;
import com.gildedrose.item.types.Sulfuras;

public interface ItemCreator {

	public static Item createItem(String name, int sellIn, int quality) {

		ItemType itemType = ItemType.getItemType(name);
		Item item;
		switch (itemType) {
		case AGED_BRIE:
			item = new AgedBrie(name, sellIn, quality);
			break;
		case BACKSTAGE_PASSES:
			item = new BackstagePasses(name, sellIn, quality);
			break;
		case SULFURAS:
			item = new Sulfuras(name, sellIn, quality);
			break;
		case DEFAULT:
			item = new Default(name, sellIn, quality);
			break;
		case CONJURED:
			item = new Conjured(name, sellIn, quality);
			break;
		default:
			item = new Default(name, sellIn, quality);
			break;
		}

		return item;

	}
}
