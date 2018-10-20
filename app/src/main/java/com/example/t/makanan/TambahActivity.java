package com.example.t.makanan;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.Permissions;
import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class TambahActivity extends AppCompatActivity implements View.OnClickListener {
    Button simpan;
    ImageView gambarupload;
    Bitmap bitmap, decoded;
    Uri filePath;
    int PICK_IMAGE_REQUEST = 1;
    String laporan;
    MakananActivity makananActivity = new MakananActivity();
    EditText nama_makanan,	asal,	bahan_utama,	kemasan,
            ph,	aktivitas_air,	nilai_sterilitas,	kadar_air,	kadar_abu,	protein,	lemak,	karbohidrat,	energi,
            timbalpb,	kadmium,	tembaga,	seng,	timahsn,	raksa,	arsen,	alt,	aerob,	coliform,	salmonella,
            saureus,	perfringens,	anaerob,	bacilius,	aflatoksin,	aflatoksin_total,	fraksi_larut,	mitra_ukm, foto_produk, kondisi_proses;

    String snama_makanan,	sasal,	sbahan_utama,	skemasan,
            sph,	saktivitas_air,	snilai_sterilitas,	skadar_air,	skadar_abu,	sprotein,	slemak,	skarbohidrat,	senergi,
            stimbalpb,	skadmium,	stembaga,	sseng,	stimahsn,	sraksa,	sarsen,	salt,	saerob,	scoliform,	ssalmonella,
            ssaureus,	sperfringens,	sanaerob,	sbacilius,	saflatoksin,	saflatoksin_total,	sfraksi_larut,	smitra_ukm,
            skondisi_proses, suploadimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        simpan = findViewById(R.id.simpan_button);


        simpan.setOnClickListener(this);

        nama_makanan = findViewById(R.id.input_nama);
        asal = findViewById(R.id.input_asal);
        bahan_utama = findViewById(R.id.input_bahan);
        kemasan = findViewById(R.id.input_kemasan);
        ph = findViewById(R.id.input_ph);
        aktivitas_air = findViewById(R.id.input_aktivitasair);
        nilai_sterilitas = findViewById(R.id.input_nilsterilitas);
        kadar_air = findViewById(R.id.input_kadair);
        kadar_abu = findViewById(R.id.input_kadabu);
        protein = findViewById(R.id.input_protein);
        lemak = findViewById(R.id.input_lemak);
        karbohidrat = findViewById(R.id.input_karbohidrat);
        energi = findViewById(R.id.input_energi);
        timbalpb = findViewById(R.id.input_timbal);
        kadmium = findViewById(R.id.input_kadmium);
        tembaga = findViewById(R.id.input_tembaga);
        seng = findViewById(R.id.input_seng);
        timahsn = findViewById(R.id.input_timah);
        raksa = findViewById(R.id.input_raksa);
        arsen = findViewById(R.id.input_arsen);
        alt = findViewById(R.id.input_alt);
        aerob = findViewById(R.id.input_aerob);
        coliform = findViewById(R.id.input_coliform);
        salmonella = findViewById(R.id.input_salmonella);
        saureus = findViewById(R.id.input_saureus);
        perfringens = findViewById(R.id.input_perfringens);
        anaerob = findViewById(R.id.input_anaerob);
        bacilius = findViewById(R.id.input_bacilius);
        aflatoksin = findViewById(R.id.input_aflatoksin);
        aflatoksin_total = findViewById(R.id.input_aflatoksintot);
        fraksi_larut = findViewById(R.id.input_fraksilarut);
        mitra_ukm = findViewById(R.id.input_mitraukm);
        kondisi_proses = findViewById(R.id.input_kondisi);
        foto_produk = findViewById(R.id.input_foto_produk);



    }

    @Override
    public void onClick(View v) {
        if(v == simpan){
            snama_makanan = nama_makanan.getText().toString();
            sasal = asal.getText().toString();
            sbahan_utama = bahan_utama.getText().toString();
            skemasan = kemasan.getText().toString();
            sph = ph.getText().toString();
            saktivitas_air = aktivitas_air.getText().toString();
            snilai_sterilitas = nilai_sterilitas.getText().toString();
            skadar_air = kadar_air.getText().toString();
            skadar_abu = kadar_abu.getText().toString();
            sprotein = protein.getText().toString();
            slemak = lemak.getText().toString();
            skarbohidrat = karbohidrat.getText().toString();
            senergi = energi.getText().toString();
            stimbalpb = timbalpb.getText().toString();
            skadmium = kadmium.getText().toString();
            stembaga = tembaga.getText().toString();
            sseng = seng.getText().toString();
            stimahsn = timahsn.getText().toString();
            sraksa = raksa.getText().toString();
            sarsen = arsen.getText().toString();
            salt = alt.getText().toString();
            saerob = aerob.getText().toString();
            scoliform = coliform.getText().toString();
            ssalmonella = salmonella.getText().toString();
            ssaureus = saureus.getText().toString();
            sperfringens = perfringens.getText().toString();
            sanaerob = anaerob.getText().toString();
            sbacilius = bacilius.getText().toString();
            saflatoksin = aflatoksin.getText().toString();
            saflatoksin_total = aflatoksin_total.getText().toString();
            sfraksi_larut = fraksi_larut.getText().toString();
            smitra_ukm = mitra_ukm.getText().toString();
            skondisi_proses = kondisi_proses.getText().toString();
            suploadimage = foto_produk.getText().toString();

            class Tambah extends AsyncTask<String,Void,String>{
                ProgressDialog loading;

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();
                    loading = ProgressDialog.show(TambahActivity.this, "Mohon Tunggu...", null,true,true);
                }

                @Override
                protected void onPostExecute(String s) {
                    super.onPostExecute(s);
                    loading.dismiss();
                    Toast.makeText(TambahActivity.this, laporan, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(TambahActivity.this, MenuActivity.class));
                    finish();
                }

                @Override
                protected String doInBackground(String... bitmaps) {
                    if (!snama_makanan.isEmpty() & !sasal.isEmpty() & !sbahan_utama.isEmpty() & !skemasan.isEmpty() & !smitra_ukm.isEmpty()) {
                        laporan = makananActivity.insertMakanan(snama_makanan, sasal, sbahan_utama, skemasan,
                                sph, saktivitas_air, snilai_sterilitas, skadar_air, skadar_abu, sprotein, slemak, skarbohidrat, senergi,
                                stimbalpb, skadmium, stembaga, sseng, stimahsn, sraksa, sarsen, salt, saerob, scoliform, ssalmonella,
                                ssaureus, sperfringens, sanaerob, sbacilius, saflatoksin, saflatoksin_total, sfraksi_larut, smitra_ukm, suploadimage,
                                skondisi_proses);
                    } else if (snama_makanan.isEmpty()) {
                        nama_makanan.setError("Nama Makanan Harus Diisi");
                    } else if (sasal.isEmpty()) {
                        asal.setError("Asal Makanan Harus Diisi");
                    } else if (sbahan_utama.isEmpty()) {
                        bahan_utama.setError("Bahan Makanan Harus Diisi");
                    } else if (skemasan.isEmpty()) {
                        kemasan.setError("Kemasan Makanan Harus Diisi");
                    } else if (smitra_ukm.isEmpty()) {
                        mitra_ukm.setError("Mitra UKM Harus Diisi");
                    }
                    return laporan;
                }
            }
            Tambah tbh = new Tambah();
            tbh.execute(laporan);
        }
    }

    /*private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                gambarupload.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        suploadimage = getStringImage(bitmap);
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 60, baos);
        byte [] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void setToImageView(Bitmap bmp){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG,60, bytes);
        decoded = BitmapFactory.decodeStream(new ByteArrayInputStream(bytes.toByteArray()));
        gambarupload.setImageBitmap(decoded);
    }


    public Bitmap getResizedBitmap(Bitmap image, int maxSize){
        int width = image.getWidth();
        int height = image.getHeight();

        float bitMapRatio = (float)width/(float)height;
        if (bitMapRatio > 1){
            width = maxSize;
            height = (int) (width / bitMapRatio);
        }else {
            height = maxSize;
            width = (int)(height * bitMapRatio);
        }
        return Bitmap.createScaledBitmap(image, width,height,true);
    }

        /*class UploadImage extends AsyncTask<Bitmap,Void,String>{
            ProgressDialog loading;
            KoneksiActivity ka = new KoneksiActivity();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TambahActivity.this, "Uploading Image", "Please Wait...",true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... bitmaps) {
                Bitmap bitmap = bitmaps[0];
                String uploadImage = getStringImage(bitmap);

            }
        }
        UploadImage ui = new UploadImage();
        ui.execute(bitmap);*/
    }



