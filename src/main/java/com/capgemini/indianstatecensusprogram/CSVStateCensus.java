package com.capgemini.indianstatecensusprogram;

import com.opencsv.bean.CsvBindByName;

public class CSVStateCensus {
	@CsvBindByName(column = "State")
	public String stateName;

	@CsvBindByName(column = "Population")
	public int population;

	@CsvBindByName(column = "AreaInSqKm")
	public int area;

	@CsvBindByName(column = "DensityPerSqKm")
	public int populationDensity;

	@Override
	public String toString() {
		return "INDIANCENSUSCSV{" + "State = " + stateName + " Population = " + population + " AreaInSqKm = " + area
				+ " DensityPerSqKm = " + populationDensity + '}';
	}
}
