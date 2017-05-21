package com.karaapp.karaokeapp.ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.ui.activity.MainActivity;

/**
 * Created package com.karaapp.karaokeapp.ui.dialog on 14/05/2017.
 * Author by NghiNV
 */

public class DeleteFileDialog extends KaraDialog {
    private MainActivity activity;

    public DeleteFileDialog(@NonNull Context context) {
        super(context);
        this.activity = (MainActivity) context;
    }

    public DeleteFileDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.activity = (MainActivity) context;
    }

    protected DeleteFileDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.activity = (MainActivity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }

    @Override
    public View generateContent(LinearLayout linearLayout, LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.delete_content, linearLayout);
        TextView delete_conent = (TextView) view.findViewById(R.id.delete_content);
        delete_conent.setText(Resource.getInstance(activity).getString(R.string.ban_muon_xoa_bai_thu_am_khong));
        return view;
    }

    @Override
    public View generateFooter(LinearLayout linearLayout, LayoutInflater layoutInflater) {
        View view = layoutInflater.inflate(R.layout.delete_footer, linearLayout);
        Button bt_comfirm = (Button) view.findViewById(R.id.bt_confirm);
        Button bt_cancel = (Button) view.findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteFileDialog.this.dismiss();
            }
        });
        bt_comfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteFileDialog.this.dismiss();
                Toast.makeText(activity, "Bạn xóa thành công file", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
