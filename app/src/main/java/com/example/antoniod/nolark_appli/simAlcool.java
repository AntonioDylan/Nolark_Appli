package com.example.antoniod.nolark_appli;

        import android.content.DialogInterface;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;

        import java.util.function.ToIntFunction;

public class simAlcool extends AppCompatActivity {
    final TextView txtAlcool = (TextView) findViewById(R.id.txtAlcool);
    final TextView txtAmende = (TextView) findViewById(R.id.txtAmende);
    final TextView txtSanction = (TextView) findViewById(R.id.txtSanction);

    private double vPoids;
    private int uniteAlcool =10;
    private double coefDiffuH = 0.7;
    private double coefDiffuF = 0.6;
    private double txAlcool;
    private int vVerres;
    private String sexe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sim_alcool);
        final Button btnCalcul = (Button) findViewById(R.id.btnCalcul);
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amende();
            }
        });
    }

    public simAlcool(){
        final EditText nbVerres = (EditText) findViewById(R.id.nbVerres);
        final EditText nbPoids = (EditText) findViewById(R.id.nbPoids);
        final RadioGroup RG = (RadioGroup) findViewById(R.id.radioGroup);
        this.vVerres=Integer.parseInt(nbVerres.getText().toString());
        this.vPoids=Integer.parseInt(nbPoids.getText().toString());

    }



    public String getSexe(){
        final RadioGroup radioGroup= (RadioGroup) findViewById(R.id.radioGroup);
        final RadioButton radioGroup_checked = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
        String sexe =(String) radioGroup_checked.getText();


        return sexe;
    }

    public double getAlcoolemie(int vVerres, double vPoids, String sexe, int uniteAlcool, double coefDiffuF, double coefDiffuH) {
       if (sexe == "Homme") {
            txAlcool = (vVerres * uniteAlcool) / (vPoids * coefDiffuH);
        } else if (sexe == "Femme") {
            txAlcool = (vVerres * uniteAlcool) / (vPoids * coefDiffuF);
        }
        return txAlcool;
    }

    public void amende(){
        sexe=getSexe();
        double txAlcool = getAlcoolemie(vVerres, vPoids, sexe, uniteAlcool, coefDiffuF, coefDiffuH);
        String amende;
        String sanction;
        if (vVerres>0){
            if(txAlcool >= 0.5) {
                if (txAlcool <= 0.8){
                    sanction = "+ 6 points + suspension 3 ans";
                    amende = "90 €/135 €/375 €";
                    txtAmende.setText("Amende minorée/Forfaitaire/Majorée: " + amende);
                    txtSanction.setText("Retrait :" + sanction);
                }
                else{
                    sanction = "+ 6 points + 2 ans de prisons + suspension de 3 ans + stage de sensibilisation";
                    amende = "4 500 €";
                    txtAmende.setText(amende);
                    txtSanction.setText("Retrait :" + sanction);
                }
            }
            else{
                txtAmende.setText("Vous pouvez conduire mais soyez vigilant, vous avez bu!");
                txtSanction.setText("");
                }
        }
        else{
            txtAmende.setText("C’est bien, quand on conduit, on ne boit pas !");
            txtSanction.setText("");
        }
        txtAlcool.setText("Votre taux d'alcoolémie est de : " + txAlcool +" g/l de sang");
    }
}

