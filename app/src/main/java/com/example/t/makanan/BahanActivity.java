package com.example.t.makanan;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BahanActivity extends AppCompatActivity {

    MakananActivity makananActivity = new MakananActivity();
    public Spinner spNamen;
    ArrayList<Model> arrayMakanan = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bahan);
        Button btSpinner = (Button) findViewById(R.id.bt_check);
        spNamen = (Spinner) findViewById(R.id.sp_name);


        btSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bahan = spNamen.getSelectedItem().toString();
                Intent intent = new Intent(BahanActivity.this, HasilActivity.class);
                intent.putExtra("bahan",bahan);
                startActivity(intent);

            }
        });
    }
}
