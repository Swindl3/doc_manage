package com.example.f1r3z.myapplicationdocument;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_doc;
import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_group;


public class GroupFragment extends Fragment {


    public GroupFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_group, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerviewgroup);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        RecyclerView.Adapter adt = new adt_rv_cardview_group();
        recyclerView.setAdapter(adt);


        return rootView;
    }

}
