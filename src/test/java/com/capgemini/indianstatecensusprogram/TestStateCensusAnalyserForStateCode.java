package com.capgemini.indianstatecensusprogram;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.capgemini.indianstatecensusprogram.CensusAnalyserException.TypeOfException;

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
	
//	TC 2.2 Throwing exception when file name is incorrect
	@Test
	public void testThrowExceptionForIncorrectFileName() {
		try {
			String filePath =  "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCodeData\\IndianStateCodee.csv";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.readCensusData(filePath);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(TypeOfException.INCORRECT_FILE_EXCEPTION, e.getTypeOfException());
			log.info("Successfully tested exception thrown when file name/path is incorrect");
		}
	}
	
//	TC 2.3 Throwing exception when file type is incorrect
	@Test
	public void testThrowExceptionForIncorrectFileType() {
		try {
			String filePath = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCodeData\\IndianStateCode.txt";
			StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
			stateCensusAnalyser.readCensusData(filePath);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(TypeOfException.INCORRECT_FILETYPE_EXCEPTION, e.getTypeOfException());
			log.info("Successfully tested exception thrown when file type is incorrect");
		}
	}

}
