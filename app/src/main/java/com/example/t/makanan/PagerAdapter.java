package com.example.t.makanan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by t on 8/28/2018.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String judulTab[] = new String[]{
            "BAHAN", "KARAKTERISTIK KIMIA"
    };

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }



    @Override
    public Fragment getItem(int position) {
       Pager myFragment = new Pager();
        Bundle data = new Bundle();
        data.putInt("current_page", position+1);
        myFragment.setArguments(data);
        return myFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
       return judulTab[position];
    }
}
