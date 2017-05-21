package com.karaapp.karaokeapp.mdl;

/**
 * Created by Nganq on 4/18/2017.
 */

public class VideoMdl {

    private String videoId;
    private String title;
    private String url;
    private String durations;
    public VideoMdl() {
        this.videoId = "";
        this.title = "";
        this.url = "";
        this.durations = "";
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    private String viewCount;

    public String getDurations() {
        return durations;
    }

    public void setDurations(String durations) {
        this.durations = durations;
    }

    public VideoMdl(String videoId, String title, String url) {
        this.videoId = videoId;
        this.title = title;
        this.url = url;
    }

    public VideoMdl(String videoId, String title, String url, String durations) {
        this.videoId = videoId;
        this.title = title;
        this.url = url;
        this.durations = durations;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String parseDuration(String in) {
        boolean hasSeconds = in.indexOf('S') > 0;
        boolean hasMinutes = in.indexOf('M') > 0;

        String s;
        if (hasSeconds) {
            s = in.substring(2, in.length() - 1);
        } else {
            s = in.substring(2, in.length());
        }

        String minutes = "0";
        String seconds = "00";

        if (hasMinutes && hasSeconds) {
            String[] split = s.split("M");
            minutes = split[0];
            seconds = split[1];
        } else if (hasMinutes) {
            minutes = s.substring(0, s.indexOf('M'));
        } else if (hasSeconds) {
            seconds = s;
        }

        // pad seconds with a 0 if less than 2 digits
        if (seconds.length() == 1) {
            seconds = "0" + seconds;
        }

        return minutes + ":" + seconds;
    }
}

