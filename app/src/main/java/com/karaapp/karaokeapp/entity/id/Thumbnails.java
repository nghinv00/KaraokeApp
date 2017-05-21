package com.karaapp.karaokeapp.entity.id;


public class Thumbnails {
    private Default default1;

    private High high;

    private Medium medium;

    public Default getDefault() {
        return default1 ;
    }

    public void setDefault(Default default1) {
        this.default1 = default1;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "ClassPojo [default = " + default1 +", high = " + high + ", medium = " + medium + "]";
    }
}