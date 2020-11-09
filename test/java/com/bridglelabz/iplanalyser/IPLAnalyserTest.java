package com.bridglelabz.iplanalyser;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import com.bridgelabz.csvreader.CensusAnalyserException;
import com.google.gson.Gson;


public class IPLAnalyserTest {
	private static final String MOST_RUNS_PATH = "C:\\Users\\Ibrahim Khaleel\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv" ;
	private static final String MOST_WICKETS_PATH = "C:\\Users\\Ibrahim Khaleel\\eclipse-workspace\\IPLAnalyser\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv" ;

	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumBattingAverage()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedBattingAverage = iplAnalyser.givenRunsAverageSortedDetails(MOST_RUNS_PATH);
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

	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumStrikeRate()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedStrikeRate = iplAnalyser.givenStrikeRateSortedDetails(MOST_RUNS_PATH);
			MostRuns[] mostStrikeRate = new Gson().fromJson( sortedStrikeRate, MostRuns[].class);
         Assert.assertEquals("Ishant Sharma",mostStrikeRate[0].player);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	} catch (IOException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumSix()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedSix = iplAnalyser.givenMaximumSixSortedDetails(MOST_RUNS_PATH);
			MostRuns[] mostSixes = new Gson().fromJson( sortedSix, MostRuns[].class);
         Assert.assertEquals("Andre Russell",mostSixes[0].player);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnMaximumFour()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedFour = iplAnalyser.givenMaximumFourSortedDetails(MOST_RUNS_PATH);
			MostRuns[] mostFour = new Gson().fromJson( sortedFour, MostRuns[].class);
         Assert.assertEquals("Shikhar Dhawan",mostFour[0].player);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBatsmenRunDetails_WhenCalculated_ShouldReturnBetsStrikeRateWithSix()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedStrikeRateWIthSix = iplAnalyser.givenMaximumSixSortedDetails(MOST_RUNS_PATH);
			MostRuns[] mostStrikeRateWithSix = new Gson().fromJson( sortedStrikeRateWIthSix, MostRuns[].class);
         Assert.assertEquals("Andre Russell",mostStrikeRateWithSix[0].player);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBowlingDetails_WhenCalculated_ShouldReturnBestBowlingAverage()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedBowlingAverage = iplAnalyser.givenBestBowlingAverageSort(MOST_WICKETS_PATH);
			MostWickets[] bestBowlingAverage = new Gson().fromJson( sortedBowlingAverage, MostWickets[].class);
			Assert.assertEquals("Krishnappa Gowtham",bestBowlingAverage[0].playerName);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBowlingDetails_WhenCalculated_ShouldReturnBestBowlingStrikeRate()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedBowlingStrikeRate = iplAnalyser.givenBestBowlingStrikeRateSort(MOST_WICKETS_PATH);
			MostWickets[] bestBowlingStrikeRate = new Gson().fromJson( sortedBowlingStrikeRate, MostWickets[].class);
			Assert.assertEquals("Krishnappa Gowtham",bestBowlingStrikeRate[0].playerName);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}

	@Test
	public void givenBowlingDetails_WhenCalculated_ShouldReturnBestEconomyRate()
	{
		 try {
     		IPLAnalyser iplAnalyser = new IPLAnalyser();
			String sortedBowlingEconomyRate = iplAnalyser.givenBestBowlingEconomyRateSort(MOST_WICKETS_PATH);
			MostWickets[] bestBowlingEconomyRate = new Gson().fromJson( sortedBowlingEconomyRate, MostWickets[].class);
			Assert.assertEquals("Ben Cutting", bestBowlingEconomyRate[0].playerName);
		 	} catch (CensusAnalyserException e)
		 	{
		 		e.printStackTrace();
		 	}
	}
}

