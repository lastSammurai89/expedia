package com.expedia.model;


/**
 * Created by odahmos on 7/5/17.
 */
public class HotelScores {
	private String hotelRawAppealScore;
	private String hotelMovingAverageScore;

	public HotelScores(){

	}

	public String getHotelRawAppealScore() {
		return hotelRawAppealScore;
	}

	public void setHotelRawAppealScore(String hotelRawAppealScore) {
		this.hotelRawAppealScore = hotelRawAppealScore;
	}

	public String getHotelMovingAverageScore() {
		return hotelMovingAverageScore;
	}

	public void setHotelMovingAverageScore(String hotelMovingAverageScore) {
		this.hotelMovingAverageScore = hotelMovingAverageScore;
	}


}
