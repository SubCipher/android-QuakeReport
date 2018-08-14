package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class QuakeAdapter extends ArrayAdapter<Earthquake>{


    //public constructor for ArrayAdapter
    public QuakeAdapter(Activity context, ArrayList<Earthquake> earthquake){
        super(context,0,earthquake);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout,parent,false);

        }

        Earthquake currentQuake = getItem(position);
        //bind TextView to data
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        magTextView.setText(currentQuake.getmMag());

        TextView locTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        locTextView.setText(currentQuake.getmLocation());


        String strDate = currentQuake.getmDate();


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(strDate);

        return listItemView;
    }

}
