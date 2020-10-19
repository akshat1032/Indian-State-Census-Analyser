package com.capgemini.indianstatecensusprogram;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class TestStateCensusAnalyserForStateCode {

	private static final String CODE_FILE_PATH = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCodeData\\IndianStateCode.csv";
	public static Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());

// 	2.1 Counting number of entries to check correct loading of state data
	@Test
	public void testReadStateCodeData() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			Assert.assertEquals(36, stateCensusAnalyser.readCensusData(CODE_FILE_PATH));
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		log.info("Successfully read data from File");
	}

}
