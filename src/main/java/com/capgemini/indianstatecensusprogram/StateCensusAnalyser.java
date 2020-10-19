package com.capgemini.indianstatecensusprogram;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.capgemini.indianstatecensusprogram.CensusAnalyserException.TypeOfException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser {

//	Read census data from file
	public int readCensusData(String censusFilePath) throws CensusAnalyserException {
		int numOfEntries = 0;
		String[] filePathUnits = censusFilePath.split("[.]");
		if (!filePathUnits[filePathUnits.length-1].equals("csv")) {
			throw new CensusAnalyserException("File type is incorrect", TypeOfException.INCORRECT_FILETYPE_EXCEPTION);
		}
		try {
			Reader dataReader = Files.newBufferedReader(Paths.get(censusFilePath));
			CsvToBean<CSVStateCensus> csvToBeanObject = new CsvToBeanBuilder(dataReader).withType(CSVStateCensus.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			final Iterator<CSVStateCensus> indianStateCensusDataIterator = csvToBeanObject.iterator();
			Iterable<CSVStateCensus> indianStateCensusDataIterable = () -> indianStateCensusDataIterator;
			numOfEntries = (int) StreamSupport.stream(indianStateCensusDataIterable.spliterator(), false).count();
		} catch (IOException e) {
			throw new CensusAnalyserException("Incorrect file name/path", TypeOfException.INCORRECT_FILE_EXCEPTION);
		}
		return numOfEntries;
	}
}
