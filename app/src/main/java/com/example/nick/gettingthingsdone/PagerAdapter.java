package com.example.nick.gettingthingsdone;

import android.net.Uri;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Nick on 2/10/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int NumTabs;
    private String tag = "MyTAG";

    @Override
    public int getCount() {
        return this.NumTabs;
    }

    public PagerAdapter(FragmentManager fm, int NumTabs ) {
        super(fm);
        this.NumTabs = NumTabs;
    }

    @Override
    public void startUpdate(ViewGroup container) {
        super.startUpdate(container);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public void finishUpdate(ViewGroup container) {
        super.finishUpdate(container);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return super.isViewFromObject(view, object);
    }

    @Override
    public Parcelable saveState() {
        return super.saveState();
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        super.restoreState(state, loader);
    }

    public Fragment getItem(int position) {

        switch ( position ){
            case 0:
                return new Tab1_Fragment();
            case 1:
                return new Tab2_List_Fragment();
            case 2:
                return new Tab1_Fragment();
            default:
                return new Tab1_Fragment();
        }
    }
}
