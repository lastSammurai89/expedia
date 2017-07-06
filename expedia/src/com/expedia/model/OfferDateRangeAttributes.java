package com.expedia.model;

/**
 * Created by odahmos on 7/5/17.
 */
public enum OfferDateRangeAttributes {
	MAIN("offerDateRange"),
	TRAVELSTARTDATE("travelStartDate"),
	TRAVELENDDATE("travelEndDate"),
	LENGTHOFSTAY("lengthOfStay");

	private  String value;

	private OfferDateRangeAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
