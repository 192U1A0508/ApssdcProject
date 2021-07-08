package com.example.storyproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TabLayout tl;
    ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tl = findViewById(R.id.tl);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new MyAdapter(getSupportFragmentManager(), 0));
        tl.setupWithViewPager(vp);
        fable fable = new fable();
        Folktale folktale1=new Folktale();
        fairytale fairytale=new fairytale();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.llayout, fable);
        fragmentTransaction.add(R.id.llayout,folktale1);
        fragmentTransaction.add(R.id.llayout,fairytale);
        fragmentTransaction.commit();

    }



    public class MyAdapter extends FragmentPagerAdapter {
        String[] title = {"fable", "folktale", "fairytale"};


        public MyAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new fable();
        }
        if (position == 1) {
            return new Folktale();
        }
        if (position == 2) {
            return new fairytale();
        }
        return null;

    }

    @Override
    public int getCount() {

        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
}

