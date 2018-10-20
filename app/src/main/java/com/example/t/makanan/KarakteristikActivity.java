package com.example.t.makanan;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class KarakteristikActivity extends AppCompatActivity {
    RadioGroup radioKarakteristikGroup;
    RadioButton radioKarakteristikButton,radiokadarabu,radiokadarair,radioprotein,radiokarbohidrat,radiolemak,radioenergi;
    EditText jangkAwal, jangkAkhir;
    MakananActivity makananActivity = new MakananActivity();
    Button submit;
    JSONArray jsonArray,jsonArray1,jsonArray2;
    String a,b;
    String nganu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karakteristik);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        radioKarakteristikGroup = findViewById(R.id.radioGroup);
        jangkAwal = findViewById(R.id.edtAwal);
        jangkAkhir = findViewById(R.id.edtAkhir);
        submit = findViewById(R.id.btnSubmit);
        radiokadarabu = findViewById(R.id.radioKadarAbu);
        radiokadarair = findViewById(R.id.radioKadarAir);
        radioprotein = findViewById(R.id.radioProtein);
        radiokarbohidrat = findViewById(R.id.radioKarbohidrat);
        radiolemak = findViewById(R.id.radioLemak);
        radioenergi = findViewById(R.id.radioEnergi);
        radioKarakteristikGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String max = null;
                String min = null;
                if (radiokadarabu.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("kadar_abu"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(kadar_abu)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("kadar_abu"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(kadar_abu)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }else if (radiokadarair.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("kadar_air"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(kadar_air)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("kadar_air"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(kadar_air)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }else if (radioprotein.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("protein"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(protein)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("protein"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(protein)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }else if (radiolemak.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("lemak"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(lemak)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("lemak"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(lemak)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }else if (radiokarbohidrat.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("karbohidrat"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(karbohidrat)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("karbohidrat"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(karbohidrat)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }else if (radioenergi.isChecked()) {
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMaxValue("energi"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            max = obj.getString("MAX(energi)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    try{
                        jsonArray1 = new JSONArray(makananActivity.getMinValue("energi"));
                        for (int i = 0; i < jsonArray1.length(); i++) {
                            JSONObject obj = jsonArray1.getJSONObject(i);
                            min = obj.getString("MIN(energi)");
                        }
                    }catch(JSONException e){
                        e.printStackTrace();
                    }
                    Toast.makeText(KarakteristikActivity.this,"DATA MAX: "+max+" Data MIN: "+min,Toast.LENGTH_LONG).show();
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioKarakteristikGroup.getCheckedRadioButtonId();
                radioKarakteristikButton = findViewById(selectedId);
                String karakteristik = radioKarakteristikButton.getHint().toString();
                String awal = jangkAwal.getText().toString();
                String akhir = jangkAkhir.getText().toString();

                try {
                    jsonArray = new JSONArray(makananActivity.getMakananByKarakteristik(karakteristik, awal, akhir));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (jsonArray.length() > 0) {
                    Intent intent = new Intent(KarakteristikActivity.this, Hasil2Activity.class);
                    intent.putExtra("karakteristik", karakteristik);
                    intent.putExtra("awal", awal);
                    intent.putExtra("akhir", akhir);
                    startActivity(intent);
                } else if (jsonArray.length() == 0) {
                    Toast.makeText(KarakteristikActivity.this, "Tidak Ada Data", Toast.LENGTH_LONG).show();
                }
            }
        });


    }
}






            /*List<String> spinnerArray =  new ArrayList<String>();
            spinnerArray.add("0.1%-0.5%");
            spinnerArray.add("0.5%-1%");
            spinnerArray.add("1%-1.5%");
            spinnerArray.add("1.5%-2%");
            spinnerArray.add("2%-2.5%");
            spinnerArray.add("2.5%-3%");
            spinnerArray.add("3%-3.5%");
            spinnerArray.add("3.5%-4%");
            spinnerArray.add("4%-4.5%");
            spinnerArray.add("4.5%-5%");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            Spinner sItems = (Spinner) findViewById(R.id.sp_name);
            sItems.setAdapter(adapter);
        }
       radiokadarabu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-0.5%");
                spinnerArray.add("0.5%-1%");
                spinnerArray.add("1%-1.5%");
                spinnerArray.add("1.5%-2%");
                spinnerArray.add("2%-2.5%");
                spinnerArray.add("2.5%-3%");
                spinnerArray.add("3%-3.5%");
                spinnerArray.add("3.5%-4%");
                spinnerArray.add("4%-4.5%");
                spinnerArray.add("4.5%-5%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                String selected = sItems.getSelectedItem().toString();
                if(selected.equals("0.1%-0.5%")){
                    a="0.1";
                    b="0.5";
                }else if(selected.equals("0.5%-1%")){
                    Toast.makeText(KarakteristikActivity.this,"AAA",Toast.LENGTH_LONG).show();
                }else if(sItems.getSelectedItem() == "1%-1.5%"){
                    a="1";
                    b="1.5";
                }else if(sItems.getSelectedItem() == "1.5%-2%"){
                    a="1.5";
                    b="2";
                }else if(sItems.getSelectedItem() == "2%-2.5%"){
                    a="2";
                    b="2.5";
                }else if(sItems.getSelectedItem() == "2.5%-3%"){
                    a="2.5";
                    b="3";
                }else if(sItems.getSelectedItem() == "3%-3.5%"){
                    a="3";
                    b="3.5";
                }else if(sItems.getSelectedItem() == "3.5%-4%"){
                    a="3.5";
                    b="4";
                }else if(sItems.getSelectedItem() == "4%-4.5%"){
                    a="4";
                    b="4.5";
                }else if(sItems.getSelectedItem() == "4.5%-5%"){
                    a="4.5";
                    b="5";
                }

            }
        });

        radiokadarair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-10%");
                spinnerArray.add("10%-20%");
                spinnerArray.add("20%-30%");
                spinnerArray.add("30%-40%");
                spinnerArray.add("40%-50%");
                spinnerArray.add("50%-60%");
                spinnerArray.add("60%-70%");
                spinnerArray.add("70%-80%");
                spinnerArray.add("80%-90%");
                spinnerArray.add("90%-100%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                if(sItems.getSelectedItem().toString() == "0.1%-10%"){
                    a="0.1";
                    b="10";
                }else if(sItems.getSelectedItem().toString() == "10%-20%"){
                    a="10";
                    b="20";
                }else if(sItems.getSelectedItem() == "20%-30%"){
                    a="20";
                    b="30";
                }else if(sItems.getSelectedItem() == "30%-40%"){
                    a="30";
                    b="40";
                }else if(sItems.getSelectedItem() == "40%-50%"){
                    a="40";
                    b="50";
                }else if(sItems.getSelectedItem() == "50%-60%"){
                    a="50";
                    b="60";
                }else if(sItems.getSelectedItem() == "60%-70%"){
                    a="60";
                    b="70";
                }else if(sItems.getSelectedItem() == "70%-80%"){
                    a="70";
                    b="80";
                }else if(sItems.getSelectedItem() == "80%-90%"){
                    a="80";
                    b="90";
                }else{
                    a="90";
                    b="100";
                }

            }
        });

        radioprotein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-5%");
                spinnerArray.add("5%-10%");
                spinnerArray.add("10%-15%");
                spinnerArray.add("15%-20%");
                spinnerArray.add("20%-25%");
                spinnerArray.add("25%-30%");
                spinnerArray.add("30%-35%");
                spinnerArray.add("35%-40%");
                spinnerArray.add("40%-45%");
                spinnerArray.add("45%-50%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                if(sItems.getSelectedItem() == "0.1%-5%"){
                    a="0.1";
                    b="5";
                }else if(sItems.getSelectedItem() == "5%-10%"){
                    a="5";
                    b="10";
                }else if(sItems.getSelectedItem() == "10%-15%"){
                    a="10";
                    b="15";
                }else if(sItems.getSelectedItem() == "15%-20%"){
                    a="15";
                    b="20";
                }else if(sItems.getSelectedItem() == "20%-25%"){
                    a="20";
                    b="25";
                }else if(sItems.getSelectedItem() == "25%-30%"){
                    a="25";
                    b="30";
                }else if(sItems.getSelectedItem() == "30%-35%"){
                    a="30";
                    b="35";
                }else if(sItems.getSelectedItem() == "35%-40%"){
                    a="35";
                    b="40";
                }else if(sItems.getSelectedItem() == "40%-45%"){
                    a="40";
                    b="45";
                }else{
                    a="45";
                    b="50";
                }
            }
        });

        radiokarbohidrat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-7%");
                spinnerArray.add("7%-14%");
                spinnerArray.add("14%-21%");
                spinnerArray.add("21%-28%");
                spinnerArray.add("28%-35%");
                spinnerArray.add("35%-42%");
                spinnerArray.add("42%-49%");
                spinnerArray.add("49%-56%");
                spinnerArray.add("56%-63%");
                spinnerArray.add("63%-70%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                if(sItems.getSelectedItem() == "0.1%-7%"){
                    a="0.1";
                    b="7";
                }else if(sItems.getSelectedItem() == "7%-14%"){
                    a="7";
                    b="14";
                }else if(sItems.getSelectedItem() == "14%-21%"){
                    a="14";
                    b="21";
                }else if(sItems.getSelectedItem() == "21%-28%"){
                    a="21";
                    b="28";
                }else if(sItems.getSelectedItem() == "28%-35%"){
                    a="28";
                    b="35";
                }else if(sItems.getSelectedItem() == "35%-42%"){
                    a="35";
                    b="42";
                }else if(sItems.getSelectedItem() == "42%-49%"){
                    a="42";
                    b="49";
                }else if(sItems.getSelectedItem() == "49%-56%"){
                    a="49";
                    b="56";
                }else if(sItems.getSelectedItem() == "56%-63%"){
                    a="56";
                    b="63";
                }else{
                    a="63";
                    b="70";
                }
            }
        });

        radiolemak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-5%");
                spinnerArray.add("5%-10%");
                spinnerArray.add("10%-15%");
                spinnerArray.add("15%-20%");
                spinnerArray.add("20%-25%");
                spinnerArray.add("25%-30%");
                spinnerArray.add("30%-35%");
                spinnerArray.add("35%-40%");
                spinnerArray.add("40%-45%");
                spinnerArray.add("45%-50%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                if(sItems.getSelectedItem() == "0.1%-5%"){
                    a="0.1";
                    b="5";
                }else if(sItems.getSelectedItem() == "5%-10%"){
                    a="5";
                    b="10";
                }else if(sItems.getSelectedItem() == "10%-15%"){
                    a="10";
                    b="15";
                }else if(sItems.getSelectedItem() == "15%-20%"){
                    a="15";
                    b="20";
                }else if(sItems.getSelectedItem() == "20%-25%"){
                    a="20";
                    b="25";
                }else if(sItems.getSelectedItem() == "25%-30%"){
                    a="25";
                    b="30";
                }else if(sItems.getSelectedItem() == "30%-35%"){
                    a="30";
                    b="35";
                }else if(sItems.getSelectedItem() == "35%-40%"){
                    a="35";
                    b="40";
                }else if(sItems.getSelectedItem() == "40%-45%"){
                    a="40";
                    b="45";
                }else{
                    a="45";
                    b="50";
                }
            }
        });

        radioenergi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> spinnerArray =  new ArrayList<String>();
                spinnerArray.add("0.1%-70%");
                spinnerArray.add("70%-140%");
                spinnerArray.add("140%-210%");
                spinnerArray.add("210%-280%");
                spinnerArray.add("280%-350%");
                spinnerArray.add("350%-420%");
                spinnerArray.add("420%-490%");
                spinnerArray.add("490%-560%");
                spinnerArray.add("560%-630%");
                spinnerArray.add("630%-700%");

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        KarakteristikActivity.this, android.R.layout.simple_spinner_item, spinnerArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                final Spinner sItems = (Spinner) findViewById(R.id.sp_name);
                sItems.setAdapter(adapter);
                if(sItems.getSelectedItem() == "0.1%-70%"){
                    a="0.1";
                    b="70";
                }else if(sItems.getSelectedItem() == "70%-140%"){
                    a="70";
                    b="140";
                }else if(sItems.getSelectedItem() == "140%-210%"){
                    a="140";
                    b="210";
                }else if(sItems.getSelectedItem() == "210%-280%"){
                    a="210";
                    b="280";
                }else if(sItems.getSelectedItem() == "280%-350%"){
                    a="280";
                    b="350";
                }else if(sItems.getSelectedItem() == "350%-420%"){
                    a="350";
                    b="420";
                }else if(sItems.getSelectedItem() == "420%-490%"){
                    a="420";
                    b="490";
                }else if(sItems.getSelectedItem() == "490%-560%"){
                    a="490";
                    b="560";
                }else if(sItems.getSelectedItem() == "560%-630%"){
                    a="560";
                    b="630";
                }else{
                    a="630";
                    b="700";
                }
            }
        });*/
