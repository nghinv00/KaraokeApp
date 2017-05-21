package com.karaapp.karaokeapp.entity.durations;


public class Items {
    private String id;

    private String etag;

    private Snippet snippet;

    private ContentDetails contentDetails;

    private String kind;

    private Statistics statistics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", etag = " + etag + ", snippet = " + snippet + ", contentDetails = " + contentDetails + ", kind = " + kind + ", statistics = " + statistics + "]";
    }
}
