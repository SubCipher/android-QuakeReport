package com.example.android.quakereport;

public class Earthquake {

    private Double mMag;
    private String mLocation;
    private String mUrl;
    private Long mTime;

    public Earthquake(){}


    public Earthquake(Double magnitude, String location,Long time, String url){

        mMag = magnitude;
        mLocation = location;
        mTime = time;
        mUrl = url;
    }


    public Double getmMag() {
        return mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public Long getmTime() {
        return mTime;
    }

    public String getmUrl() {return mUrl; }
}
