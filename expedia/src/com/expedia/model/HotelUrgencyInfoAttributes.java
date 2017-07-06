package com.expedia.model;

/**
 * Created by odahmos on 7/5/17.
 */
public enum HotelUrgencyInfoAttributes {
	MAIN("hotelUrgencyInfo"),
	HOTELURGENCYINFO("hotelUrgencyInfo"),
	AIRATTACHREMAININGTIME("airAttachRemainingTime"),
	NUMBEROFPEOPLEVIEWING("numberOfPeopleViewing"),
	NUMBEROFPEOPLEBOOKED("numberOfPeopleBooked"),
	NUMBEROFROOMSLEFT("numberOfRoomsLeft"),
	LASTBOOKEDTIME("lastBookedTime"),
	ALMOSTSOLDSTATUS("almostSoldStatus"),
	LINK("link"),
	ALMOSTSOLDOUTROOMTYPEINFOCOLLECTION("almostSoldOutRoomTypeInfoCollection"),
	AIRATTACHENABLED("airAttachEnabled");

	private  String value;

	private HotelUrgencyInfoAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
