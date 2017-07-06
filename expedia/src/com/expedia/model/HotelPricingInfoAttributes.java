package com.expedia.model;


/**
 * Created by odahmos on 7/5/17.
 */
public enum HotelPricingInfoAttributes {
	MAIN("hotelPricingInfo"),
	AVERAGEPRICEVALUE("averagePriceValue"),
	TOTALPRICEVALUE("totalPriceValue"),
	ORIGINALPRICEPERNIGHT("originalPricePerNight"),
	HOTELTOTALBASERATE("hotelTotalBaseRate"),
	CURRENCY("currency"),
	HOTELTOTALMANDATORYTAXESANDFEES("hotelTotalMandatoryTaxesAndFees"),
	PERCENTSAVINGS("percentSavings"),
	DRR ("drr");


	private  String value;

	private HotelPricingInfoAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
