package com.example.antoniod.nolark_appli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.function.ToIntFunction;

public class simPoints extends AppCompatActivity {
    private int vLimite;
    private int vRelevee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_points);
        final Button btnCalcul = (Button) findViewById(R.id.btnCalcul);
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amende();
            }
        });
    }

    public simPoints(){
        final EditText nbVRelevee = (EditText) findViewById(R.id.nbVRelevee);
        final EditText nbVLimite = (EditText) findViewById(R.id.nbVLimite);
        this.vRelevee=Integer.parseInt(nbVRelevee.getText().toString());
        this.vLimite=Integer.parseInt(nbVLimite.getText().toString());
    }

    public int getVLimite(){
        return vLimite;
    }

    public int getVRelevee(){
        return vRelevee;
    }

    public int getVitesseEnTrop(int vLimite, int vRelevee){
        int ecart = vRelevee - vLimite;
        return ecart;
    }

    public void amende(){
        int vLimite = getVLimite();
        int vRelevee = getVRelevee();
        int ecart = getVitesseEnTrop(vLimite, vRelevee);
        final TextView sanction = (TextView) findViewById(R.id.txtSanction);
        final TextView amende = (TextView) findViewById(R.id.txtAmende);
        if(ecart < 20){
            sanction.setText("1 point");
            if (vLimite > 50)
                amende.setText("45 €/68 €/180 €");
            else
                amende.setText("90 €/135 €/375 €");

        }
    }
}
