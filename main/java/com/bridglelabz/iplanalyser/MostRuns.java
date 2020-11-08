package com.bridglelabz.iplanalyser;

import com.opencsv.bean.CsvBindByName;

public class MostRuns {
	@CsvBindByName(column = "POS")
	public int pos;
	@CsvBindByName(column = "PLAYER")
	public String player;
	@CsvBindByName(column = "Mat" )
	public long match;
	@CsvBindByName(column = "Inns")
	public int innings;
	@CsvBindByName(column = "NO")
	public int number;
	@CsvBindByName(column = "Runs")
	public int runs;
	@CsvBindByName(column = "HS")
	public double highestscore;
	@CsvBindByName(column = "Avg")
	public double average;
	@CsvBindByName(column = "BF")
	public int ballFaced;
	@CsvBindByName(column = "SR")
	public double strikeRate;
	@CsvBindByName(column = "100")
	public int hundred;
	@CsvBindByName(column = "50")
	public int fifty;
	@CsvBindByName(column = "4s")
	public int fours;
	@CsvBindByName(column = "6s")
	public int six;
	@Override
	public String toString() {
		return "MostRuns [pos=" + pos + ", player=" + player + ", match=" + match + ", innings=" + innings + ", number="
				+ number + ", runs=" + runs + ", highestscore=" + highestscore + ", average=" + average + ", ballFaced="
				+ ballFaced + ", strikeRate=" + strikeRate + ", hundred=" + hundred + ", fifty=" + fifty + ", fours="
				+ fours + ", six=" + six + "]";
	}
	
	

}
