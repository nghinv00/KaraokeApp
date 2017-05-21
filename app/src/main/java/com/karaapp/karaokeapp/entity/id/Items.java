package com.karaapp.karaokeapp.entity.id;



public class Items {
    private Id id;
    private String etag;
    private Snippet snippet;
    private String kind;

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    @Override
    public String toString() {
        return "ClassPojo [id = " + id + ", etag = " + etag + ", snippet = " + snippet + ", kind = " + kind + "]";
    }

}
