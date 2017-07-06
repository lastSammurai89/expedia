package com.expedia.model;


/**
 * Created by odahmos on 7/5/17.
 */
public enum HotelScoresAttributes {
	MAIN("hotelScores"),
	RAWAPPEALSCORE("rawAppealScore"),
	MOVINGAVERAGESCORE("movingAverageScore");


	private String value;

	private HotelScoresAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
