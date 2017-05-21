package com.karaapp.karaokeapp.ui.Mdl;

/**
 * Created by ThanhThuy on 05/05/2017.
 */

public class GameAndApp {
    int icon;
    String title;

    public GameAndApp(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
