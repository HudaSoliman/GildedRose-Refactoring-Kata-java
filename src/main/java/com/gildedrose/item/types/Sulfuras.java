package com.gildedrose.item.types;

import com.gildedrose.Item;

public class Sulfuras extends Item implements ItemUpdater {

	public Sulfuras(String name, int sellIn, int quality) {
		super(name, sellIn, 80);
	}

	@Override
	public void update() {
		decrementSellIn(this);
		// do nothing..
	}
}
