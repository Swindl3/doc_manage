package com.example.f1r3z.myapplicationdocument;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.f1r3z.myapplicationdocument.adapter.adt_rv_cardview_doc;


public class InsertGroupFragment extends Fragment {

    public InsertGroupFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_insert_group, container, false);
        Button button = (Button) rootView.findViewById(R.id.btn_insert_group);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnClick();
            }
        });



        return rootView;
    }

    public void OnClick(){
        Intent intent = new Intent(getActivity(),UsingNavigationDrawer.class);
        startActivity(intent);
    }

}
