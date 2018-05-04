package com.example.android.glasgowmusicguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Provides the appropriate Fragment for a view pager.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    public CategoryAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VenuesFragment();
        } else if (position == 1){
            return new ClubsFragment();
        } else if (position == 2){
            return new ShopsFragment();
        } else {
            return new BandsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    private String tabTitles[] = new String[]{"Venues", "Clubs", "Shops", "Bands"};

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}