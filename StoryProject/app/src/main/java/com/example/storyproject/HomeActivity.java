package com.example.storyproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Locale;

import static android.view.View.IMPORTANT_FOR_ACCESSIBILITY_NO;

public class HomeActivity extends AppCompatActivity {
    Button playPause,stop;
    TextView cnt;
    TextToSpeech t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        playPause = findViewById(R.id.play);
        cnt = findViewById(R.id.content);
        stop=findViewById(R.id.stop);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.ENGLISH);
                }


            }

        });
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = cnt.getText().toString();
                t1.speak(s, TextToSpeech.QUEUE_FLUSH, null);
                Toast.makeText(HomeActivity.this, "Playing...", Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        if (t1!=null){
            t1.shutdown();
        }
    }

    public void stop(View view) {
        if(t1!=null){
            t1.stop();
            Toast.makeText(HomeActivity.this, "Stopped...", Toast.LENGTH_SHORT).show();

        }

    }

}

