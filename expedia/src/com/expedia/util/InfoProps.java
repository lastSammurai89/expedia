package com.expedia.util;

import java.util.Properties;

public class InfoProps {
	private  static Properties props;
	

	public static void loadProps(Properties props) {
		InfoProps.props = props;
	}

	public static void setProps(Properties props) {
		InfoProps.props = props;
	}


	public String getKeyValue(String key){
		return props.getProperty(key);
	}
	
	private static InfoProps infoProps = new InfoProps();
		
	private InfoProps(){
		
	}
	
	public static InfoProps getInstance(){
		return infoProps;
	}
	
	
}
