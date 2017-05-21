package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.fragment.RecordVideoInfoFragment;

import java.util.List;

/**
 * Created package com.karaapp.karaokeapp.ui.adapter on 13/05/2017.
 * Author by NghiNV
 */

public class RecordVideoInfoAdapter extends RecyclerView.Adapter<RecordVideoInfoAdapter.RecordViewHoler> {

    private List<RecordVidMdl> listVideoRecord;
    private MainActivity activity;

    public void setOnItemLickListener(OnItemLickListener listerner) {
        RecordVideoInfoAdapter.listerner = listerner;
    }

    public static void setOnLongItemListener(OnLongClickListener longListener) {
        RecordVideoInfoAdapter.longListener = longListener;
    }

    public static OnItemLickListener listerner;
    public static OnLongClickListener longListener;

    public RecordVideoInfoAdapter(List<RecordVidMdl> listVideoRecord) {
        this.listVideoRecord = listVideoRecord;
    }

    @Override
    public RecordViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.record_video_info_item, parent, false);
        activity = (MainActivity) parent.getContext();
        return new RecordViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(RecordViewHoler holder, int position) {
        final RecordVidMdl recordVidMdl = listVideoRecord.get(position);
        Glide.with(holder.iv_info_item_recycler.getContext()).load(recordVidMdl.getUriImage())
          .placeholder(R.drawable.bxhbaihat).into(holder.iv_info_item_recycler);
        holder.textDuration.setText(recordVidMdl.getmDurations());
        holder.tvTitleInfoRecordVideo.setText(recordVidMdl.getmTittle());

    }

    @Override
    public int getItemCount() {
        return listVideoRecord.size();
    }

    public class RecordViewHoler extends RecyclerView.ViewHolder {
        ImageView iv_info_item_recycler;
        TextView textDuration, tvTitleInfoRecordVideo;

        public RecordViewHoler(final View itemView) {
            super(itemView);
            iv_info_item_recycler = (ImageView) itemView.findViewById(R.id.iv_info_item_recycler);
            textDuration = (TextView) itemView.findViewById(R.id.textDuration);
            tvTitleInfoRecordVideo = (TextView) itemView.findViewById(R.id.tvTitleInfoRecordVideo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listerner != null){
                        listerner.onItemLick(itemView, getAdapterPosition());
                    }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (longListener != null){
                        longListener.onLongItemClick(itemView, getAdapterPosition());
                        return false;
                    }
                    return false;
                }
            });

        }

//        @Override
//        public void onClick(View v) {
//            this.onClick(v);
//            if ( listerner != null) {
//                listerner.onItemLick(v, getLayoutPosition());
//            }
//        }
    }

    public interface OnItemLickListener {
        void onItemLick(View itemView, int position);
    }
    public interface OnLongClickListener {
        boolean onLongItemClick(View itemview, int position);
    }

}
