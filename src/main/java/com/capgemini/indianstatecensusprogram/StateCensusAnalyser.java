package com.capgemini.indianstatecensusprogram;

import java.io.BufferedReader;
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
	public int readCensusData(String filePath) throws CensusAnalyserException {
		int numOfEntries = 0;
		String[] filePathUnits = filePath.split("[.]");

		// Throwing exception when file type is incorrect
		if (!filePathUnits[filePathUnits.length - 1].equals("csv")) {
			throw new CensusAnalyserException("File type is incorrect", TypeOfException.INCORRECT_FILETYPE_EXCEPTION);
		}
		checkDelimiter(filePath);
		checkHeader(filePath);
		try {
			Reader dataReader = Files.newBufferedReader(Paths.get(filePath));
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

//	Checking header
	public void checkHeader(String filePath) throws CensusAnalyserException {
		try {
			BufferedReader fileReader = Files.newBufferedReader(Paths.get(filePath));
			String header = fileReader.readLine();
			String[] headerUnits = header.split(",");
			if (!(headerUnits[0].equals("State Name") && headerUnits[1].equals("TIN")
					&& headerUnits[2].equals("Population") && headerUnits[0].equals("State Code"))) {
				throw new CensusAnalyserException("Incorrect file header", TypeOfException.INCORRECT_HEADER_EXCEPTION);
			}
		} catch (IOException e) {
			throw new CensusAnalyserException("Incorrect file header", TypeOfException.INCORRECT_HEADER_EXCEPTION);
		}
	}

// Checking delimiter
	public void checkDelimiter(String filePath) throws CensusAnalyserException {
		try {
			BufferedReader pathReader = Files.newBufferedReader(Paths.get(filePath));
			String path;
			while ((path = pathReader.readLine()) != null) {
				String[] pathUnits = path.split(",");
				if (pathUnits.length != 4)
					throw new CensusAnalyserException("File delimiter is incorrect",
							TypeOfException.INCORRECT_DELIMITER_EXCEPTION);
			}
		} catch (Exception e) {
			throw new CensusAnalyserException("File delimiter is incorrect",
					TypeOfException.INCORRECT_DELIMITER_EXCEPTION);
		}
	}
}
