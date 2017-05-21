package com.karaapp.karaokeapp.ui.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.login.widget.ProfilePictureView;
import com.karaapp.karaokeapp.R;

/**
 * Created by Admin 88 on 4/27/2017.
 */

public class ProfilePictureBadge extends RelativeLayout {
    BadgeCircle badgeCircle;
    ProfilePictureView imgPropicture;
    Context context;

    public ProfilePictureBadge(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public ProfilePictureBadge(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public ProfilePictureBadge(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init();
    }

    public void setNumberBadge(int numberBadge) {
        if (numberBadge == 0) {
            badgeCircle.setVisibility(View.GONE);
        } else {
            this.badgeCircle.setVisibility(View.VISIBLE);
            badgeCircle.setNumberBadge(numberBadge);
        }
    }

    //click drawer navigation
    public void setFocus(boolean isFocus) {
        if (isFocus)
            imgPropicture.getBackground().setColorFilter(android.R.color.holo_red_light, PorterDuff.Mode.MULTIPLY);
        else
            imgPropicture.getBackground().setColorFilter(android.R.color.black, PorterDuff.Mode.MULTIPLY);

    }

    public void setProfileId(String id) {
        imgPropicture.setProfileId(id);

    }

    private void init() {
        inflate(getContext(), R.layout.pro_picture_bagde, this);
        this.badgeCircle = (BadgeCircle) findViewById(R.id.badge_circle);
        imgPropicture = (ProfilePictureView) findViewById(R.id.imgPropicture);
        imgPropicture.setPresetSize(ProfilePictureView.NORMAL);
        this.badgeCircle.setVisibility(View.GONE);
    }

}
