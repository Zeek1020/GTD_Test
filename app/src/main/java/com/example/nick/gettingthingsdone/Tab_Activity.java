package com.example.nick.gettingthingsdone;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Tab_Activity extends AppCompatActivity {

    TabHost host;

    protected void addTab( TabHost t, String tabName, int viewID ){
        TabHost.TabSpec ts = t.newTabSpec( tabName );
        ts.setContent( viewID );
        ts.setIndicator( tabName );
        t.addTab( ts );
    }

    TabHost.OnTabChangeListener tabListener = new TabHost.OnTabChangeListener(){
        @Override
        public void onTabChanged( String name ){
            Toast.makeText( Tab_Activity.this, name, Toast.LENGTH_SHORT );

            if ( name.equals( "Next Action" ) ){
                ArrayList<String> al = new ArrayList<>();
                al.add( "Do Something!" );
                al.add( "File Taxes" );
                al.add( "What the hell is all this then?");
                //TODO: Check Notepad++
                ArrayAdapter<String> ad = new ArrayAdapter<String>( Tab_Activity.this, android.R.layout.simple_list_item_1, al);
                try {
                    ListView lv = (ListView) findViewById(R.id.LV_NEXT_ACTION);
                    lv.setAdapter(ad);
                } catch (Exception e ){
                    Toast.makeText( Tab_Activity.this, e.toString(), Toast.LENGTH_LONG ).show();
                    Log.d("Err", "ListView didn't work");
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        host = findViewById( R.id.TH_Inboxes );

        host.setup();

        addTab(host, "Next Action", R.id.Next_Action);
        addTab(host, "Projects", R.id.Projects);
        addTab(host, "Reference", R.id.Reference);

        host.setOnTabChangedListener( tabListener );

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
