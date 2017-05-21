package com.karaapp.karaokeapp.ui.Mdl;

import java.sql.Time;

/**
 * Created by ThanhThuy on 10/05/2017.
 */

public class DsYeuThich  {
    int imgVideo;
    String timeVideo;
    String titlelove, theloai;

    public DsYeuThich(int imgVideo, String timeVideo, String titlelove, String theloai) {
        this.imgVideo = imgVideo;
        this.timeVideo = timeVideo;
        this.titlelove = titlelove;
        this.theloai = theloai;
    }

    public int getImgVideo() {
        return imgVideo;
    }

    public void setImgVideo(int imgVideo) {
        this.imgVideo = imgVideo;
    }

    public String getTimeVideo() {
        return timeVideo;
    }

    public void setTimeVideo(String timeVideo) {
        this.timeVideo = timeVideo;
    }

    public String getTitlelove() {
        return titlelove;
    }

    public void setTitlelove(String titlelove) {
        this.titlelove = titlelove;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }
}
