package com.capgemini.indianstatecensusprogram;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

// Load census data 
public class TestStateCensusAnalyser {
	private static final String CENSUS_FILE_PATH = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus.csv";

	@Test
	public void testReadCensusData() {

		try {
			CSVStateCensus csvStateCensusObject = new CSVStateCensus();
			int noOfEntries = csvStateCensusObject.readCensusData(CENSUS_FILE_PATH);
		} catch (Exception e) {}
	}
}
