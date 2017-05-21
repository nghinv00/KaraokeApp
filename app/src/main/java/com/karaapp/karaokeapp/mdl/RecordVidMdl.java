package com.karaapp.karaokeapp.mdl;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created com.karaapp.karaokeapp.mdl on 5/5/2017.
 * Author: NgaNQ
 */

public class RecordVidMdl {
    public RecordVidMdl(String idVideo,String uriImage, String mTittle, String mTime, String mSize, String mPoint, String mLike, String mDurations) {
        this.uriImage = uriImage;
        this.mTittle = mTittle;
        this.mTime = mTime;
        this.mSize = mSize;
        this.mPoint = mPoint;
        this.mLike = mLike;
        this.mDurations = mDurations;
        this.idVideoRecord=idVideo;
    }

    public String getUriImage() {

        return uriImage;
    }

    public void setUriImage(String uriImage) {
        this.uriImage = uriImage;
    }

    public String getmTittle() {
        return mTittle;
    }

    public void setmTittle(String mTittle) {
        this.mTittle = mTittle;
    }

    public String getmTime() {
        return "Thời gian :  "+mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getmSize() {
        return mSize +" Mb";
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmPoint() {
        return mPoint +" Điểm";
    }

    public void setmPoint(String mPoint) {
        this.mPoint = mPoint;
    }

    public String getmLike() {
        return mLike +" Like";
    }

    public void setmLike(String mLike) {
        this.mLike = mLike;
    }

    public String getmDurations() {
        return mDurations;
    }

    public void setmDurations(String mDurations) {
        this.mDurations = mDurations;
    }

    private String uriImage;
    private String mTittle;
    private String mTime;
    private String mSize;
    private String mPoint;
    private String mLike;
    private String mDurations;

    public String getIdVideoRecord() {
        return idVideoRecord;
    }

    public void setIdVideoRecord(String idVideoRecord) {
        this.idVideoRecord = idVideoRecord;
    }

    private String idVideoRecord;

}
