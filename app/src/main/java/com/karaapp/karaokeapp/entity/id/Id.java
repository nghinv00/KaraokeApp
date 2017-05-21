package com.karaapp.karaokeapp.entity.id;


public class Id {
    private String videoId;

    private String kind;

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [videoId = " + videoId + ", kind = " + kind + "]";
    }
}