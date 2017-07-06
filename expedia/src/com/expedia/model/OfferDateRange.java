package com.expedia.model;

import java.util.Calendar;
import java.util.Date;

import org.json.simple.JSONArray;

public class OfferDateRange {
	
	public OfferDateRange( JSONArray travelStartDateJson,JSONArray travelEndDatJson,Long lengthOfStay){
		this.travelStartDate = convertJsonArrayDateToObj(travelStartDateJson);
		this.travelEndDate = convertJsonArrayDateToObj(travelEndDatJson);
		this.lengthOfStay = lengthOfStay;
		
	}
	
	public Date convertJsonArrayDateToObj(JSONArray jsonDate) {
		
		if(jsonDate != null && jsonDate.size() == 3){
			try{
				Calendar cal = Calendar.getInstance();
				cal.set((int)(long)(Long)jsonDate.get(0),(int)(long)(Long)jsonDate.get(1),(int)(long)(Long)jsonDate.get(2));
				return cal.getTime();
			}catch(Exception err){
			  err.printStackTrace();
			}
			
		}
		return null;
	}
	
	public Date getTravelStartDate() {
		return travelStartDate;
	}
	public void setTravelStartDate(Date travelStartDate) {
		this.travelStartDate = travelStartDate;
	}
	public Date getTravelEndDate() {
		return travelEndDate;
	}
	public void setTravelEndDate(Date travelEndDate) {
		this.travelEndDate = travelEndDate;
	}
	public Long getLengthOfStay() {
		return lengthOfStay;
	}
	public void setLengthOfStay(Long lengthOfStay) {
		this.lengthOfStay = lengthOfStay;
	}
	private Date travelStartDate;
	private Date travelEndDate;
	private Long lengthOfStay;
	private  JSONArray travelStartDateJson;
	public JSONArray getTravelStartDateJson() {
		return travelStartDateJson;
	}
	public void setTravelStartDateJson(JSONArray travelStartDateJson) {
		this.travelStartDateJson = travelStartDateJson;
	}
	public JSONArray getTravelEndDatJson() {
		return travelEndDatJson;
	}
	public void setTravelEndDatJson(JSONArray travelEndDatJson) {
		this.travelEndDatJson = travelEndDatJson;
	}
	private   JSONArray travelEndDatJson;

}
