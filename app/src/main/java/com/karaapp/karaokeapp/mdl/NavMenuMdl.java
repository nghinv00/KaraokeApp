package com.karaapp.karaokeapp.mdl;

/**
 * Created by Nganq on 4/18/2017.
 */

public class NavMenuMdl {
    private int drawableResource;
    private String text;

    public NavMenuMdl(int drawableResource, String text) {
        this.drawableResource = drawableResource;
        this.text = text;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
