package com.example.apicovid.service;

import com.example.apicovid.model.rmsakit.RsResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RsRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<RsResponse> getRs();
}
