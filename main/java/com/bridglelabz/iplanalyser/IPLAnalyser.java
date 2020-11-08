package com.bridglelabz.iplanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import com.bridgelabz.csvreader.CSVBuilderFactory;
import com.bridgelabz.csvreader.CensusAnalyserException;
import com.bridgelabz.csvreader.ICSVBuilder;
import com.bridgelabz.csvreader.OpenCsvBuilder;
import com.google.gson.Gson;


public class IPLAnalyser {

	List<MostRuns> runsCSVList = null ;
	List<MostWickets> wicketsCSVList = null ;

	public IPLAnalyser() {
		this.runsCSVList = new ArrayList<MostRuns>() ;
		this.wicketsCSVList = new ArrayList<MostWickets>() ;
	}

	public int loadData(String csvFile) throws CensusAnalyserException 
	{
		try
		{
			Reader reader = Files.newBufferedReader(Paths.get(csvFile));
			ICSVBuilder csvBuilderFactory = CSVBuilderFactory.createCSVBuilder();
			runsCSVList = csvBuilderFactory.getCSVFileList(reader, MostRuns.class) ;
			return runsCSVList.size() ;
		} catch (IOException e) {
			throw new CensusAnalyserException("Please enter correct path",
                    					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}
	
	public int loadWicketData(String wicketCSVFile) throws CensusAnalyserException 
	{
		try
		{
			Reader reader = Files.newBufferedReader(Paths.get(wicketCSVFile));
			ICSVBuilder csvBuilderFactory = CSVBuilderFactory.createCSVBuilder();
			wicketsCSVList = csvBuilderFactory.getCSVFileList(reader, MostWickets.class) ;
			return wicketsCSVList.size() ;
		} catch (IOException e) {
			throw new CensusAnalyserException("Please enter correct path",
                    					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}
	}
	

	public String givenRunsAverageSortedDetails(String csvFile) throws CensusAnalyserException, IOException {
		try {
			loadData(csvFile);
	        if (runsCSVList == null || runsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostRuns> iplComparator = Comparator.comparing(ipl -> ipl.average) ;
			this.RunsSort(iplComparator);
		    String sortedRunsJson = new Gson().toJson(this.runsCSVList);
		    return sortedRunsJson;
			
		} catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
		
	}
	
	public String givenStrikeRateSortedDetails(String csvFile ) throws CensusAnalyserException, IOException {
		try {
			loadData(csvFile);
	        if (runsCSVList == null || runsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostRuns> iplComparator = Comparator.comparing(ipl -> ipl.strikeRate) ;
			this.RunsSort(iplComparator);
		    String sortedRunsJson = new Gson().toJson(this.runsCSVList);
		    return sortedRunsJson;
			
		} catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
		
	}

	private void RunsSort(Comparator<MostRuns> iplComparator) {
		for (int index = 0; index < runsCSVList.size(); index++) {
            for (int j_increment = 0; j_increment <runsCSVList.size() - index - 1; j_increment++) {
                MostRuns firtRunsObject = runsCSVList.get(j_increment);
                MostRuns nextRunsObject = runsCSVList.get(j_increment + 1);
                if (iplComparator.compare(firtRunsObject, nextRunsObject) < 0) {
                	runsCSVList.set(j_increment, nextRunsObject);
                	runsCSVList.set(j_increment + 1, firtRunsObject);
                }

            }

        }
		
	}

	public String givenMaximumSixSortedDetails(String csvFile) throws CensusAnalyserException {
		try {
			loadData(csvFile);
	        if (runsCSVList == null || runsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostRuns> iplComparator = Comparator.comparing(ipl -> ipl.six) ;
			this.RunsSort(iplComparator);
		    String sortedRunsJson = new Gson().toJson(this.runsCSVList);
		    return sortedRunsJson;
			
		} catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
		
	}	
	
	public String givenMaximumFourSortedDetails(String csvFile) throws CensusAnalyserException {
		try {
			loadData(csvFile);
	        if (runsCSVList == null || runsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostRuns> iplComparator = Comparator.comparing(ipl -> ipl.fours) ;
			this.RunsSort(iplComparator);
		    String sortedRunsJson = new Gson().toJson(this.runsCSVList);
		    return sortedRunsJson;
			
		} catch (RuntimeException e) {
            		throw new CensusAnalyserException("Please select correct csv file  ",
                    					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
		
	}

	public String givenBestBowlingAverageSort(String wicketCSVFile) throws CensusAnalyserException {
		try {
			loadWicketData(wicketCSVFile);
		 if (wicketsCSVList == null || wicketsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostWickets> iplWicketComparator = Comparator.comparing(iplWicket -> iplWicket.bowlingAverage) ;
			this.WicketSort(iplWicketComparator);
		    String sortedWicketsJson = new Gson().toJson(this.wicketsCSVList);
		    return sortedWicketsJson;
			
		} catch (RuntimeException e) {
         		throw new CensusAnalyserException("Please select correct csv file  ",
                 					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
	}
	

	private void WicketSort(Comparator<MostWickets> iplWicketComparator) {
		for (int index = 0; index < wicketsCSVList.size(); index++) {
            for (int j_increment = 0; j_increment < wicketsCSVList.size() - index - 1; j_increment++) {
                MostWickets firtRunsObject = wicketsCSVList.get(j_increment);
                MostWickets nextRunsObject = wicketsCSVList.get(j_increment + 1);
                if (iplWicketComparator.compare(firtRunsObject, nextRunsObject) < 0) {
                	wicketsCSVList.set(j_increment, nextRunsObject);
                	wicketsCSVList.set(j_increment + 1, firtRunsObject);
                }

            }

        }
		
	}

	public String givenBestBowlingStrikeRateSort(String wicketCSVFile) throws CensusAnalyserException {
		try {
			loadWicketData(wicketCSVFile);
		 if (wicketsCSVList == null || wicketsCSVList.size() == 0) {
	            throw new CensusAnalyserException("NO_CENSUS_DATA", CensusAnalyserException.ExceptionType.UNABLE_TO_PARSE);
	        }			
			Comparator<MostWickets> iplWicketComparator = Comparator.comparing(iplWicket -> iplWicket.bowlingStrikeRate) ;
			this.WicketSort(iplWicketComparator);
		    String sortedWicketsJson = new Gson().toJson(this.wicketsCSVList);
		    return sortedWicketsJson;
			
		} catch (RuntimeException e) {
         		throw new CensusAnalyserException("Please select correct csv file  ",
                 					CensusAnalyserException.ExceptionType.CSV_FILE_INTERNAL_ISSUES);
		}	
	}
}
