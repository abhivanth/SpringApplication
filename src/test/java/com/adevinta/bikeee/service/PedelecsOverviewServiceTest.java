package com.adevinta.bikeee.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedelecsOverviewServiceTest {

	private PedelecsMockDataProvider pedelecsMockDataProvider = new PedelecsMockDataProvider();
	private PedelecsOverviewService pedelecsOverviewService = new PedelecsOverviewService(pedelecsMockDataProvider);

	@Test
	void testWhetherTopThreeRecordsAreRankedSuccessfully() throws IOException {
		PedelecsMockDataProvider.PEDELECS_DB_FILE_NAME = "pedelecs_test1.csv";
		pedelecsMockDataProvider.loadData();
		List<PedelecOverviewRecord> topThreeRecords = pedelecsOverviewService.getTopThree();
		//only top three returned
		assertEquals(3, topThreeRecords.size());
		// top ranked record
		assertEquals("Gudereit", topThreeRecords.get(0).getMake());
		assertEquals("ec-5", topThreeRecords.get(0).getModel());
		assertEquals(4, topThreeRecords.get(0).getCount());
		//second record
		assertEquals("Diamant", topThreeRecords.get(1).getMake());
		assertEquals("Juna", topThreeRecords.get(1).getModel());
		assertEquals(3, topThreeRecords.get(1).getCount());
		//Third record
		assertEquals("Diamant", topThreeRecords.get(2).getMake());
		assertEquals("Beryll", topThreeRecords.get(2).getModel());
		assertEquals(2, topThreeRecords.get(2).getCount());
	}

	@Test
	void testEmptyRecordsReturnedWhenDbIsEmpty() throws IOException {
		PedelecsMockDataProvider.PEDELECS_DB_FILE_NAME = "pedelecs_test2.csv";
		pedelecsMockDataProvider.loadData();
		List<PedelecOverviewRecord> topThreeRecords = pedelecsOverviewService.getTopThree();
		assertEquals(0, topThreeRecords.size());
	}

}