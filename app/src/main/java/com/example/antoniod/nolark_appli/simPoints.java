package com.example.antoniod.nolark_appli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class simPoints extends AppCompatActivity {
    private int vLimite;
    private int vRelevee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_points);
    }

    public simPoints(int vLimite, int vRelevee){
        this.vLimite=vLimite;
        this.vRelevee=vRelevee;
    }

    public int getvLimite(){
        return vLimite;
    }

    public int getvRelevee(){
        return vRelevee;
    }

    public int getVitesseEnTrop(int vLimite, int vRelevee){
        int ecart = vRelevee - vLimite;
        return ecart;
    }


}
