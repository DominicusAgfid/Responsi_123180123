package com.example.apicovid.model.Covid;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CovidData {

	@SerializedName("covidMetadata")
	private CovidMetadata covidMetadata;

	@SerializedName("content")
	private ArrayList<CovidContentItem> content;

	public CovidMetadata getCovidMetadata(){
		return covidMetadata;
	}

	public ArrayList<CovidContentItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"CovidData{" +
			"covidMetadata = '" + covidMetadata + '\'' +
			",content = '" + content + '\'' + 
			"}";
		}
}