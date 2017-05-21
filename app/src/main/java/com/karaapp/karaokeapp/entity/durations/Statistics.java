package com.karaapp.karaokeapp.entity.durations;



public class Statistics {
    private String favoriteCount;

    private String dislikeCount;

    private String likeCount;

    private String commentCount;

    private String viewCount;

    public String getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(String favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getViewCount() {
        return viewCount;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    @Override
    public String toString() {
        return "ClassPojo [favoriteCount = " + favoriteCount + ", dislikeCount = " + dislikeCount + ", likeCount = " + likeCount + ", commentCount = " + commentCount + ", viewCount = " + viewCount + "]";
    }
}
