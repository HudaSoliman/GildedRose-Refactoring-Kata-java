package com.gildedrose;

import com.gildedrose.quality.QualityManager;

class GildedRose {
	Item[] items;
	
	QualityManager qualityManager;

	public GildedRose(Item[] items) {
		this.items = items;
		qualityManager = new QualityManager();
	}

	public void updateQuality() throws Exception {
		for (Item item : items) {
			updateItem(item);
		}
	}

	private void updateItem(Item item) throws Exception {
		qualityManager.updateItem(item);
	}

}