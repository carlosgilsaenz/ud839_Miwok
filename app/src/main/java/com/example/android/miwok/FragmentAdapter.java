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
    private static final int NUM_ITEMS = 4;
    private LayoutInflater mInflator;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new NumbersFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new ColorsFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new FamilyFragment();
            default:
                return new PhrasesFragment();
        }
    }

    //returns number of pages
    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}