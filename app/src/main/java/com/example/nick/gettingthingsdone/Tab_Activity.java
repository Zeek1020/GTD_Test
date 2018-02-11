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

    TabLayout.OnTabSelectedListener changeTab = new TabLayout.OnTabSelectedListener(){
        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabSelected(TabLayout.Tab tab) {

        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ViewPager vPager = ( ViewPager ) findViewById( R.id.pager );
        TabLayout tLayout = ( TabLayout ) findViewById( R.id.tab_layout );
        final PagerAdapter pagerAdapter = new PagerAdapter( getSupportFragmentManager(), tLayout.getTabCount());
        vPager.setAdapter( pagerAdapter );

        tLayout.addTab( tLayout.newTab().setText("Tab1") );
        tLayout.addTab( tLayout.newTab().setText("Tab2") );
        tLayout.addTab( tLayout.newTab().setText("Tab3") );
        tLayout.setTabGravity( TabLayout.GRAVITY_FILL );
        //TODO: Why is this deprecated?  What do I use instead?
        tLayout.setOnTabSelectedListener( changeTab );

        //TODO: http://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/ fragment pager?


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
