package com.example.android.takemytabs;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by pm on 2/13/2018.
 */

public class MyPagerAdapter extends FragmentStatePagerAdapter {
    int mnumberoftabs;

    public MyPagerAdapter(FragmentManager fm, int numtabs) {
        super(fm);
        mnumberoftabs = numtabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                return new frag1();
            case 1:
                return new frag2();
            case 2:
                return new frag3();
            case 3:
                return new frag4();
        }

        return null;
    }

    @Override
    public int getCount() {
        return mnumberoftabs;
    }
}
