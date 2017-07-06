package com.expedia.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpConnection {
	private static HttpConnection httpConnection = new HttpConnection();
	private HttpConnection(){
		
	}
	public static HttpConnection getInstance(){
		return httpConnection;
	}
	public String doGet(String url){
		DefaultHttpClient httpClient = new DefaultHttpClient();
		 HttpGet getRequest = new HttpGet(url.trim());
		 getRequest.addHeader("accept", "application/json");
		 StringBuffer buffer = new StringBuffer();
		    try {
			    HttpResponse response = httpClient.execute(getRequest);

			    if (response.getStatusLine().getStatusCode() != 200) {
				    throw new RuntimeException("Failed : HTTP error code : "
						    + response.getStatusLine().getStatusCode());
			    }
			    BufferedReader br = new BufferedReader(
					    new InputStreamReader((response.getEntity().getContent())));

			    String output;

			    System.out.println("Output from Server .... \n");
			    while ((output = br.readLine()) != null) {
				    buffer.append(output);
				    System.out.println(output);
			    }
			    System.out.println(buffer.toString());

			    httpClient.getConnectionManager().shutdown();
		    }catch(IOException err){
				err.printStackTrace();
		    }
		    
		    return buffer.toString();
	}
}
