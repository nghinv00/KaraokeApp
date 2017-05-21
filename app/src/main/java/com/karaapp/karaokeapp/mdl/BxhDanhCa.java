package com.karaapp.karaokeapp.mdl;

import com.facebook.login.widget.ProfilePictureView;

/**
 * Created by ThanhThuy on 24/04/2017.
 */

public class BxhDanhCa {
    private ProfilePictureView avatarface;
    private String danhcaview, danhcacomment, nameface, content_share;

    public BxhDanhCa(ProfilePictureView avatar, String nameface, String content_share) {
        this.avatarface = avatar;
        this.nameface = nameface;
        this.content_share = content_share;
    }

    public BxhDanhCa(ProfilePictureView avatarface, String nameface, String content_share, String danhcaview, String danhcacomment) {
        this.avatarface = avatarface;
        this.nameface = nameface;
        this.content_share = content_share;
        this.danhcaview = danhcaview;
        this.danhcacomment = danhcacomment;
    }

    public BxhDanhCa(String nameface, String content_share, String danhcaview, String danhcacomment) {

        this.nameface = nameface;
        this.content_share = content_share;
        this.danhcaview = danhcaview;
        this.danhcacomment = danhcacomment;
    }

    public ProfilePictureView getAvatarface() {
        return avatarface;
    }

    public void setAvatarface(ProfilePictureView avatarface) {
        this.avatarface = avatarface;
    }

    public String getNameface() {
        return nameface;
    }

    public void setNameface(String nameface) {
        this.nameface = nameface;
    }

    public String getContent_share() {
        return content_share;
    }

    public void setContent_share(String content_share) {
        this.content_share = content_share;
    }

    public String getDanhcacomment() {
        return danhcacomment;
    }

    public void setDanhcacomment(String danhcacomment) {
        this.danhcacomment = danhcacomment;
    }

    public String getDanhcaview() {
        return danhcaview;
    }

    public void setDanhcaview(String danhcaview) {
        this.danhcaview = danhcaview;
    }
}
