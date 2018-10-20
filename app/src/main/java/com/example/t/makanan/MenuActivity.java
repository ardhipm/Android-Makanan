package com.example.t.makanan;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MenuActivity extends AppCompatActivity {
    private ImageView imageView1,imageView2,imageView3,imageView4, imageTitle;
    MakananActivity makananActivity = new MakananActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);

        imageView1 = findViewById(R.id.imageHome1);
        imageView2 = findViewById(R.id.imageHome2);
        imageView3 = findViewById(R.id.imageHome3);
        imageView4 = findViewById(R.id.imageHome4);
        imageTitle = findViewById(R.id.imgTitle);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this,MainActivity.class));
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MenuActivity.this);
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
                            Toast.makeText(MenuActivity.this,"Berhasil Login",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MenuActivity.this, TambahActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(MenuActivity.this,"Gagal Login",Toast.LENGTH_LONG).show();
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
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, PagerActivity.class));
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
