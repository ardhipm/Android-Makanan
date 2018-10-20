package com.example.t.makanan;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        ViewPager pager = findViewById(R.id.pager);
        FragmentManager fm = getSupportFragmentManager();
        PagerAdapter pagerAdapter = new PagerAdapter(fm);
        pager.setAdapter(pagerAdapter);
    }
}
