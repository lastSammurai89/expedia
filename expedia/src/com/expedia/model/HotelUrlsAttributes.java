package com.expedia.model;

/**
 * Created by odahmos on 7/5/17.
 */
public enum HotelUrlsAttributes {
	HOTELURLS("hotelUrls"),
	HOTELINFOSITEURL("hotelInfositeUrl"),
	HOTELSEARCHRESULTURL("hotelSearchResultUrl");

	private  String value;

	private HotelUrlsAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
