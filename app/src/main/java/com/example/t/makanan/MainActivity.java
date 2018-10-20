package com.example.t.makanan;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MakananActivity makananActivity = new MakananActivity();
    ListView listView;
    ArrayList<Model> arrayMakanan = new ArrayList<>();
    final Adapter adapter = new Adapter(MainActivity.this, arrayMakanan);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        listView = findViewById(R.id.listView);
        class Tambah extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this, "Menampilkan Data...", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                listView.setAdapter(adapter);
            }

            @Override
            protected String doInBackground(String... bitmaps) {
                try {
                    JSONArray jsonArray = new JSONArray(makananActivity.tampilMakanan());
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


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String no = adapter.mlist.get(position).getNo();
                String nama_makanan = adapter.mlist.get(position).getNama_makanan();
                String asal = adapter.mlist.get(position).getAsal();
                String bahan_utama = adapter.mlist.get(position).getBahan_utama();
                String kemasan = adapter.mlist.get(position).getKemasan();
                String ph = adapter.mlist.get(position).getPh();
                String aktivitas_air = adapter.mlist.get(position).getAktivitas_air();
                String nilai_sterilitas = adapter.mlist.get(position).getNilai_sterilitas();
                String kadar_air = adapter.mlist.get(position).getKadar_air();
                String kadar_abu = adapter.mlist.get(position).getKadar_abu();
                String protein = adapter.mlist.get(position).getProtein();
                String lemak = adapter.mlist.get(position).getLemak();
                String karbohidrat = adapter.mlist.get(position).getKarbohidrat();
                String energi = adapter.mlist.get(position).getEnergi();
                String timbalpb = adapter.mlist.get(position).getTimbalpb();
                String kadmium = adapter.mlist.get(position).getKadmium();
                String tembaga = adapter.mlist.get(position).getTembaga();
                String seng = adapter.mlist.get(position).getSeng();
                String timahsn =adapter.mlist.get(position).getTimahsn();
                String raksa = adapter.mlist.get(position).getRaksa();
                String arsen = adapter.mlist.get(position).getArsen();
                String alt = adapter.mlist.get(position).getAlt();
                String aerob = adapter.mlist.get(position).getAerob();
                String coliform = adapter.mlist.get(position).getColiform();
                String salmonella = adapter.mlist.get(position).getSalmonella();
                String saureus = adapter.mlist.get(position).getSaureus();
                String perfringens = adapter.mlist.get(position).getPerfringens();
                String anaerob = adapter.mlist.get(position).getAnaerob();
                String bacilius = adapter.mlist.get(position).getBacilius();
                String aflatoksin = adapter.mlist.get(position).getAflatoksin();
                String aflatoksin_total = adapter.mlist.get(position).aflatoksin_total;
                String fraksi_larut = adapter.mlist.get(position).getFraksi_larut();
                String mitra_ukm = adapter.mlist.get(position).getMitra_ukm();
                String foto_produk = adapter.mlist.get(position).getFoto_produk();
                String kondisi_proses = adapter.mlist.get(position).getKondisi_proses();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("no", no);
                intent.putExtra("nama_makanan",nama_makanan);
                intent.putExtra("asal", asal);
                intent.putExtra("bahan_utama",bahan_utama);
                intent.putExtra("kemasan", kemasan);
                intent.putExtra("ph",ph);
                intent.putExtra("aktivitas_air",aktivitas_air);
                intent.putExtra("nilai_sterilitas",nilai_sterilitas);
                intent.putExtra("kadar_air",kadar_air);
                intent.putExtra("kadar_abu",kadar_abu);
                intent.putExtra("protein",protein);
                intent.putExtra("lemak",lemak);
                intent.putExtra("karbohidrat",karbohidrat);
                intent.putExtra("energi",energi);
                intent.putExtra("timbalpb",timbalpb);
                intent.putExtra("kadmium",kadmium);
                intent.putExtra("tembaga",tembaga);
                intent.putExtra("seng",seng);
                intent.putExtra("timahsn",timahsn);
                intent.putExtra("raksa",raksa);
                intent.putExtra("arsen",arsen);
                intent.putExtra("alt",alt);
                intent.putExtra("aerob",aerob);
                intent.putExtra("coliform",coliform);
                intent.putExtra("salmonella",salmonella);
                intent.putExtra("saureus",saureus);
                intent.putExtra("perfringens",perfringens);
                intent.putExtra("anaerob",anaerob);
                intent.putExtra("bacilius",bacilius);
                intent.putExtra("aflatoksin",aflatoksin);
                intent.putExtra("aflatoksin_total",aflatoksin_total);
                intent.putExtra("fraksi_larut",fraksi_larut);
                intent.putExtra("mitra_ukm",mitra_ukm);
                intent.putExtra("foto_produk",foto_produk);
                intent.putExtra("kondisi_proses",kondisi_proses);
                startActivity(intent);
            }
    });
    }
}
