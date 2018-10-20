package com.example.t.makanan;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NotFoundActivity extends AppCompatActivity {
    TextView tambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_found);;
        tambah = findViewById(R.id.tambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(NotFoundActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.dialog, null);
                dialog.setView(dialogView);
                dialog.setCancelable(true);
                dialog.setTitle("Login");

                final TextView username = dialogView.findViewById(R.id.username);
                final TextView password = dialogView.findViewById(R.id.password);
                dialog.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String user = username.getText().toString();
                        String pass = password.getText().toString();
                        if ((user.contains("admin"))&&((pass.contains("admin")))) {
                            Toast.makeText(NotFoundActivity.this,"Berhasil Login",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(NotFoundActivity.this, TambahActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(NotFoundActivity.this,"Gagal Login",Toast.LENGTH_LONG).show();
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
