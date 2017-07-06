package com.expedia.model;

/**
 * Created by odahmos on 7/5/17.
 */
public enum HotelInfoAttribute {
	MAIN("hotelInfo"),
	HOTELID("hotelId"),
	HOTELNAME("hotelName"),
	HOTELDESTINATION("hotelDestination"),
	HOTELDESTINATIONREGIONID("hotelDestinationRegionID"),
	HOTELLONGDESTINATION("hotelLongDestination"),
	HOTELSTREETADDRESS("hotelStreetAddress"),
	HOTELCITY("hotelCity"),
	HOTELPROVINCE("hotelProvince"),
	HOTELCOUNTRYCODE("hotelCountryCode"),
	HOTELLOCATION("hotelLocation"),
	HOTELLATITUDE("hotelLatitude"),
	HOTELLONGITUDE("hotelLongitude"),
	HOTELSTARRATING( "hotelStarRating"),
	HOTELGUESTREVIEWRATING("hotelGuestReviewRating"),
	HOTELINFOTRAVELSTARTDATE("hotelInfotravelStartDate"),
	HOTELINFOTRAVELENDDATE("hotelInfotravelEndDate"),
	HOTELIMAGEURL("hotelImageUrl"),
	CARPACKAGESCORE("carPackageScore"),
	DESCRIPTION("description"),
	DISTANCEFROMUSER("distanceFromUser"),
	LANGUAGE("language"),
	MOVINGAVERAGESCORE("movingAverageScore"),
	PROMOTIONAMOUNT("promotionAmount"),
	PROMOTIONDESCRIPTION("promotionDescription"),
	PROMOTIONTAG("promotionTag"),
	RAWAPPEALSCORE("rawAppealScore"),
	RELEVANCESCORE("relevanceScore"),
	STATUSCODE("statusCode"),
	STATUSDESCRIPTION("statusDescription"),
	CARPACKAGE("carPackage"),
	ALLINCLUSIVE("allInclusive");

	private  String value;

	private HotelInfoAttribute(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
