package com.capgemini.indianstatecensusprogram;

import com.opencsv.bean.CsvBindByName;

public class CSVStates {
	@CsvBindByName(column = "State Name")
	public String stateName;

	@CsvBindByName(column = "TIN")
	public int tin;

	@CsvBindByName(column = "Population")
	public int population;

	@CsvBindByName(column = "State Code")
	public String stateCode;

	@Override
	public String toString() {
		return "INDIANCENSUSCSV{" + "State = " + stateName + " TIN = " + tin + " Population = " + population
				+ " State Code = " + stateCode + '}';
	}
}
