package com.karaapp.karaokeapp.ui.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.facebook.login.widget.ProfilePictureView;
import com.karaapp.karaokeapp.R;

/**
 * Created by Admin 88 on 5/2/2017.
 */

public class IvDrawerBadge extends RelativeLayout {
    BadgeCircle badgeCircle;
    ImageView imgDrawer;
    Context context;

    public IvDrawerBadge(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public IvDrawerBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public IvDrawerBadge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void setNumberBadge(int numberBadge) {
        if (numberBadge == 0) {
            badgeCircle.setVisibility(View.GONE);
        } else {
            badgeCircle.setVisibility(View.VISIBLE);
            badgeCircle.setNumberBadge(numberBadge);
        }
    }

    public void setImgDrawer(ImageView imgDrawer) {
        this.imgDrawer = imgDrawer;
    }

    //click drawer navigation
    public void setFocus(boolean isFocus) {
        if (isFocus)
            imgDrawer.getBackground().setColorFilter(android.R.color.holo_red_light, PorterDuff.Mode.MULTIPLY);
        else
            imgDrawer.getBackground().setColorFilter(android.R.color.black, PorterDuff.Mode.MULTIPLY);

    }

    public void setImageDrawer(int drawerImg) {
        imgDrawer.setImageResource(drawerImg);
    }

    private void init() {
        inflate(getContext(), R.layout.drawer_badge, this);
        this.badgeCircle = (BadgeCircle) findViewById(R.id.badge_circle);
        imgDrawer = (ImageView) findViewById(R.id.imgDrawer);
        this.badgeCircle.setVisibility(View.GONE);
    }

}

