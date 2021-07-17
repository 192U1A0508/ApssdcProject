package com.example.storyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class FairActivity5 extends AppCompatActivity {
    Button playPause,stop;
    TextView cnt;
    TextToSpeech t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fair5);
        playPause=findViewById(R.id.play);
        stop=findViewById(R.id.stop);
        cnt=findViewById(R.id.stonecontent);
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status!=TextToSpeech.ERROR){
                    t1.setLanguage(Locale.ENGLISH);
                }

            }

        });
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=cnt.getText().toString();
                t1.speak(s,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(FairActivity5.this,"playing...",Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        if (t1!=null){
            t1.stop();
            t1.shutdown();
        }

    }

    public void stop(View view) {
        if(t1!=null){
            t1.stop();
            Toast.makeText(FairActivity5.this, "Stopped...", Toast.LENGTH_SHORT).show();

        }

    }
}