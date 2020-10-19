package com.capgemini.indianstatecensusprogram;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class TestStateCensusAnalyser {

	private static final String CENSUS_FILE_PATH = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus.csv";
	public static Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());
	// Counting number of entries to check correct loading of census data
	@Test
	public void testReadCensusData() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		Assert.assertEquals(36, stateCensusAnalyser.readCensusData(CENSUS_FILE_PATH));
		log.info("Successfully read data from File");
	}
}
