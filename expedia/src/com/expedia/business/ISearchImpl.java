package com.expedia.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.expedia.model.Hotel;

public class ISearchImpl implements ISearch {

	private String searchBy;
	private String searchValue;
	private List<Hotel> allHotels;

	public ISearchImpl(String searchBy, String searchValue,
			List<Hotel> allHotels) {
		this.searchBy = searchBy;
		this.allHotels = allHotels;
		this.searchValue = searchValue;
	}

	public ResultsBean doSearch() {
		if (searchBy == null || searchValue == null) {
			return getDefaultResutls();
		}
		switch (searchBy) {
		case "destinationCity":
			return searchByDestinationName();
			// break;
		case "regionIds":
			return searchByRegionId();
		case "lengthOfStay":
			return searchByLengthToStay();
		case "minmaxStarRating":
			return searchByminMaxStarRating();
		case "minmaxTotalRate":
			return searchByminMaxTotalRating();
		case "minMaxGuestRating":
			return searchByminMaxGuestRating();

		default:
			return getDefaultResutls();
		}

	}

	private ResultsBean searchByDestinationName() {
		ResultsBean result = new ResultsBean();
		List<Hotel> foundedResults = new ArrayList<Hotel>();
		if (this.allHotels != null && !this.allHotels.isEmpty()) {
			Iterator<Hotel> hotelItr = allHotels.iterator();
			while (hotelItr.hasNext()) {
				Hotel hotel = hotelItr.next();
				if (hotel.getHotelDestinationStr().toLowerCase().contains(searchValue.toLowerCase())) {
					foundedResults.add(hotel);
				}
			}
			result.setHotels(foundedResults);
		}
		return result;
	}
	
	private ResultsBean searchByRegionId() {
		ResultsBean result = new ResultsBean();
		List<Hotel> foundedResults = new ArrayList<Hotel>();
		
		if (this.allHotels != null && !this.allHotels.isEmpty()) {
			Iterator<Hotel> hotelItr = allHotels.iterator();
			while (hotelItr.hasNext()) {
				Hotel hotel = hotelItr.next();
				String regionID = String.valueOf(hotel.getHotelDestination().getRegionID());
				if(regionID.equals(searchValue)){
					foundedResults.add(hotel);
				}
				
			}
			result.setHotels(foundedResults);
		}
		return result;
	}

	private ResultsBean searchByLengthToStay() {
		ResultsBean result = new ResultsBean();
		List<Hotel> foundedResults = new ArrayList<Hotel>();
		
		if (this.allHotels != null && !this.allHotels.isEmpty()) {
			Iterator<Hotel> hotelItr = allHotels.iterator();
			while (hotelItr.hasNext()) {
				Hotel hotel = hotelItr.next();
				String lengthToStay = String.valueOf(hotel.getOfferDateRange().getLengthOfStay());
				if(lengthToStay.equals(searchValue)){
					foundedResults.add(hotel);
				}
				
			}
			result.setHotels(foundedResults);
		}
		return result;
	}

	private ResultsBean searchByMaxTripStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	private ResultsBean searchByminMaxStarRating() {
		ResultsBean result = new ResultsBean();
		List<Hotel> foundedResults = new ArrayList<Hotel>();
		
		
		
		if (this.allHotels != null && !this.allHotels.isEmpty()) {
			Hotel minHotelStarRating =allHotels.get(0);
			
			Hotel maxHotelStarRating = allHotels.get(0);
			Iterator<Hotel> hotelItr = allHotels.iterator();
			while (hotelItr.hasNext()) {
				Hotel hotel = hotelItr.next();
				float minValue =  Float.parseFloat(minHotelStarRating.getHotelStarRating());
				float currentHotelVal =Float.parseFloat(hotel.getHotelStarRating());
				if(currentHotelVal < minValue){
					minHotelStarRating = hotel;
				}
				
				float maxValue =  Float.parseFloat(maxHotelStarRating.getHotelStarRating());
				
				if(currentHotelVal > maxValue){
					maxHotelStarRating = hotel;
				}
				
				
				
			}
			foundedResults.addAll(getHotelByStarRating(allHotels,minHotelStarRating.getHotelStarRating()));
			foundedResults.addAll(getHotelByStarRating(allHotels,maxHotelStarRating.getHotelStarRating()));
			
		}
		
		result.setHotels(foundedResults);
		return result;
	}

	private ResultsBean searchByminMaxTotalRating() {
		// TODO Auto-generated method stub
		return null;
	}

	private ResultsBean searchByminMaxGuestRating() {
		// TODO Auto-generated method stub
		return null;
	}

	private ResultsBean getDefaultResutls() {
		ResultsBean result = new ResultsBean();
		result.setHotels(this.allHotels);
		return result;
	}
	
	private List<Hotel> getHotelByStarRating(List<Hotel>hotels , String starRating) {
		
		Iterator<Hotel> hotelItr = allHotels.iterator();
		List<Hotel> foundedResults = new ArrayList<Hotel>();
		while (hotelItr.hasNext()) {
			Hotel hotel = hotelItr.next();	
			if(hotel.getHotelStarRating().equals(starRating)){
				foundedResults.add(hotel);
			}
		}
		return foundedResults;
	}

}
