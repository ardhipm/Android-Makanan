package com.example.t.makanan;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    MakananActivity makananActivity = new MakananActivity();
    Button simpan;
    String laporan;
    String snama_makanan,	sasal,	sbahan_utama,	skemasan,
            sph,	saktivitas_air,	snilai_sterilitas,	skadar_air,	skadar_abu,	sprotein,	slemak,	skarbohidrat,	senergi,
            stimbalpb,	skadmium,	stembaga,	sseng,	stimahsn,	sraksa,	sarsen,	salt,	saerob,	scoliform,	ssalmonella,
            ssaureus,	sperfringens,	sanaerob,	sbacilius,	saflatoksin,	saflatoksin_total,	sfraksi_larut,	smitra_ukm,
            skondisi_proses, suploadimage;

    EditText nama_makanan,	asal,	bahan_utama,	kemasan,
            ph,	aktivitas_air,	nilai_sterilitas,	kadar_air,	kadar_abu,	protein,	lemak,	karbohidrat,	energi,
            timbalpb,	kadmium,	tembaga,	seng,	timahsn,	raksa,	arsen,	alt,	aerob,	coliform,	salmonella,
            saureus,	perfringens,	anaerob,	bacilius,	aflatoksin,	aflatoksin_total,	fraksi_larut,	mitra_ukm, foto_produk, kondisi_proses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final String no = getIntent().getExtras().getString("no");
        String nama_makanann = getIntent().getExtras().getString("nama_makanan");
        String asall = getIntent().getExtras().getString("asal");
        String bahan_utamaa= getIntent().getExtras().getString("bahan_utama");
        String kemasann = getIntent().getExtras().getString("kemasan");
        String phh = getIntent().getExtras().getString("ph");
        String aktivitas_airr = getIntent().getExtras().getString("aktivitas_air");
        String nilai_sterilitass = getIntent().getExtras().getString("nilai_sterilitas");
        String kadar_airr = getIntent().getExtras().getString("kadar_air");
        String kadar_abuu = getIntent().getExtras().getString("kadar_abu");
        String proteinn = getIntent().getExtras().getString("protein");
        String lemakk = getIntent().getExtras().getString("lemak");
        String karbohidratt = getIntent().getExtras().getString("karbohidrat");
        String energii = getIntent().getExtras().getString("energi");
        String timbalpbb = getIntent().getExtras().getString("timbalpb");
        String kadmiumm = getIntent().getExtras().getString("kadmium");
        String tembagaa = getIntent().getExtras().getString("tembaga");
        String sengg = getIntent().getExtras().getString("seng");
        String timahsnn = getIntent().getExtras().getString("timahsn");
        String raksaa = getIntent().getExtras().getString("raksa");
        String arsenn = getIntent().getExtras().getString("arsen");
        String altt = getIntent().getExtras().getString("alt");
        String aerobb = getIntent().getExtras().getString("aerob");
        String coliformm = getIntent().getExtras().getString("coliform");
        String salmonellaa = getIntent().getExtras().getString("salmonella");
        String saureuss = getIntent().getExtras().getString("saureus");
        String perfringenss = getIntent().getExtras().getString("perfringens");
        String anaerobb = getIntent().getExtras().getString("anaerob");
        String baciliuss = getIntent().getExtras().getString("bacilius");
        String aflatoksinn = getIntent().getExtras().getString("aflatoksin");
        String aflatoksin_totall = getIntent().getExtras().getString("aflatoksin_total");
        String fraksi_larutt = getIntent().getExtras().getString("fraksi_larut");
        String mitra_ukmm = getIntent().getExtras().getString("mitra_ukm");
        String foto_produkk = getIntent().getExtras().getString("foto_produk");
        String kondisi_prosess = getIntent().getExtras().getString("kondisi_proses");

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

        simpan = findViewById(R.id.simpan_button);

        nama_makanan.setText(nama_makanann);
        asal.setText(asall);
        bahan_utama.setText(bahan_utamaa);
        kemasan.setText(kemasann);
        ph.setText(phh);
        aktivitas_air.setText(aktivitas_airr);
        nilai_sterilitas.setText(nilai_sterilitass);
        kadar_air.setText(kadar_airr);
        kadar_abu.setText(kadar_abuu);
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
        perfringens.setText(perfringenss);
        anaerob.setText(anaerobb);
        bacilius.setText(baciliuss);
        aflatoksin.setText(aflatoksinn);
        aflatoksin_total.setText(aflatoksin_totall);
        fraksi_larut.setText(fraksi_larutt);
        mitra_ukm.setText(mitra_ukmm);
        kondisi_proses.setText(kondisi_prosess);
        foto_produk.setText(foto_produkk);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                class Update extends AsyncTask<String,Void,String> {
                    ProgressDialog loading;

                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        loading = ProgressDialog.show(UpdateActivity.this, "Mohon Tunggu...", null,true,true);
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        loading.dismiss();
                        Toast.makeText(UpdateActivity.this, laporan, Toast.LENGTH_LONG).show();
                        startActivity(new Intent(UpdateActivity.this, MenuActivity.class));
                        finish();
                    }

                    @Override
                    protected String doInBackground(String... bitmaps) {
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

                        laporan = makananActivity.updateMakanan(no, snama_makanan,	sasal,	sbahan_utama,	skemasan,
                                sph,	saktivitas_air,	snilai_sterilitas,	skadar_air,	skadar_abu,	sprotein,	slemak,	skarbohidrat,	senergi,
                                stimbalpb,	skadmium,	stembaga,	sseng,	stimahsn,	sraksa,	sarsen,	salt,	saerob,	scoliform,	ssalmonella,
                                ssaureus,	sperfringens,	sanaerob,	sbacilius,	saflatoksin,	saflatoksin_total,	sfraksi_larut,	smitra_ukm,
                                suploadimage, skondisi_proses);
                        return laporan;
                    }
                }
                Update tbh = new Update();
                tbh.execute(laporan);
            }
            });
        }

    }



