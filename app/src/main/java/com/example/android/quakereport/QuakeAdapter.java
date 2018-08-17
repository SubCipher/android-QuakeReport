package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class QuakeAdapter extends ArrayAdapter<Earthquake>{



    private int getMagnitudeColor(double magnitude) {

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        // return ContextCompat.getColor(this,magnitudeColorResourceId);
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
    //public constructor for ArrayAdapter
    public QuakeAdapter(Activity context, ArrayList<Earthquake> earthquake){
        super(context,0,earthquake);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_list_layout, parent, false);
        }

        Earthquake currentQuake = getItem(position);
        //bind TextView to data

        TextView magnitudeCircleTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeCircleTextView.getBackground();
        double quakeMagnitude = 0;
        int magnitudeColor = 0;
        if (currentQuake != null){
          quakeMagnitude = currentQuake.getmMagnitude();
        }

        magnitudeColor = getMagnitudeColor(quakeMagnitude);

       magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("0.0");

        String magDecimalFormat = formatter.format(quakeMagnitude);
        magnitudeCircleTextView.setText(magDecimalFormat);

        String inStr = currentQuake.getmLocation();
        String[] parts = inStr.split(",");
        String location00 = parts[0];
        String location01 = parts[1];
        if (parts[0].length() == 0){
            location00 = "Near the";
        }

        TextView localDescription = (TextView) listItemView.findViewById(R.id.location_text_view);
        localDescription.setText(location00);

        TextView locationActual = (TextView) listItemView.findViewById(R.id.localDescription_text_view);
        locationActual.setText(location01);


        Long strDate = currentQuake.getmDate();
        Date dateObject = new Date(strDate);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy", Locale.getDefault());
        String dateToDisplay = dateFormatter.format(dateObject);

        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a", Locale.getDefault());
        String timeToDisplay = timeFormatter.format(dateObject);


        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text_view);
        dateTextView.setText(dateToDisplay);
        timeTextView.setText(timeToDisplay);

        return listItemView;
    }

}
