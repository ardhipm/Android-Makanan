package com.example.t.makanan;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HasilActivity extends AppCompatActivity {
    MakananActivity makananActivity = new MakananActivity();
    ArrayList<Model> arrayMakanan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        final ListView lv = findViewById(R.id.listView);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        final String bahan = getIntent().getExtras().getString("bahan");
        class Tambah extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(HasilActivity.this, "Menampilkan Data...", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                final Adapter adapter = new Adapter(HasilActivity.this, arrayMakanan);
                lv.setAdapter(adapter);
            }

            @Override
            protected String doInBackground(String... bitmaps) {
                try {
                    JSONArray jsonArray = new JSONArray(makananActivity.getMakananByBahan(bahan));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String no = obj.getString("no");
                        String nama_makanan = obj.getString("nama_makanan");
                        String asal = obj.getString("asal");
                        String bahan_utama = obj.getString("bahan_utama");
                        String kemasan = obj.getString("kemasan");
                        String ph = obj.getString("ph");
                        String aktivitas_air = obj.getString("aktivitas_air");
                        String nilai_sterilitas = obj.getString("nilai_sterilitas");
                        String kadar_air = obj.getString("kadar_air");
                        String kadar_abu = obj.getString("kadar_abu");
                        String protein = obj.getString("protein");
                        String lemak = obj.getString("lemak");
                        String karbohidrat = obj.getString("karbohidrat");
                        String energi = obj.getString("energi");
                        String timbalpb = obj.getString("timbalpb");
                        String kadmium = obj.getString("kadmium");
                        String tembaga = obj.getString("tembaga");
                        String seng = obj.getString("seng");
                        String timahsn = obj.getString("timahsn");
                        String raksa = obj.getString("raksa");
                        String arsen = obj.getString("arsen");
                        String alt = obj.getString("alt");
                        String aerob = obj.getString("aerob");
                        String coliform = obj.getString("coliform");
                        String salmonella = obj.getString("salmonella");
                        String saureus = obj.getString("saureus");
                        String perfringens = obj.getString("perfringens");
                        String anaerob = obj.getString("anaerob");
                        String bacilius = obj.getString("bacilius");
                        String aflatoksin = obj.getString("aflatoksin");
                        String aflatoksin_total = obj.getString("aflatoksin_total");
                        String fraksi_larut = obj.getString("fraksi_larut");
                        String mitra_ukm = obj.getString("mitra_ukm");
                        String foto_produk = obj.getString("foto_produk");
                        String kondisi_proses = obj.getString("kondisi_proses");
                        arrayMakanan.add(new Model(no, nama_makanan,asal,bahan_utama,kemasan,ph,aktivitas_air,nilai_sterilitas,kadar_air,kadar_abu,
                                protein,lemak,karbohidrat,energi,timbalpb,kadmium,tembaga,seng,timahsn,raksa,arsen,alt,aerob,coliform,salmonella,
                                saureus,perfringens,anaerob,bacilius,aflatoksin,aflatoksin_total,fraksi_larut,mitra_ukm,foto_produk,kondisi_proses));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        Tambah tbh = new Tambah();
        tbh.execute();




    }
}
