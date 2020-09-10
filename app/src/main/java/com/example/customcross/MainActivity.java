package com.example.customcross;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewAdsCross viewAdsCross=findViewById(R.id.view_ads_cross);
        viewAdsCross.setEvenAdsCross(new ViewAdsCross.EvenAdsCross() {
            @Override
            public void onOpenInfoAds() {
                Toast.makeText(MainActivity.this, "onOpenInfoAds", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onOpenAdsGooglePlay() {
                Toast.makeText(MainActivity.this, "onOpenAdsGooglePlay", Toast.LENGTH_SHORT).show();
            }
        });
    }
}