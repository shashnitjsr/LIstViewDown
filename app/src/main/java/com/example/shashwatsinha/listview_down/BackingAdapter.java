package com.example.shashwatsinha.listview_down;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by shashwatsinha on 12/08/15.
 */
public class BackingAdapter extends BaseAdapter {

    Context applicationContext;
    int layout;
    public String[] data;

    public BackingAdapter(Context applicationContext, int simple_list_item_1, String[] strings) {
        this.applicationContext = applicationContext;
        layout = simple_list_item_1;
        data = strings;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position % data.length];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Log.d("shashwat", "position " + position);

        if (position == data.length - 1) {
            Log.d("shashwat", "Last Item visible now");
            new BackTask(this).execute();
        }

        View view = convertView;
        if (convertView == null) {
            LayoutInflater inflator = (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflator.inflate(layout, parent, false);
        }
        TextView tv = (TextView) view.findViewById(R.id.text_view);
        tv.setText(data[position % data.length]);
        return view;

    }
}
