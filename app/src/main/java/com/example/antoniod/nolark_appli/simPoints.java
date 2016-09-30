package com.example.antoniod.nolark_appli;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class simPoints extends AppCompatActivity {
    private int vLimite;
    private int vRelevee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_points);
        final Button btnCalcul = (Button) findViewById(R.id.btnCalcul);
        btnCalcul.setOnClickListener(new TextView.OnClickListener() {
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
        TextView txtAmende = (TextView) findViewById(R.id.txtAmende);
        TextView txtSanction = (TextView) findViewById(R.id.txtSanction);
        String amende;
        String sanction;
        if(ecart < 20) {
            sanction = "1 point";
            if (vLimite > 50){amende = "45 €/68 €/180 €";}
            else {amende = "90 €/135 €/375 €";}
            txtAmende.setText("Amende minorée/Forfaitaire/Majorée: " + amende);
            txtSanction.setText("Retrait :" + sanction);
        }
        else if (ecart >= 20 && ecart < 50) {
            amende = "90 €/135 €/375 €";
            if (ecart < 30) {sanction = "2 points";}
            else if (ecart < 40) {sanction = "3 points + 3 ans de suspension";}
            else {sanction = "4 points + 3 ans de suspension";}
            txtAmende.setText("Amende minorée/Forfaitaire/Majorée: " + amende);
            txtSanction.setText("Retrait :" + sanction);
        }

        else if (ecart > 50){
            amende = "1500 €";
            sanction = "6 points + 3 ans de suspension + confisaction véhicule + stage sécurité";
            txtAmende.setText("Amende minorée/Forfaitaire/Majorée: " + amende);
            txtSanction.setText("Retrait :" + sanction);
        }

        else{
            txtAmende.setText("Vitesse respectée!");
            txtSanction.setText("Pas de sanctions!");
        }
    }
}
