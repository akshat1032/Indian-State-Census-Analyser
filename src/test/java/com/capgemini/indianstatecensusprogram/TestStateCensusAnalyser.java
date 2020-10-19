package com.capgemini.indianstatecensusprogram;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.indianstatecensusprogram.CensusAnalyserException.TypeOfException;

public class TestStateCensusAnalyser {

	private static final String CENSUS_FILE_PATH = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus.csv";
	public static Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());

// 	Counting number of entries to check correct loading of census data
	@Test
	public void testReadCensusData() {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		try {
			Assert.assertEquals(36, stateCensusAnalyser.readCensusData(CENSUS_FILE_PATH));
		} catch (CensusAnalyserException e) {
			e.printStackTrace();
		}
		log.info("Successfully read data from File");
	}

//	TC 1.2 Throwing exception when file name is incorrect
	@Test
	public void testThrowExceptionForIncorrectFileName() {
		try {
			String filePath = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus2011.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.readCensusData(filePath);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(TypeOfException.INCORRECT_FILE_EXCEPTION, e.getTypeOfException());
			log.info("Successfully tested exception thrown when file name/path is incorrect");
		}
	}

//	TC 1.3 Throwing exception when file type is incorrect
	@Test
	public void testThrowExceptionForIncorrectFileType() {
		try {
			String filePath = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus.txt";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.readCensusData(filePath);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(TypeOfException.INCORRECT_FILETYPE_EXCEPTION, e.getTypeOfException());
			log.info("Successfully tested exception thrown when file type is incorrect");
		}
	}
}
