package com.example.t.makanan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

/**
 * Created by t on 8/28/2018.
 */

public class Pager extends Fragment {
    RadioGroup radioKarakteristikGroup;
    RadioButton radioKarakteristikButton,radiokadarabu,radiokadarair,radioprotein,radiokarbohidrat,radiolemak,radioenergi;
    EditText jangkAwal, jangkAkhir;
    Button submit;
    int selectedId;
    String karakteristik;
    JSONArray jsonArray,jsonArray1,jsonArray2;
    int currentPage;
    MakananActivity makananActivity = new MakananActivity();
    ArrayList<Model> arrayMakanan = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Bundle data = getArguments();
        currentPage = data.getInt("current_page",0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = null;

        if (currentPage == 1) {
            v = inflater.inflate(R.layout.activity_bahan, container, false);
            Button btSpinner = (Button) v.findViewById(R.id.bt_check);
            final Spinner spNamen = (Spinner) v.findViewById(R.id.sp_name);

            btSpinner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String bahan = spNamen.getSelectedItem().toString();
                    final String replaced = bahan.replace(" ", "%20");

                    class Tambah extends AsyncTask<String,Void,String> {
                        ProgressDialog loading;

                        @Override
                        protected void onPreExecute() {
                            super.onPreExecute();
                            loading = ProgressDialog.show(getActivity(), "Mencari Data...", null,true,true);
                        }

                        @Override
                        protected void onPostExecute(String s) {
                            super.onPostExecute(s);
                            loading.dismiss();
                        }

                        @Override
                        protected String doInBackground(String... bitmaps) {
                            JSONArray jsonArray = null;
                            try {
                                jsonArray = new JSONArray(makananActivity.getMakananByBahan(replaced));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            if (jsonArray.length() > 0) {
                                Intent intent = new Intent(getActivity(), HasilActivity.class);
                                intent.putExtra("bahan", replaced);
                                startActivity(intent);
                            } else if (jsonArray.length() == 0) {
                                startActivity(new Intent(getActivity(), NotFoundActivity.class));
                            }
                            return null;
                        }
                    }
                    Tambah tbh = new Tambah();
                    tbh.execute();
                }
            });
        } else if (currentPage == 2) {
            v = inflater.inflate(R.layout.activity_karakteristik, container, false);
            radioKarakteristikGroup = v.findViewById(R.id.radioGroup);
            jangkAwal = v.findViewById(R.id.edtAwal);
            jangkAkhir = v.findViewById(R.id.edtAkhir);
            submit = v.findViewById(R.id.btnSubmit);
            radiokadarabu = v.findViewById(R.id.radioKadarAbu);
            radiokadarair = v.findViewById(R.id.radioKadarAir);
            radioprotein = v.findViewById(R.id.radioProtein);
            radiokarbohidrat = v.findViewById(R.id.radioKarbohidrat);
            radiolemak = v.findViewById(R.id.radioLemak);
            radioenergi = v.findViewById(R.id.radioEnergi);
            //selectedId = radioKarakteristikGroup.getCheckedRadioButtonId();
            //radioKarakteristikButton = v.findViewById(selectedId);
            //karakteristik = radioKarakteristikButton.getHint().toString();
            radioKarakteristikGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    String max = null;
                    String min = null;
                    if (radiokadarabu.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("kadar_abu"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(kadar_abu)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("kadar_abu"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(kadar_abu)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radiokadarabu.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    } else if (radiokadarair.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("kadar_air"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(kadar_air)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("kadar_air"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(kadar_air)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radiokadarair.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    } else if (radioprotein.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("protein"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(protein)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("protein"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(protein)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radioprotein.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    } else if (radiolemak.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("lemak"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(lemak)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("lemak"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(lemak)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radiolemak.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    } else if (radiokarbohidrat.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("karbohidrat"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(karbohidrat)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("karbohidrat"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(karbohidrat)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radiokarbohidrat.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    } else if (radioenergi.isChecked()) {
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMaxValue("energi"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                max = obj.getString("MAX(energi)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jsonArray1 = new JSONArray(makananActivity.getMinValue("energi"));
                            for (int i = 0; i < jsonArray1.length(); i++) {
                                JSONObject obj = jsonArray1.getJSONObject(i);
                                min = obj.getString("MIN(energi)");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        karakteristik = radioenergi.getHint().toString();
                        Toast.makeText(getActivity(), "DATA MAX: " + max + " Data MIN: " + min, Toast.LENGTH_LONG).show();
                    }
                }
            });

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    String awal = jangkAwal.getText().toString();
                    String akhir = jangkAkhir.getText().toString();

                    try {
                        jsonArray = new JSONArray(makananActivity.getMakananByKarakteristik(karakteristik, awal, akhir));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (jsonArray.length() > 0) {
                        Intent intent = new Intent(getActivity(), Hasil2Activity.class);
                        intent.putExtra("karakteristik", karakteristik);
                        intent.putExtra("awal", awal);
                        intent.putExtra("akhir", akhir);
                        startActivity(intent);
                    } else if (jsonArray.length() == 0) {
                        startActivity(new Intent(getActivity(), NotFoundActivity.class));
                    }
                }
            });

        }
        return v;
    }
}
