package com.example.nick.gettingthingsdone;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class TodoList extends AppCompatActivity {

    final protected String tag = "TESTING";

    ListView lvTodo;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        Log.d( tag, "Do we get this far?");

        String[] s = new String[]{"this", "is", "a", "Database", "test"};
        ArrayList<String> als = new ArrayList<>();
        ArrayAdapter<String> aaTest = null;

        ActivityDatabase ad = new ActivityDatabase( this);
        Cursor cursor;

        cursor = ad.getRecord();

        if ( cursor.getCount() == 0 ){
            for ( String x : s ){
                ad.insert( "", x );
            }
            cursor = ad.getRecord();
        }

        if( cursor.moveToFirst() ){
            als.add( cursor.getString( 2 ) );
            while( cursor.moveToNext() ){
                als.add( cursor.getString( 2 ) );
            }
        }

        lvTodo = findViewById(R.id.TodoList);
        //TODO: keep reading mofo! https://www.raywenderlich.com/124438/android-listview-tutorial
        aaTest = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, als);

        lvTodo.setAdapter( aaTest );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvTodo.setOnItemClickListener( listItemClicked );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(TodoList.this, Tab_Activity.class);
            startActivity(i);
            }
        });
    }

    public ListView.OnItemClickListener listItemClicked = new ListView.OnItemClickListener() {
        @Override
        public void onItemClick( AdapterView<?> adapter, View v, int iPos, long lPos){
            TextView tv = (TextView) v;
            String s = tv.getText().toString();
            s = String.format( "Pos: %s, Text: %s", iPos, s);
            Toast.makeText( TodoList.this, s, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_todo_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
