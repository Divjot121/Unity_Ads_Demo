package com.divjot.unityads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.LinearLayout;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

public class MainActivity extends AppCompatActivity {

    private String GAMEID = "4566449";
    private String BANNERID = "Banner_Android";
    private String INTERSTITIALID = "Interstitial_Android";
    private boolean test = false;
    
    private Button INTADS;
    private LinearLayout bannerAD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        INTADS = findViewById(R.id.INTADS);
        bannerAD = findViewById(R.id.bannerAD);

        UnityAds.initialize(this, GAMEID, test);

        BannerView view = new BannerView(this, BANNERID, new UnityBannerSize(320, 50));
        view.load();
        bannerAD.addView(view);
        
        loadInterstitial();
        
        INTADS.setOnClickListener(v ->{
            UnityAds.show(this,INTERSTITIALID);
        });

     
       
    }

    private void loadInterstitial() {
        if(UnityAds.isInitialized()) {
            UnityAds.load(INTERSTITIALID);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    UnityAds.load(INTERSTITIALID);
                }
            }, 5000);
        }
    }
}