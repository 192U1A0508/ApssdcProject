package com.example.storyproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class SecondActivity extends AppCompatActivity {
    TabLayout tl;
    ViewPager vp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tl = findViewById(R.id.tl);
        vp = findViewById(R.id.vp);
        vp.setAdapter(new SecondActivity.MyAdapter(getSupportFragmentManager(), 0));
        tl.setupWithViewPager(vp);
        fable fable = new fable();
        Folktale folktale1 = new Folktale();
        fairytale fairytale = new fairytale();


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.llayout, fable);
        fragmentTransaction.add(R.id.llayout, folktale1);
        fragmentTransaction.add(R.id.llayout, fairytale);
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


    public void onBackPressed() {

        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(SecondActivity.this);

        builder.setMessage("Do you want to exit this app ?");


        builder.setTitle("FlyFar");


        builder.setCancelable(false);


        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {


                                finish();
                            }


                        });

        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which) {


                                dialog.cancel();
                            }
                        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}








