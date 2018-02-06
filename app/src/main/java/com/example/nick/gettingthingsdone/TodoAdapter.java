package com.example.nick.gettingthingsdone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Nick on 1/16/2018.
 */

public class TodoAdapter extends BaseAdapter {

    private Context ThisContext;
    private ArrayList<String> alSource;
    private LayoutInflater liLayout;

    public TodoAdapter(Context context, ArrayList<String> items) {
        super();
        ThisContext = context;
        alSource = items;
        liLayout = (LayoutInflater) ThisContext.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
    }

    @Override
    public int getCount() {
        return alSource.size();
    }

    @Override
    public Object getItem(int i) {
        return alSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View rowView = liLayout.inflate( R.layout.activity_todo_list, viewGroup, false);

        return rowView;
    }
}
