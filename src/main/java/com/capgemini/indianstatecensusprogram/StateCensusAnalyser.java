package com.capgemini.indianstatecensusprogram;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(StateCensusAnalyser.class.getName());

//    	Welcome message added
		log.info("Welcome to Indian State Census Analyser Program!");

		String censusFilePath = "D:\\default-workspace\\IndianStateCensusProgram\\src\\IndianStateCensusData\\IndianStateCensus.csv";
		int numberOfEntries = new StateCensusAnalyser().readCensusData(censusFilePath);
		log.info("Number of entries : " + numberOfEntries);
	}

//	Read census data from file
	public int readCensusData(String censusFilePath) {
		int numOfEntries = 0;
		try {
			Reader dataReader = Files.newBufferedReader(Paths.get(censusFilePath));
			CsvToBean<CSVStateCensus> csvToBeanObject = new CsvToBeanBuilder(dataReader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			final Iterator<CSVStateCensus> indianStateCensusDataIterator = csvToBeanObject.iterator();
			Iterable<CSVStateCensus> indianStateCensusDataIterable = () -> indianStateCensusDataIterator;
			numOfEntries = (int) StreamSupport.stream(indianStateCensusDataIterable.spliterator(), false).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return numOfEntries;
	}
}
