package com.karaapp.karaokeapp.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;

/**
 * Created by ThanhThuy on 28/04/2017.
 */

public abstract class KaraDialog extends Dialog {
    private Context context;
    private String title;

    public KaraDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public KaraDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected KaraDialog(@NonNull Context context, boolean cancelable, @Nullable DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ViewGroup.LayoutParams params = getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        setCanceledOnTouchOutside(false);
        setContentView(R.layout.kara_dialog);
        TextView tvTitle = (TextView) findViewById(R.id.tv_title);
        tvTitle.setText(title);
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.dialog_root);

        generateContent(linearLayout, layoutInflater);
        generateFooter(linearLayout, layoutInflater);

    }

    public abstract View generateContent(LinearLayout linearLayout, LayoutInflater layoutInflater);

    public abstract View generateFooter(LinearLayout linearLayout, LayoutInflater layoutInflater);

}
