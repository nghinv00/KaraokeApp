package com.karaapp.karaokeapp.ui.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.data.Resource;

/**
 * Created by ThanhThuy on 28/04/2017.
 */

public class ShutdowKaraDialog extends KaraDialog {
    private MainActivity activity;

    public ShutdowKaraDialog(@NonNull Context context) {
        super(context);
        this.activity = (MainActivity) context;
    }

    public ShutdowKaraDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.activity = (MainActivity) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View generateContent(LinearLayout linearLayout, LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.shutdown_content,
                linearLayout);
        TextView tvContent = (TextView) view.findViewById(R.id.shutdown_content);
        tvContent.setText(Resource.getInstance(activity).getString(R.string.ban_muon_tat_ung_dung_kara));
        return view;
    }

    @Override
    public View generateFooter(LinearLayout linearLayout, LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.shutdown_footer, linearLayout);
        Button btConfirm = (Button) view.findViewById(R.id.bt_confirm);
        Button btCancel = (Button) view.findViewById(R.id.bt_cancel);

        btCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShutdowKaraDialog.this.dismiss();
            }
        });
        btConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ShutdowKaraDialog.this.dismiss();
                pauseApplication(activity);
            }
        });
        
        return view;
    }

    private static final void pauseApplication(Context context) {
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory(Intent.CATEGORY_HOME);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(homeIntent);
    }
}
