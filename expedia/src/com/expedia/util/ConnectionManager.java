package com.expedia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


public class ConnectionManager {
	private InfoProps infoProps;
	public ConnectionManager(InfoProps infoProps){
		this.infoProps = infoProps;
	}
	
	public String connect() throws IOException {
		  BufferedReader reader = null;
		    try {
		    	URL url = new URL(infoProps.getKeyValue("JSON_INFO_HOST"));
		        reader = new BufferedReader(new InputStreamReader(url.openStream()));
		        StringBuffer buffer = new StringBuffer();
		        int read;
		        char[] chars = new char[1024];
		        while ((read = reader.read(chars)) != -1)
		            buffer.append(chars, 0, read); 

		        return buffer.toString();
		    } finally {
		        if (reader != null)
		            reader.close();
		    }
	}
	
	
	
	

}
