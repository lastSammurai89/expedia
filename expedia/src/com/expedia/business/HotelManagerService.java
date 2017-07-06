package com.expedia.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.expedia.model.DestinationAttributes;
import com.expedia.model.Hotel;
import com.expedia.model.HotelDestination;
import com.expedia.model.HotelInfoAttribute;
import com.expedia.model.HotelPricingInfo;
import com.expedia.model.HotelPricingInfoAttributes;
import com.expedia.model.HotelScores;
import com.expedia.model.HotelScoresAttributes;
import com.expedia.model.HotelUrgencyInfo;
import com.expedia.model.HotelUrgencyInfoAttributes;
import com.expedia.model.HotelUrls;
import com.expedia.model.HotelUrlsAttributes;
import com.expedia.model.OfferDateRange;
import com.expedia.model.OfferDateRangeAttributes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HotelManagerService {
	public List<Hotel> getHotels(String contentFiles){
		 JSONParser parser = new JSONParser();
		 List<Hotel> hotelsList = new ArrayList<Hotel>();

		    try {
			    Object obj = parser.parse(contentFiles);
			    JSONObject rootObject = (JSONObject) obj;
			    JSONObject offerInfo = (JSONObject)rootObject.get("offerInfo");
			    System.out.println(offerInfo);
			    System.out.println(offerInfo.get("siteID"));
			    System.out.println(offerInfo.get("language"));
			    System.out.println(offerInfo.get("currency"));

			    JSONObject userInfo = (JSONObject)rootObject.get("userInfo");
			    System.out.println(userInfo);
			    System.out.println(userInfo.get("persona"));
			    System.out.println(userInfo.get("userId"));

			    JSONObject offers = (JSONObject)rootObject.get("offers");
			    System.out.println(offers);
			    System.out.println(offers.get("Hotel"));

			    JSONArray hotels = (JSONArray)offers.get("Hotel");
			    Iterator<JSONObject> iterator = hotels.iterator();
			   
			    while (iterator.hasNext()) {
				    JSONObject hotelEntry = iterator.next();
				    Hotel hotel = new Hotel();
				    HotelDestination hotelDestination = new HotelDestination();
				    HotelUrgencyInfo hotelUrgencyInfoObj = new HotelUrgencyInfo();
				    HotelPricingInfo hotelPricingInfoObj = new HotelPricingInfo();
				  
					HotelUrls hotelUrlsObj = new HotelUrls();
				    HotelScores hotelScoresObj = new HotelScores();

				    hotel.setHotelDestination(hotelDestination);
				    hotel.setHotelUrgencyInfo(hotelUrgencyInfoObj);
				    hotel.setHotelPricingInfo(hotelPricingInfoObj);
				    hotel.setHotelUrls(hotelUrlsObj);
				    hotel.setHotelScores(hotelScoresObj);

				    JSONObject offerDateRange = (JSONObject)hotelEntry.get(OfferDateRangeAttributes.MAIN.getValue());
				    
				    JSONArray travelStartDate = (JSONArray)offerDateRange.get(OfferDateRangeAttributes.TRAVELSTARTDATE.getValue());
				    JSONArray travelEndDate = (JSONArray)offerDateRange.get(OfferDateRangeAttributes.TRAVELENDDATE.getValue());
				    Long lengthOfStay = (Long)offerDateRange.get(OfferDateRangeAttributes.LENGTHOFSTAY.getValue());
				    OfferDateRange offerDateRangeModel = new OfferDateRange(travelStartDate, travelEndDate, lengthOfStay);
				    hotel.setOfferDateRange(offerDateRangeModel);
				    System.out.println(travelStartDate.toString());
				    System.out.println(travelEndDate);
				    System.out.println(lengthOfStay);

				    //Hotel destination
				    JSONObject destination = (JSONObject)hotelEntry.get(DestinationAttributes.MAIN.getValue());
				    hotelDestination.setRegionID((String) destination.get(DestinationAttributes.REGIONID.getValue()));
				    hotelDestination.setLongName((String) destination.get(DestinationAttributes.LONGNAME.getValue()));
				    hotelDestination.setCountry((String) destination.get(DestinationAttributes.COUNTRY.getValue()));
				    hotelDestination.setProvince((String) destination.get(DestinationAttributes.PROVINCE.getValue()));
				    hotelDestination.setCity((String) destination.get(DestinationAttributes.CITY.getValue()));



				   //Hotel Urgency Info
				   JSONObject hotelInfo = (JSONObject)hotelEntry.get(HotelInfoAttribute.MAIN.getValue());
				   hotel.setHotelId((String) hotelInfo.get(HotelInfoAttribute.HOTELID.getValue()));
				   hotel.setHotelName((String) hotelInfo.get(HotelInfoAttribute.HOTELNAME.getValue()));
				   hotel.setHotelDestinationStr((String) hotelInfo.get(HotelInfoAttribute.HOTELDESTINATION.getValue()));
				   hotel.setHotelDestinationRegionID((String)hotelInfo.get(HotelInfoAttribute.HOTELDESTINATIONREGIONID.getValue()));
				   hotel.setHotelLongDestination((String) hotelInfo.get(HotelInfoAttribute.HOTELLONGDESTINATION.getValue()));
				   hotel.setHotelStreetAddress((String) hotelInfo.get(HotelInfoAttribute.HOTELSTREETADDRESS.getValue()));
				   hotel.setHotelCity((String) hotelInfo.get(HotelInfoAttribute.HOTELCITY.getValue()));
				   hotel.setHotelProvince((String) hotelInfo.get(HotelInfoAttribute.HOTELPROVINCE.getValue()));
				   hotel.setHotelCountryCode((String) hotelInfo.get(HotelInfoAttribute.HOTELCOUNTRYCODE.getValue()));
				   hotel.setHotelLocation((String) hotelInfo.get(HotelInfoAttribute.HOTELLOCATION.getValue()));
				   hotel.setHotelLatitude((double) hotelInfo.get(HotelInfoAttribute.HOTELLATITUDE.getValue()));
				   hotel.setHotelLongitude((double) hotelInfo.get(HotelInfoAttribute.HOTELLONGITUDE.getValue()));
				   hotel.setHotelStarRating((String) hotelInfo.get(HotelInfoAttribute.HOTELSTARRATING.getValue()));
				   hotel.setHotelGuestReviewRating((double) hotelInfo.get(HotelInfoAttribute.HOTELGUESTREVIEWRATING.getValue()));
				   hotel.setHotelInfotravelStartDate((String)hotelInfo.get(HotelInfoAttribute.HOTELINFOTRAVELSTARTDATE.getValue()));
				   hotel.setHotelInfotravelEndDate((String) hotelInfo.get(HotelInfoAttribute.HOTELINFOTRAVELENDDATE.getValue()));
				   hotel.setHotelImageUrl((String) hotelInfo.get(HotelInfoAttribute.HOTELIMAGEURL.getValue()));
				   hotel.setCarPackageScore((double) hotelInfo.get(HotelInfoAttribute.CARPACKAGESCORE.getValue()));
				   hotel.setDescription((String) hotelInfo.get(HotelInfoAttribute.DESCRIPTION.getValue()));
				   hotel.setDistanceFromUser((double) hotelInfo.get(HotelInfoAttribute.DISTANCEFROMUSER.getValue()));
				   hotel.setLanguage((String) hotelInfo.get(HotelInfoAttribute.LANGUAGE.getValue()));
				   hotel.setMovingAverageScore((double) hotelInfo.get(HotelInfoAttribute.MOVINGAVERAGESCORE.getValue()));
				   hotel.setPromotionAmount((double) hotelInfo.get(HotelInfoAttribute.PROMOTIONAMOUNT.getValue()));
				   hotel.setPromotionDescription((String) hotelInfo.get(HotelInfoAttribute.PROMOTIONDESCRIPTION.getValue()));
				   hotel.setPromotionTag((String) hotelInfo.get(HotelInfoAttribute.PROMOTIONTAG.getValue()));
				   hotel.setRawAppealScore((double) hotelInfo.get(HotelInfoAttribute.RAWAPPEALSCORE.getValue()));
				   hotel.setRelevanceScore((double) hotelInfo.get(HotelInfoAttribute.RELEVANCESCORE.getValue()));
				   hotel.setStatusCode((String) hotelInfo.get(HotelInfoAttribute.STATUSCODE.getValue()));
				   hotel.setStatusDescription((String) hotelInfo.get(HotelInfoAttribute.STATUSDESCRIPTION.getValue()));
				   hotel.setCarPackage((boolean) hotelInfo.get(HotelInfoAttribute.CARPACKAGE.getValue()));
				   hotel.setAllInclusive((boolean) hotelInfo.get(HotelInfoAttribute.ALLINCLUSIVE.getValue()));

				    //Hotel Urgency Info
				    JSONObject hotelUrgencyInfo = (JSONObject)hotelEntry.get(HotelUrgencyInfoAttributes.MAIN.getValue());

				    hotelUrgencyInfoObj.setAirAttachRemainingTime((Long) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.AIRATTACHREMAININGTIME.getValue()));
				    hotelUrgencyInfoObj.setNumberOfPeopleViewing((Long) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.NUMBEROFPEOPLEVIEWING.getValue()));
				    hotelUrgencyInfoObj.setNumberOfPeopleBooked((Long)hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.NUMBEROFPEOPLEBOOKED.getValue()));
				    hotelUrgencyInfoObj.setNumberOfRoomsLeft((Long) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.NUMBEROFROOMSLEFT.getValue()));
				    hotelUrgencyInfoObj.setLastBookedTime((Long) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.LASTBOOKEDTIME.getValue()));
				    hotelUrgencyInfoObj.setAlmostSoldStatus((String) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.ALMOSTSOLDSTATUS.getValue()));
				    hotelUrgencyInfoObj.setLink((String) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.LINK.getValue()));
				    JSONArray almostSoldOutRoomTypeInfoCollection = ((JSONArray)hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.ALMOSTSOLDOUTROOMTYPEINFOCOLLECTION.getValue()));
				    hotelUrgencyInfoObj.setAirAttachEnabled((boolean) hotelUrgencyInfo.get(HotelUrgencyInfoAttributes.AIRATTACHENABLED.getValue()));

				    //Hotel Pricing Info
				    JSONObject hotelPricingInfo = (JSONObject)hotelEntry.get(HotelPricingInfoAttributes.MAIN.getValue());

				    hotelPricingInfoObj.setAveragePriceValue((double) hotelPricingInfo.get(HotelPricingInfoAttributes.AVERAGEPRICEVALUE.getValue()));
				    hotelPricingInfoObj.setTotalPriceValue((double) hotelPricingInfo.get(HotelPricingInfoAttributes.TOTALPRICEVALUE.getValue()));
				    hotelPricingInfoObj.setOriginalPricePerNight((String) hotelPricingInfo.get(HotelPricingInfoAttributes.ORIGINALPRICEPERNIGHT.getValue()));
				    hotelPricingInfoObj.setHotelTotalBaseRate((double) hotelPricingInfo.get(HotelPricingInfoAttributes.HOTELTOTALBASERATE.getValue()));
				    hotelPricingInfoObj.setCurrency((String) hotelPricingInfo.get(HotelPricingInfoAttributes.CURRENCY.getValue()));
				    hotelPricingInfoObj.setHotelTotalMandatoryTaxesAndFees((double) hotelPricingInfo.get(HotelPricingInfoAttributes.HOTELTOTALMANDATORYTAXESANDFEES.getValue()));
				    hotelPricingInfoObj.setPercentSavings((double) hotelPricingInfo.get(HotelPricingInfoAttributes.PERCENTSAVINGS.getValue()));
				    hotelPricingInfoObj.setDrr((boolean) hotelPricingInfo.get(HotelPricingInfoAttributes.DRR.getValue()));

				    //Hotel Urls Info
				    JSONObject hotelUrls = (JSONObject)hotelEntry.get(HotelUrlsAttributes.HOTELURLS.getValue());
				    hotelUrlsObj.setHotelInfositeUrl((String)hotelUrls.get(HotelUrlsAttributes.HOTELINFOSITEURL.getValue()));
				    hotelUrlsObj.setHotelSearchResultUrl((String)hotelUrls.get(HotelUrlsAttributes.HOTELSEARCHRESULTURL.getValue()));

				    //Hotel Scores Info
				    JSONObject hotelScores = (JSONObject)hotelEntry.get(HotelScoresAttributes.MAIN.getValue());
				    hotelScoresObj.setHotelRawAppealScore((String)hotelUrls.get(HotelScoresAttributes.RAWAPPEALSCORE.getValue()));
				    hotelScoresObj.setHotelMovingAverageScore((String)hotelUrls.get(HotelScoresAttributes.MOVINGAVERAGESCORE.getValue()));

				    hotelsList.add(hotel);


			    }

			    System.out.println("#Number Of Hotels :" + hotelsList.size());



		    } catch (ParseException e) {
			    e.printStackTrace();
		    }
		    
		    return hotelsList;
	}
			   
	
}
