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
import com.example.apicovid.adapter.RsAdapter;
import com.example.apicovid.model.rmsakit.RsDataItem;
import com.example.apicovid.view.viewmodel.RsViewModel;

import java.util.ArrayList;

public class FragmentRs extends Fragment  {

    private RsAdapter rsAdapter;
    private RecyclerView rvRs;
    private RsViewModel rsViewModel;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rsAdapter = new RsAdapter(getContext());
        rsAdapter.notifyDataSetChanged();

        rvRs = view.findViewById(R.id.fragmentrs_rv);
        rvRs.setLayoutManager(new LinearLayoutManager(getContext()));

        rsViewModel = new ViewModelProvider(this).get(RsViewModel.class);
        rsViewModel.setRs();
        rsViewModel.getRs().observe(getViewLifecycleOwner() ,getRs);

        rvRs.setAdapter(rsAdapter);
    }

    private Observer<ArrayList<RsDataItem>> getRs = new Observer<ArrayList<RsDataItem>>() {
        @Override
        public void onChanged(ArrayList<RsDataItem> rsDataItems) {
            if(rsDataItems != null){
                rsAdapter.setData(rsDataItems);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rs, container, false);
    }


}