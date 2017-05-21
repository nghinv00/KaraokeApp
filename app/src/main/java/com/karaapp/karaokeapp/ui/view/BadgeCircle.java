package com.karaapp.karaokeapp.ui.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;

/**
 * Created by Admin 88 on 4/27/2017.
 */

public class BadgeCircle extends TextView {
    public BadgeCircle(Context context) {
        super(context);
        init();
    }

    public BadgeCircle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BadgeCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setNumberBadge(int numberBadge) {
        if (numberBadge == 0) {
            this.setVisibility(GONE);
        } else
            this.setText(String.valueOf(numberBadge));
    }

    private void init() {
        setWidth(20);
        setHeight(20);
        setTextSize(12);
        setGravity(Gravity.CENTER);
        setTextColor(getResources().getColor(android.R.color.white));
        setBackground(getResources().getDrawable(R.drawable.badge_circle));
    }

}
