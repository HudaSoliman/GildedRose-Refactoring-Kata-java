package com.gildedrose;

import com.gildedrose.item.types.AgedBrie;
import com.gildedrose.item.types.BackstagePasses;
import com.gildedrose.item.types.Conjured;
import com.gildedrose.item.types.Default;
import com.gildedrose.item.types.Sulfuras;

class GildedRose {
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() throws Exception {
		for (Item item : items) {
			updateItem(item);
		}
	}

	private void updateItem(Item item) throws Exception {
		String className = item.getClass().getSimpleName();

		switch (className) {
		case "Default":
			((Default) item).update();
			break;
		case "AgedBrie":
			((AgedBrie) item).update();
			break;
		case "Sulfuras":
			((Sulfuras) item).update();
			break;
		case "BackstagePasses":
			((BackstagePasses) item).update();
			break;
		case "Conjured":
			((Conjured) item).update();
			break;
		default:
			throw new Exception("Unkown item type!" + item.toString());

		}
	}

}