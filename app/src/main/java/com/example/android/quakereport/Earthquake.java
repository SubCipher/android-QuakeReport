package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private String mMag;
    private String mLocation;
    private String mDate;

    public Earthquake(){}


    public Earthquake(String magnitude, String location,String time){

        mMag = magnitude;
        mLocation = location;
        mDate = time;
    }


    public String getmMag() {
        return mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }
}
