package com.example.apicovid.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.apicovid.model.rmsakit.RsDataItem;
import com.example.apicovid.model.rmsakit.RsResponse;
import com.example.apicovid.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RsViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<RsDataItem>> listRs = new MutableLiveData<>();

    public void setRs() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiRs().getRs().enqueue(new Callback<RsResponse>() {
            @Override
            public void onResponse(Call<RsResponse> call, Response<RsResponse> response) {
                RsResponse Rs = response.body();
                if(Rs != null && Rs.getData() != null){
                    ArrayList<RsDataItem> rsDataItems = Rs.getData();
                    listRs.postValue(rsDataItems);
                }
            }

            @Override
            public void onFailure(Call<RsResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<RsDataItem>> getRs(){
        return listRs;
    }
}
