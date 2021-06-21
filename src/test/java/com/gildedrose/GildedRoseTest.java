package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GildedRoseTest {
	private static final String AGED_BRIE = "Aged Brie";
	private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
	private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
	private static final String DEFAULT_VALUE = "any item";
	private static final String CONJURED_VALUE = "Conjured...";

	private GildedRose prepareTest(String itemName, int itemQuality, int itemSellIn) {
		final Item[] items = new Item[] { ItemCreator.createItem(itemName, itemSellIn, itemQuality) };
		return new GildedRose(items);
	}

	/*
	 * 
	 * Testing quality attributes test cases
	 * 
	 */
	@Test
	void whenDefaultAndNonNegativeSellInShouldDecrementQualityBy1() throws Exception {
		// prepare
		final int quality = 50;
		final int sellIn = 2;
		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(quality - 1, app.items[0].quality);
	}

	@Test
	void whenDefaultShouldQualityNotBeLessThanZero() throws Exception {
		// prepare
		final int quality = 0;
		final int sellIn = 2;
		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void whenDefaultItemQualityDecrementBy2() throws Exception {
		// prepare
		final int quality = 50;
		final int sellIn = 0;
		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);

		app.updateQuality();

		assertEquals(quality - 2, app.items[0].quality);
	}

	@Test
	void whenDefaultItemshouldQualitybeNonZero() throws Exception {
		// prepare
		final int quality = 0;
		final int sellIn = 0;
		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}

	@Test
	void whenSulfurasAndPositiveSellInShouldQualityInchanged() throws Exception {
		// prepare
		final int quality = 80;
		final int sellIn = 1000;
		final GildedRose app = prepareTest(SULFURAS, quality, sellIn);
		app.updateQuality();

		assertEquals(quality, app.items[0].quality);
	}

	@Test
	void whenSulfurasAndNegativeSellInShouldQualityInchanged() throws Exception {
		// prepare
		final int quality = 80;
		final int sellIn = -1000;
		final GildedRose app = prepareTest(SULFURAS, quality, sellIn);
		app.updateQuality();

		assertEquals(quality, app.items[0].quality);
	}

	@Test
	void whenAgedBrieAndPositiveSellInShouldQualityIncrementBy1() throws Exception {
		final int quality = 0;
		final int sellIn = 2;

		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);
		app.updateQuality();

		assertEquals(quality + 1, app.items[0].quality);
	}

	@Test
	void whenAgedBrieAndSellInIsNegativeShouldQualityIncrementBy2() throws Exception {
		final int quality = 1;
		final int sellIn = 0;

		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);
		app.updateQuality();

		assertEquals(quality + 2, app.items[0].quality);
	}

	@Test
	void whenAgedBrieShouldQualityMax50() throws Exception {
		final int quality = 49;
		final int sellIn = 0;

		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);
		app.updateQuality();

		assertEquals(50, app.items[0].quality);
	}

	@Test
	void whenAgedBrieAndQualityIsMaxShouldQualityMax50() throws Exception {
		final int quality = 50;
		final int sellIn = 1;

		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);
		app.updateQuality();

		assertEquals(50, app.items[0].quality);
	}

	@Test
	void whenBackstagePassesAndSellInLessThan5ShouldQualityIncrementBy3() throws Exception {
		final int quality = 1;
		final int sellIn = 5;

		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);
		app.updateQuality();

		assertEquals(quality + 3, app.items[0].quality);
	}

	@Test
	void whenBackstagePassesAndSellInLessThan10ShouldQualityIncrementBy2() throws Exception {
		final int quality = 1;
		final int sellIn = 7;

		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);
		app.updateQuality();

		assertEquals(quality + 2, app.items[0].quality);
	}

	@Test
	void whenBackstagePassesShouldQualityIncrementBy1() throws Exception {
		final int quality = 1;
		final int sellIn = 15;

		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);
		app.updateQuality();

		assertEquals(quality + 1, app.items[0].quality);
	}

	@Test
	void whenBackstagePassesShouldQualityMax50() throws Exception {
		final int quality = 50;
		final int sellIn = 11;

		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);
		app.updateQuality();

		assertEquals(50, app.items[0].quality);
	}

	@Test
	void whenBackstagePassesAndSellInIsNegativeThenQualityIsZero() throws Exception {
		final int quality = 10;
		final int sellIn = 0;

		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);

		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}

	@Test
	void whenConjuredAndNonNegativeSellInShouldDecrementQualityBy2() throws Exception {
		// prepare
		final int quality = 50;
		final int sellIn = 2;
		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(quality - 2, app.items[0].quality);
	}

	@Test
	void whenConjuredShouldQualityNotBeLessThanZero() throws Exception {
		// prepare
		final int quality = 0;
		final int sellIn = 2;
		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(0, app.items[0].quality);
	}

	@Test
	void whenDefaultItemQualityDecrementBy4() throws Exception {
		// prepare
		final int quality = 50;
		final int sellIn = 0;
		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);

		app.updateQuality();

		assertEquals(app.items[0].quality, quality - 4);
	}

	@Test
	void whenConjuredItemshouldQualitybeNonZero() throws Exception {
		// prepare
		final int quality = 0;
		final int sellIn = 0;
		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(0, app.items[0].quality);
	}

	/*
	 * 
	 * Testing sellIn attributes test cases
	 * 
	 */

	@Test
	void whenDefaultItemAndSellInPositiveShouldSellInDecrementBy1() throws Exception {
		final int quality = 0;
		final int sellIn = 2;

		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenDefaultItemAndSellInNegativeShouldSellInDecrementBy1() throws Exception {
		final int quality = 50;
		final int sellIn = 2;

		final GildedRose app = prepareTest(DEFAULT_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenSulfurasAndPositiveSellInShouldSellInNotchanged() throws Exception {
		final int quality = 80;
		final int sellIn = 1000;

		final GildedRose app = prepareTest(SULFURAS, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn, app.items[0].sellIn);
	}

	@Test
	void whenSulfurasAndNegativeSellInShouldSellInNotChanged() throws Exception {
		final int quality = 80;
		final int sellIn = -1000;

		final GildedRose app = prepareTest(SULFURAS, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn, app.items[0].sellIn);
	}

	@Test
	void whenAgedBrieAndPositiveSellInShouldSellInDecrementBy1P1() throws Exception {
		// prepare
		final int quality = 1;
		final int sellIn = 1;
		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenAgedBrieAndNeativeSellInShouldSellInDecrementBy1() throws Exception {
		// prepare
		final int quality = 1;
		final int sellIn = 0;
		final GildedRose app = prepareTest(AGED_BRIE, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenBackstagePassesAndSellInIsPositiveShouldSellInDecrementBy1() throws Exception {
		// prepare
		final int quality = 1;
		final int sellIn = 1;
		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);

		// action
		app.updateQuality();

		// Test
		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenBackstagePassesAndSellInIsNegativeShouldSellInDecrementBy1() throws Exception {
		// prepare
		final int quality = 1;
		final int sellIn = 0;
		final GildedRose app = prepareTest(BACKSTAGE_PASSES, quality, sellIn);

		// action
		app.updateQuality();

		// test
		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenConjuredItemAndSellInPositiveShouldSellInDecrementBy1() throws Exception {
		final int quality = 0;
		final int sellIn = 2;

		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

	@Test
	void whenConjuredItemAndSellInNegativeShouldSellInDecrementBy1() throws Exception {
		final int quality = 50;
		final int sellIn = 2;

		final GildedRose app = prepareTest(CONJURED_VALUE, quality, sellIn);
		app.updateQuality();

		assertEquals(sellIn - 1, app.items[0].sellIn);
	}

}