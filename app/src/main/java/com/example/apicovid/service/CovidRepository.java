package com.example.apicovid.service;

import com.example.apicovid.model.Covid.CovidResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidRepository {
    @GET("rekapitulasi_v2/jabar/kumulatif")
    Call<CovidResponse> getCovid();

}
