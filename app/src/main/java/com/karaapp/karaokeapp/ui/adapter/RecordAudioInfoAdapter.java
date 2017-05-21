package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created package com.karaapp.karaokeapp.ui.adapter on 16/05/2017.
 * Author by NghiNV
 */

public class RecordAudioInfoAdapter extends RecyclerView.Adapter<RecordAudioInfoAdapter.MyViewHolder> {

    OnItemClickListener onItemClickListener;
    private List<RecordVidMdl> listRecordMdl = new ArrayList<>();
    private MainActivity activity;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecordAudioInfoAdapter(List<RecordVidMdl> listRecordMdl) {
        this.listRecordMdl = listRecordMdl;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_video_info_item, parent, false);
        activity = (MainActivity) parent.getContext();
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final RecordVidMdl mdl = listRecordMdl.get(position);
        holder.textDuration.setText(mdl.getmDurations());
        holder.tvTitleInfoRecordVideo.setText(mdl.getmTittle());
        /**
         * Glide.with(holder.iv_info_item_recycler.getContext()).load(recordVidMdl.getUriImage())
         .placeholder(R.drawable.bxhbaihat).into(holder.iv_info_item_recycler);
         */
        Glide.with(holder.iv_info_item_recycler.getContext()).load(mdl.getUriImage())
                .placeholder(R.drawable.bxhbaihat).into(holder.iv_info_item_recycler);
    }

    @Override
    public int getItemCount() {
        return listRecordMdl.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView iv_info_item_recycler;
        TextView textDuration, tvTitleInfoRecordVideo;
        public MyViewHolder(final View itemView) {
            super(itemView);
            iv_info_item_recycler = (ImageView) itemView.findViewById(R.id.iv_info_item_recycler);
            textDuration = (TextView) itemView.findViewById(R.id.textDuration);
            tvTitleInfoRecordVideo = (TextView) itemView.findViewById(R.id.tvTitleInfoRecordVideo);
            itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            );

        }
    }

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

}
