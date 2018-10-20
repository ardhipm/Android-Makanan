package com.example.t.makanan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    TextView nama, asal, bahan,kemasan,ph,akAir,nilSteril,kadAir,kadAbu,protein,lemak,karbohidrat,energi,timbalpb,kadmium,tembaga,
    seng,timahsn,raksa,arsen,alt,aerob,coliform,salmonella,saureus,perfingens,anaerob,bacilius,aflatoksin,aflatoksinTotal,
    frakLarut, mitUkm,kondProses;
    TextView username,password;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;
    ImageView fotoProduk;
    Button hapus,edit;

    MakananActivity makananActivity = new MakananActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final String no = getIntent().getExtras().getString("no");
        final String nama_makanan = getIntent().getExtras().getString("nama_makanan");
        final String asall = getIntent().getExtras().getString("asal");
        final String bahan_utama= getIntent().getExtras().getString("bahan_utama");
        final String kemasann = getIntent().getExtras().getString("kemasan");
        final String phh = getIntent().getExtras().getString("ph");
        final String aktivitas_air = getIntent().getExtras().getString("aktivitas_air");
        final String nilai_sterilitas = getIntent().getExtras().getString("nilai_sterilitas");
        final String kadar_air = getIntent().getExtras().getString("kadar_air");
        final String kadar_abu = getIntent().getExtras().getString("kadar_abu");
        final String proteinn = getIntent().getExtras().getString("protein");
        final String lemakk = getIntent().getExtras().getString("lemak");
        final String karbohidratt = getIntent().getExtras().getString("karbohidrat");
        final String energii = getIntent().getExtras().getString("energi");
        final String timbalpbb = getIntent().getExtras().getString("timbalpb");
        final String kadmiumm = getIntent().getExtras().getString("kadmium");
        final String tembagaa = getIntent().getExtras().getString("tembaga");
        final String sengg = getIntent().getExtras().getString("seng");
        final String timahsnn = getIntent().getExtras().getString("timahsn");
        final String raksaa = getIntent().getExtras().getString("raksa");
        final String arsenn = getIntent().getExtras().getString("arsen");
        final String altt = getIntent().getExtras().getString("alt");
        final String aerobb = getIntent().getExtras().getString("aerob");
        final String coliformm = getIntent().getExtras().getString("coliform");
        final String salmonellaa = getIntent().getExtras().getString("salmonella");
        final String saureuss = getIntent().getExtras().getString("saureus");
        final String perfringenss = getIntent().getExtras().getString("perfringens");
        final String anaerobb = getIntent().getExtras().getString("anaerob");
        final String baciliuss = getIntent().getExtras().getString("bacilius");
        final String aflatoksinn = getIntent().getExtras().getString("aflatoksin");
        final String aflatoksin_total = getIntent().getExtras().getString("aflatoksin_total");
        final String fraksi_larut = getIntent().getExtras().getString("fraksi_larut");
        final String mitra_ukm = getIntent().getExtras().getString("mitra_ukm");
        final String foto_produk = getIntent().getExtras().getString("foto_produk");
        final String kondisi_proses = getIntent().getExtras().getString("kondisi_proses");

        nama = findViewById(R.id.txtNama);
        asal = findViewById(R.id.txtAsal);
        bahan = findViewById(R.id.txtBahan);
        kemasan = findViewById(R.id.txtKemasan);
        ph = findViewById(R.id.txtPh);
        akAir = findViewById(R.id.txtAktivitasAir);
        nilSteril = findViewById(R.id.txtNilaiSterilitas);
        kadAir = findViewById(R.id.txtKadarAir);
        kadAbu = findViewById(R.id.txtKadarAbu);
        protein = findViewById(R.id.txtProtein);
        lemak = findViewById(R.id.txtLemak);
        karbohidrat = findViewById(R.id.txtKarbohidrat);
        energi = findViewById(R.id.txtEnergi);
        timbalpb = findViewById(R.id.txtTimbalPb);
        kadmium = findViewById(R.id.txtKadmium);
        tembaga = findViewById(R.id.txtTembaga);
        seng = findViewById(R.id.txtSeng);
        timahsn = findViewById(R.id.txtTimahSn);
        raksa = findViewById(R.id.txtRaksa);
        arsen = findViewById(R.id.txtArsen);
        alt = findViewById(R.id.txtAlt);
        aerob = findViewById(R.id.txtAerob);
        coliform = findViewById(R.id.txtColiform);
        salmonella = findViewById(R.id.txtSalmonella);
        saureus = findViewById(R.id.txtSaureus);
        perfingens = findViewById(R.id.txtPerfringens);
        anaerob = findViewById(R.id.txtAnaerob);
        bacilius = findViewById(R.id.txtBacilius);
        aflatoksin = findViewById(R.id.txtAflatoksin);
        aflatoksinTotal = findViewById(R.id.txtAflatoksinTotal);
        frakLarut = findViewById(R.id.txtFraksi);
        mitUkm = findViewById(R.id.txtMitra);
        fotoProduk = findViewById(R.id.imgMakanan);
        kondProses = findViewById(R.id.txtKondisiProses);
        hapus = findViewById(R.id.btnHapus);
        edit = findViewById(R.id.btnEdit);

        nama.setText(nama_makanan);
        bahan.setText(bahan_utama);
        asal.setText(asall);
        kemasan.setText(kemasann);
        ph.setText(phh);
        akAir.setText(aktivitas_air);
        nilSteril.setText(nilai_sterilitas);
        kadAir.setText(kadar_air);
        kadAbu.setText(kadar_abu);
        protein.setText(proteinn);
        lemak.setText(lemakk);
        karbohidrat.setText(karbohidratt);
        energi.setText(energii);
        timbalpb.setText(timbalpbb);
        kadmium.setText(kadmiumm);
        tembaga.setText(tembagaa);
        seng.setText(sengg);
        timahsn.setText(timahsnn);
        raksa.setText(raksaa);
        arsen.setText(arsenn);
        alt.setText(altt);
        aerob.setText(aerobb);
        coliform.setText(coliformm);
        salmonella.setText(salmonellaa);
        saureus.setText(saureuss);
        perfingens.setText(perfringenss);
        anaerob.setText(anaerobb);
        bacilius.setText(baciliuss);
        aflatoksin.setText(aflatoksinn);
        aflatoksinTotal.setText(aflatoksin_total);
        frakLarut.setText(fraksi_larut);
        mitUkm.setText(mitra_ukm);
        kondProses.setText(kondisi_proses);
        Glide.with(this).load(foto_produk).into(fotoProduk);

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(DetailActivity.this);
                inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialog, null);
                dialog.setView(dialogView);
                dialog.setCancelable(true);
                dialog.setTitle("Login");

                username = dialogView.findViewById(R.id.username);
                password = dialogView.findViewById(R.id.password);
                dialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();
                        if ((user.contains("admin"))&&((pass.contains("admin")))) {
                            String laporan = makananActivity.deleteMakanan(no);
                            Toast.makeText(DetailActivity.this,laporan,Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(DetailActivity.this, MenuActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(DetailActivity.this,"Gagal Login",Toast.LENGTH_LONG).show();
                            username.setText(null);
                            password.setText(null);
                        }
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new AlertDialog.Builder(DetailActivity.this);
                inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.dialog, null);
                dialog.setView(dialogView);
                dialog.setCancelable(true);
                dialog.setTitle("Login");

                username = dialogView.findViewById(R.id.username);
                password = dialogView.findViewById(R.id.password);
                dialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();
                        if ((user.contains("admin"))&&((pass.contains("admin")))) {
                            Intent intent = new Intent(DetailActivity.this, UpdateActivity.class);
                            intent.putExtra("no", no);
                            intent.putExtra("nama_makanan",nama_makanan);
                            intent.putExtra("asal", asall);
                            intent.putExtra("bahan_utama",bahan_utama);
                            intent.putExtra("kemasan", kemasann);
                            intent.putExtra("ph", phh);
                            intent.putExtra("aktivitas_air",aktivitas_air);
                            intent.putExtra("nilai_sterilitas",nilai_sterilitas);
                            intent.putExtra("kadar_air",kadar_air);
                            intent.putExtra("kadar_abu",kadar_abu);
                            intent.putExtra("protein",proteinn);
                            intent.putExtra("lemak",lemakk);
                            intent.putExtra("karbohidrat",karbohidratt);
                            intent.putExtra("energi",energii);
                            intent.putExtra("timbalpb",timbalpbb);
                            intent.putExtra("kadmium",kadmiumm);
                            intent.putExtra("tembaga",tembagaa);
                            intent.putExtra("seng",sengg);
                            intent.putExtra("timahsn",timahsnn);
                            intent.putExtra("raksa",raksaa);
                            intent.putExtra("arsen",arsenn);
                            intent.putExtra("alt",altt);
                            intent.putExtra("aerob",aerobb);
                            intent.putExtra("coliform",coliformm);
                            intent.putExtra("salmonella",salmonellaa);
                            intent.putExtra("saureus",saureuss);
                            intent.putExtra("perfringens",perfringenss);
                            intent.putExtra("anaerob", anaerobb);
                            intent.putExtra("bacilius", baciliuss);
                            intent.putExtra("aflatoksin", aflatoksinn);
                            intent.putExtra("aflatoksin_total", aflatoksin_total);
                            intent.putExtra("fraksi_larut", fraksi_larut);
                            intent.putExtra("mitra_ukm", mitra_ukm);
                            intent.putExtra("foto_produk",foto_produk);
                            intent.putExtra("kondisi_proses", kondisi_proses);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(DetailActivity.this,"Gagal Login",Toast.LENGTH_LONG).show();
                            username.setText(null);
                            password.setText(null);
                        }
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }
}
