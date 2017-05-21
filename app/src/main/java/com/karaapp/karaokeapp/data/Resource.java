package com.karaapp.karaokeapp.data;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by Nganq on 4/18/2017.
 */

public class Resource {
    private static Resources instance;

    private Resource() {
    };

    public static Resources getInstance(Context context) {
        if (instance != null)
            return instance;
        else {
            instance = context.getResources();
            return instance;
        }
    }

}
