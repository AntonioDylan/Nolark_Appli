package com.example.antoniod.nolark_appli;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Entity.Casque;
import Service.jsonReader;

public class Boutique extends ActionBarActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boutique);
        ArrayList<Casque> casques = jsonReader.setCasques();
        mListView = (ListView) findViewById(R.id.listView);

        Service.CasqueAdapter adapter = new Service.CasqueAdapter(Boutique.this,android.R.layout.simple_list_item_1, casques);
        mListView.setAdapter(adapter);
    }
}
