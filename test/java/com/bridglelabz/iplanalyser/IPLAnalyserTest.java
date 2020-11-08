package com.bridglelabz.iplanalyser;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.csvreader.CensusAnalyserException;
import com.google.gson.Gson;


public class IPLAnalyserTest {
	private static final String BATTING_AVERAGE = "C:\\Users\\Ibrahim Khaleel\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv" ;
	
	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumBattingAverage()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedBattingAverage = iplAnalyser.givenSortedDetails(BATTING_AVERAGE);
			MostRuns[] mostBattingAverage = new Gson().fromJson( sortedBattingAverage, MostRuns[].class);
         		Assert.assertEquals("MS Dhoni",mostBattingAverage[0].player);
		 	} catch (CensusAnalyserException e)
		 	{		
		 		e.printStackTrace();
		 	} catch (IOException e) 
		 	{
		 		e.printStackTrace();
		 	}
	}		
}

