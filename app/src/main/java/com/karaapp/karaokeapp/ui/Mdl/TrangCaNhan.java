package com.karaapp.karaokeapp.ui.Mdl;

/**
 * Created by ThanhThuy on 12/05/2017.
 */

public class TrangCaNhan implements ITrangCaNhan {
    private String id;
    private String avatar;
    private String name;
    private int view;
    private int tinnhan;
    private int share;
    private int like;
    private int soluong;
    private int comment;
    private String thuam;

    public TrangCaNhan(String id, String avatar, String name) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
    }

    public TrangCaNhan() {
    }

    public TrangCaNhan(String thuam,int soluong,  int like, int share,  int comment ) {
        this.share = share;
        this.like = like;
        this.soluong = soluong;
        this.comment = comment;
        this.thuam = thuam;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String getThuam() {
        return thuam;
    }

    @Override
    public String getComment() {
        return Integer.toString(comment);
    }

    @Override
    public String getSoluong() {
        return Integer.toString(soluong);
    }

    @Override
    public String getLike() {
        return Integer.toString(like);
    }

    @Override
    public String getShare() {
        return Integer.toString(share);
    }
}
