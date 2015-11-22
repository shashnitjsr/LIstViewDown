package com.example.shashwatsinha.listview_down;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by shashwatsinha on 13/08/15.
 */
public class BackTask extends AsyncTask<Void, Void, String[]> {

    BackingAdapter b;
    String[] data;
    String[] combine;

    public BackTask(BackingAdapter b1) {
        b = b1;
    }

    @Override
    protected String[] doInBackground(Void... params) {


        Log.d("shashwat", "backtask doInbackground");
        data = new String[]{
                "Delhi",
                "Mumbai",
                "Chennai",
                "Kolkata",
                "Noida",
                "Lucknow",
                "Ghaziabad",
                "Gurgaon",
                "Faridabad",
                "Allahabad"
        };
        combine = new String[b.data.length + data.length];
        System.arraycopy(b.data, 0, combine, 0, b.data.length);
        System.arraycopy(data, 0, combine, b.data.length, data.length);
        return combine;
    }

    @Override
    protected void onPostExecute(String[] p) {
        b.data = p;
        b.notifyDataSetChanged();
    }
}
