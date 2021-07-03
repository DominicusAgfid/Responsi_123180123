package com.example.apicovid.model.rmsakit;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RsResponse {

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<RsDataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<RsDataItem> data){
		this.data = data;
	}

	public ArrayList<RsDataItem> getData(){
		return data;
	}
}