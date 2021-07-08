package com.example.storyproject;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class fable  extends Fragment {
    RecyclerView recyclerView;
    ArrayList images,names;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fable, container, false);
        recyclerView= view.findViewById(R.id.recyclerview);
        images= new ArrayList();
        names = new ArrayList();






        for (int i=0;i<Data.names.length;i++){
            images.add(Data.images);
            names.add(Data.names);




        }
        FableAdapter fableAdapter = new FableAdapter(getContext(),images,names);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fableAdapter);
        return view;
    }


    
}