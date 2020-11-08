package com.bridglelabz.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class MostWickets {
	
	@CsvBindByName(column = "POS")
	public int pos;
	@CsvBindByName(column = "PLAYER")
	public String playerName;
	@CsvBindByName(column = "Mat" )
	public long match;
	@CsvBindByName(column = "Inns")
	public int innings;
	@CsvBindByName(column = "Ov")
	public double over;
	@CsvBindByName(column = "Runs")
	public int runs;
	@CsvBindByName(column = "Wkts")
	public double wickets;
	@CsvBindByName(column = "BBI")
	public double bestbowl;
	@CsvBindByName(column = "Avg")
	public double bowlingAverage;
	@CsvBindByName(column = "Econ")
	public double economy;
	@CsvBindByName(column = "SR")
	public double bowlingStrikeRate;
	@CsvBindByName(column = "4w")
	public int fourWickets;
	@CsvBindByName(column = "5w")
	public int fiveWickets;
	@Override
	public String toString() {
		return "MostWickets [pos=" + pos + ", player=" + playerName + ", match=" + match + ", innings=" + innings
				+ ", over=" + over + ", runs=" + runs + ", wickets=" + wickets + ", bestbowl=" + bestbowl
				+ ", bowlingAverage=" + bowlingAverage + ", economy=" + economy + ", bowlingStrikeRate="
				+ bowlingStrikeRate + ", fourWickets=" + fourWickets + ", fiveWickets=" + fiveWickets + "]";
	}
	
	

}
