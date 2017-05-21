package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.BxhDanhCa;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.fragment.RecordVideoInfoFragment;

import java.util.List;

/**
 * Created com.karaapp.karaokeapp.ui.adapter on 5/5/2017.
 * Author: NgaNQ
 */

public class RecordVideoAdapter extends RecyclerView.Adapter<RecordVideoAdapter.RecordViewHolder>{

    private List<RecordVidMdl> lisVideoRecord;
    private MainActivity activity;
    public static OnItemCLickListener onItemCLickListener;

    public static OnItemCLickListener getOnItemCLickListener() {
        return onItemCLickListener;
    }

    public static void setOnItemCLickListener(OnItemCLickListener onItemCLickListener) {
        RecordVideoAdapter.onItemCLickListener = onItemCLickListener;
    }

    public RecordVideoAdapter(List<RecordVidMdl> recordVidList) {
        this.lisVideoRecord = recordVidList;
    }
    @Override
    public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_record_vid, parent, false);
        activity = (MainActivity) parent.getContext();
        return new RecordVideoAdapter.RecordViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(RecordViewHolder holder, int position) {

        final RecordVidMdl recordVid = lisVideoRecord.get(position);
        holder.mTittle.setText(recordVid.getmTittle());
        holder.mTime.setText(recordVid.getmTime());
        holder.mSize.setText(recordVid.getmSize());
        holder.mPoint.setText(recordVid.getmPoint());
        holder.mLike.setText(recordVid.getmLike());
        holder.mDurations.setText(recordVid.getmDurations());
        Glide.with(holder.uriImage.getContext()).load(recordVid.getUriImage()).placeholder(R.drawable.bxhbaihat).into(holder.uriImage);
        holder.btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showPopupMenu(v, recordVid.getIdVideoRecord(), recordVid.getmTittle());
            }
        });
    }

    private void showPopupMenu(final View view, final String videoId , final String videoName){
        PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu_record, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch(id) {
                    case R.id.open:

                        activity.callFragment(RecordVideoInfoFragment.newInstance(videoId, videoName));
                        return true;
                    case R.id.edit:
                        return true;
                    case R.id.share:

                        return true;
                    case R.id.delete:
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();

        MenuPopupHelper menuHelper = new MenuPopupHelper(view.getContext(), (MenuBuilder) popupMenu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }
    @Override
    public int getItemCount() {
        return lisVideoRecord.size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder{
        public ImageView uriImage;
        public TextView mTittle,mTime,mSize,mPoint,mLike,mDurations;
        Button btnPopup;
        public RecordViewHolder(View itemView) {
            super(itemView);
            btnPopup= (Button) itemView.findViewById(R.id.btnPopup);
            uriImage= (ImageView) itemView.findViewById(R.id.imageVideo);
            mTittle= (TextView) itemView.findViewById(R.id.titleVid);
            mTime= (TextView) itemView.findViewById(R.id.txtTime);
            mSize= (TextView) itemView.findViewById(R.id.size);
            mPoint= (TextView) itemView.findViewById(R.id.point);
            mLike= (TextView) itemView.findViewById(R.id.countLike);
            mDurations= (TextView) itemView.findViewById(R.id.txtdurations);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemCLickListener != null) {
                        onItemCLickListener.OnItemClick(v, getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface OnItemCLickListener {
        void OnItemClick(View itemView, int position);
    }

}
