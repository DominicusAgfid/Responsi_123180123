package com.example.apicovid.model.Covid;

import com.google.gson.annotations.SerializedName;

public class CovidMetadata {

	@SerializedName("last_update")
	private String lastUpdate;

	public String getLastUpdate(){
		return lastUpdate;
	}

	@Override
 	public String toString(){
		return 
			"CovidMetadata{" +
			"last_update = '" + lastUpdate + '\'' + 
			"}";
		}
}