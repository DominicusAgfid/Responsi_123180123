package com.example.apicovid.model.Covid;

import com.google.gson.annotations.SerializedName;

public class CovidResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private CovidData data;

	public int getStatusCode(){
		return statusCode;
	}

	public CovidData getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' +
			"}";
		}
}