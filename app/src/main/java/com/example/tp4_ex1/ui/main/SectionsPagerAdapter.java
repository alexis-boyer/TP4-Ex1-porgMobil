package com.example.tp4_ex1.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.tp4_ex1.R;
import com.example.tp4_ex1.SaisonFragment;
import com.example.tp4_ex1.ToutesSaisonFragment;

import java.util.Locale;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SaisonFragment.newInstance(0, mContext.getString(R.string.printemps),
                        R.drawable.printemps);
            case 1:
                return SaisonFragment.newInstance(1, mContext.getString(R.string.ete),
                        R.drawable.ete);
            case 2:
                return SaisonFragment.newInstance(2, mContext.getString(R.string.automne),
                        R.drawable.automne);
            case 3:
                return SaisonFragment.newInstance(3, mContext.getString(R.string.hiver),
                        R.drawable.hiver);
            case 4:
                return ToutesSaisonFragment.newInstance(4,
                        mContext.getString(R.string.toutSaison));

        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return mContext.getString(R.string.titre_printemps).toUpperCase(l);
            case 1:
                return mContext.getString(R.string.titre_ete).toUpperCase(l);
            case 2:
                return mContext.getString(R.string.titre_automne).toUpperCase(l);
            case 3:
                return mContext.getString(R.string.titre_hiver).toUpperCase(l);
            case 4:
                return mContext.getString(R.string.titre_toutSaison).toUpperCase(l);
        }
        return null;

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 5;
    }
}