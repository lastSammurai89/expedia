package com.expedia.model;


/**
 * Created by odahmos on 7/5/17.
 */
public enum DestinationAttributes {
	MAIN("destination"),
	REGIONID("regionID"),
	LONGNAME("longName"),
	COUNTRY("country"),
	PROVINCE("province"),
	CITY("city");


	private  String value;

	private DestinationAttributes(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
