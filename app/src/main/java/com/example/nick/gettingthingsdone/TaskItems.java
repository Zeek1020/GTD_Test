package com.example.nick.gettingthingsdone;

import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Nick on 2/4/2018.
 */

public class TaskItems{


    protected String title, description, notes;
    protected int id;
    private JSONObject joParameters;

    public static int getHighestID(){
        int iHighestID = 0;
        if ( false ){
            //GetDBConnection and find last TaskItem
        } else {
            iHighestID = 1;
        }
        return iHighestID;
    }

    protected boolean saveSelf(){

        //setup db here and save current state of jsonobject
        //TODO: Write DB Control object.

        return true;
    }

    public void TaskItems() throws JSONException{
        joParameters = new JSONObject();
        joParameters.put( "id", Integer.toString( getHighestID() ) );
        joParameters.put( "title", "" );
        joParameters.put( "notes", "" );
        joParameters.put( "description", "" );
    }

    public void TaskItems( String s ) throws JSONException {
        joParameters = new JSONObject(s);
        id = Integer.parseInt(joParameters.getString("id"));
        title = joParameters.getString("title");
        description = joParameters.getString("description");
        notes = joParameters.getString("notes");
    }

    public String getProperty( String key ) throws JSONException{
        if ( joParameters.has( key ) ){
            return joParameters.getString( key );
        } else {
            return null;
        }
    }

    public boolean setProperty( String key, String value ) throws JSONException{
        boolean out;

        if ( joParameters.has( key ) ){
            joParameters.put( key, value );
            out = true;
        } else {
            out = false;
        }
        saveSelf();
        return out;
    }

    public JSONObject getJObject(){
        return joParameters;
    }

}
