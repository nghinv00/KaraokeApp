package com.karaapp.karaokeapp.mdl;

/**
 * Created by Admin 88 on 4/26/2017.
 */

public class BillboardSong {

    public String getUsernameFB() {
        return usernameFB;
    }

    public void setUsernameFB(String usernameFB) {
        this.usernameFB = usernameFB;
    }

    public String getContentShare() {
        return contentShare;
    }

    public void setContentShare(String contentShare) {
        this.contentShare = contentShare;
    }

    public int getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(int urlImage) {
        this.urlImage = urlImage;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getCountLike() {
        return countLike;
    }

    public void setCountLike(String countLike) {
        this.countLike = countLike;
    }

    public String getCountSeen() {
        return countSeen;
    }

    public void setCountSeen(String countSeen) {
        this.countSeen = countSeen;
    }

    public String getCountComment() {
        return countComment;
    }

    public void setCountComment(String countComment) {
        this.countComment = countComment;
    }

    public String getCountShare() {
        return countShare;
    }

    public void setCountShare(String countShare) {
        this.countShare = countShare;
    }

    public String getMinuteShare() {
        return minuteShare;
    }

    public void setMinuteShare(String minuteShare) {
        this.minuteShare = minuteShare;
    }

    private String usernameFB;
    private String contentShare;
    private int urlImage;
    private String tittle;
    private String countLike;
    private String countSeen;
    private String countComment;
    private String countShare;
    private String minuteShare;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    private String ID;
    public BillboardSong(String id,String usernameFB, String contentShare, int urlImage, String tittle, String countLike, String countSeen, String countComment, String countShare, String minuteShare) {
        this.ID = id;
        this.usernameFB = usernameFB;
        this.contentShare = contentShare;
        this.urlImage = urlImage;
        this.tittle = tittle;
        this.countLike = countLike;
        this.countSeen = countSeen;
        this.countComment = countComment;
        this.countShare = countShare;
        this.minuteShare = minuteShare;
    }

}
