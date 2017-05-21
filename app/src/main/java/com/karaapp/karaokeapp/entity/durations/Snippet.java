package com.karaapp.karaokeapp.entity.durations;


public class Snippet {
    private String[] tags;

    private String publishedAt;

    private String title;

    private String channelId;

    private String defaultAudioLanguage;

    private String description;

    private String categoryId;

    private String defaultLanguage;

    private String channelTitle;

    private Thumbnails thumbnails;

    private String liveBroadcastContent;

    private Localized localized;

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getDefaultAudioLanguage() {
        return defaultAudioLanguage;
    }

    public void setDefaultAudioLanguage(String defaultAudioLanguage) {
        this.defaultAudioLanguage = defaultAudioLanguage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public void setDefaultLanguage(String defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public Thumbnails getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(Thumbnails thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }

    public Localized getLocalized() {
        return localized;
    }

    public void setLocalized(Localized localized) {
        this.localized = localized;
    }

    @Override
    public String toString() {
        return "ClassPojo [tags = " + tags + ", publishedAt = " + publishedAt + ", title = " + title + ", channelId = " + channelId + ", defaultAudioLanguage = " + defaultAudioLanguage + ", description = " + description + ", categoryId = " + categoryId + ", defaultLanguage = " + defaultLanguage + ", channelTitle = " + channelTitle + ", thumbnails = " + thumbnails + ", liveBroadcastContent = " + liveBroadcastContent + ", localized = " + localized + "]";
    }
}
