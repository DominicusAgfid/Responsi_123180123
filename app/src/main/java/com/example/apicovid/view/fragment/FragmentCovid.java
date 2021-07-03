package com.example.apicovid.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apicovid.R;
import com.example.apicovid.adapter.CovidAdapter;
import com.example.apicovid.model.Covid.CovidContentItem;
import com.example.apicovid.view.viewmodel.CovidViewModel;

import java.util.ArrayList;

public class FragmentCovid extends Fragment {

    private CovidAdapter covidAdapter;
    private RecyclerView rvCovid;
    private CovidViewModel covidViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        covidAdapter = new CovidAdapter(getContext());
        covidAdapter.notifyDataSetChanged();

        rvCovid = view.findViewById(R.id.fragmentcovid_rv);
        rvCovid.setLayoutManager(new LinearLayoutManager(getContext()));

        covidViewModel = new ViewModelProvider(this).get(CovidViewModel.class);
        covidViewModel.setCovid();
        covidViewModel.getCovid().observe(getViewLifecycleOwner() ,getCovid);

        rvCovid.setAdapter(covidAdapter);
    }

    private Observer<ArrayList<CovidContentItem>> getCovid = new Observer<ArrayList<CovidContentItem>>() {
        @Override
        public void onChanged(ArrayList<CovidContentItem> covidContentItems) {
            if(covidContentItems != null){
                covidAdapter.setData(covidContentItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_covid, container, false);
    }

}