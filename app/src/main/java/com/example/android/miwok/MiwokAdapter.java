package com.example.android.miwok;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MiwokAdapter extends FragmentPagerAdapter {
    private Context mContext;
    private String[] tabTitles;

    public MiwokAdapter(FragmentManager fragmentManager, Context context){
        super(fragmentManager);
        mContext = context;
        tabTitles = new String[]{ mContext.getResources().getString(R.string.category_numbers),
                mContext.getResources().getString(R.string.category_colors),
                mContext.getResources().getString(R.string.category_family),
                mContext.getResources().getString(R.string.category_phrases) };
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NumbersFragment();
            case 1:
                return new ColorsFragment();
            case 2:
                return new FamilyFragment();
            default:
                return new PhrasesFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
