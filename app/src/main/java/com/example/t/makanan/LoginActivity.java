package com.example.t.makanan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {

    EditText editText1 ,editText2;
    String text1 ,text2;
    ImageView lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText1 = (EditText)findViewById(R.id.input_email);
        editText2 = (EditText) findViewById(R.id.input_password);
        lock = findViewById(R.id.imgLock);

    }

    public void loginMasuk(View view) {


        text1 = editText1.getText().toString();
        text2 = editText2.getText().toString();

        if ((text1.contains("admin"))&&((text2.contains("admin")))) {
            Toast.makeText(this, "Login Sukses", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, TambahActivity.class);
            startActivity(intent);
        }

        else if ((text1.matches("")||text2.matches(""))) {
            Toast.makeText(this, "Isikan Username dan Password", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Login Gagal /Username Password Salah", Toast.LENGTH_SHORT).show();
        }

    }


}