package com.karaapp.karaokeapp.entity.durations;

public class Thumbnails {
    private Default default1;

    private Standard standard;

    private High high;

    private Maxres maxres;

    private Medium medium;

    public Default getDefault() {
        return default1;
    }

    public void setDefault(Default default1) {
        this.default1 = default1;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Maxres getMaxres() {
        return maxres;
    }

    public void setMaxres(Maxres maxres) {
        this.maxres = maxres;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "ClassPojo [default = " + default1
                + ", standard = " + standard + ", high = " + high + ", maxres = " + maxres + ", medium = " + medium + "]";
    }
}
