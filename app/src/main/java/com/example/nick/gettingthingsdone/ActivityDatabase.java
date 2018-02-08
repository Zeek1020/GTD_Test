package com.example.nick.gettingthingsdone;

import android.content.Context;
import android.database.sqlite.*;

/**
 * Created by Nick on 2/7/2018.
 */

public class ActivityDatabase extends SQLiteOpenHelper{

    SQLiteDatabase sqlDB;

    public ActivityDatabase( Context context, String sDBName ){
        super( context, sDBName, null, 1 );
    }

    @Override
    public void onCreate( SQLiteDatabase db ){
        db.execSQL("CREATE TABLE ACTIVITIES");
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int iOldVersion, int iNewVersion ){

    }

}
