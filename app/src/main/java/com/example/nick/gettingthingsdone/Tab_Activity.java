package com.example.nick.gettingthingsdone;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tab_Activity extends AppCompatActivity {

    private final String tag = "MyTAG";

    TabLayout.OnTabSelectedListener changeTab = new TabLayout.OnTabSelectedListener(){
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            Log.d( "TAB", tab.toString() );
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d( tag, "Did we make it here? 1 ");
        final ViewPager vPager = ( ViewPager ) findViewById( R.id.pager );
        Log.d( tag, "Did we make it here? 2 ");
        TabLayout tLayout = ( TabLayout ) findViewById( R.id.tab_layout );
        Log.d( tag, "We definitely didn't make it here" );
        final PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tLayout.getTabCount());

        //TODO: Ok, vPager.setAdapter seems to be the issue. I don't know if pagerAdapter is null or not
        //vPager.setAdapter( pagerAdapter );

        /*
        try {
            tLayout.addTab(tLayout.newTab().setText("Tab1"));
            tLayout.addTab(tLayout.newTab().setText("Tab2"));
            tLayout.addTab(tLayout.newTab().setText("Tab3"));
        } catch ( Exception e ){
            Log.d(tag, "AddTab: " + e.toString() );
        }

        try {
            tLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        } catch ( Exception e ){
            Log.d("DEBUG", "Gravity: " + e.toString() );
        }
        try {
            tLayout.addOnTabSelectedListener(changeTab);
        } catch ( Exception e ){
            Log.d( tag, "addListener: " + e.toString());
        }
        //TODO: http://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/ fragment pager?

        try {
            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        } catch ( Exception e ){
            Log.d( tag, e.toString() );
        }
        */
    }

}
