package com.example.nick.gettingthingsdone;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by Nick on 2/7/2018.
 */

public class ActivityDatabase extends SQLiteOpenHelper{

    private final String TABLE_NAME = "Activities";
    private static final String DB_NAME = "ActivityDB";
    private static final String[] FIELD_NAMES = { "ID", "name", "description" };

    public ActivityDatabase( Context context ){
        super( context, ActivityDatabase.DB_NAME, null, 1 );
    }

    @Override
    public void onCreate( SQLiteDatabase db ){
        String fields = " ( %s integer primary key, %s text, %s text )";
        fields = String.format(fields, (Object[]) ActivityDatabase.FIELD_NAMES);
        db.execSQL("CREATE TABLE " + this.TABLE_NAME + fields );
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int iOldVersion, int iNewVersion ){
        db.execSQL("DROP TABLE IF EXISTS " + this.TABLE_NAME );
        onCreate( db );
    }

    private Cursor findRecords( String[] fields, String where, String[] values ){
        Cursor c;
        SQLiteDatabase db = this.getReadableDatabase();

        c = db.query(
                this.TABLE_NAME,
                fields,
                where,
                values,
                null,
                null,
                "ID"
        );

        return c;

    }

    public Cursor getRecord( int id ){
        String[] values = { Integer.toString( id ) };
        return findRecords( ActivityDatabase.FIELD_NAMES, "ID = ?", values );
    }

    public Cursor getRecord(){
        String[] values = { "0" };
        return findRecords( ActivityDatabase.FIELD_NAMES, "ID != ?", values);
    }

    public boolean insert( String sName, String sDescription ){
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("name", sName);
            cv.put("description", sDescription);
            db.insert( this.TABLE_NAME, null, cv);
            return true;
        } catch ( Exception e ){
            Log.d("DATABASE", "Insert Failed: " + e.toString() );
            return false;
        }
    }

}
