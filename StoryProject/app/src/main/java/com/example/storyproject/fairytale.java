package com.example.storyproject;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import  android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class fairytale extends Fragment {
    RecyclerView recyclerView;
    ArrayList images,names;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fairytale, container, false);
        recyclerView= view.findViewById(R.id.recyclerview);
        images= new ArrayList();
        names = new ArrayList();
        for (int i=0;i<Data2.names.length;i++){
            images.add(Data2.images);
            names.add(Data2.names);

        }
        FairytaleAdapter fairytaleAdapter = new FairytaleAdapter(getContext(),images,names);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fairytaleAdapter);
        return view;
    }
}