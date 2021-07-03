package com.example.apicovid.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apicovid.model.Covid.CovidContentItem;
import com.example.apicovid.model.Covid.CovidResponse;
import com.example.apicovid.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CovidViewModel extends ViewModel {

    private ApiMain apiMain;
    private MutableLiveData<ArrayList<CovidContentItem>> listCovid = new MutableLiveData<>();

    public void setCovid() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiCovid().getCovid().enqueue(new Callback<CovidResponse>() {
            @Override
            public void onResponse(Call<CovidResponse> call, Response<CovidResponse> response) {
                CovidResponse CovidResponse = response.body();
                if(CovidResponse != null && CovidResponse.getData() != null){
                    ArrayList<CovidContentItem> CovidItem = CovidResponse.getData().getContent();
                    listCovid.postValue(CovidItem);
                }
            }

            @Override
            public void onFailure(Call<CovidResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<CovidContentItem>> getCovid(){
        return listCovid;
    }
}
