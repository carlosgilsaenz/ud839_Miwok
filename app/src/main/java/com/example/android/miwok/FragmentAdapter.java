package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by csaenz on 2/14/2017.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    private LayoutInflater mInflator;

    public FragmentAdapter(FragmentManager fm, ArrayList <Word> words) {

        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }



}
