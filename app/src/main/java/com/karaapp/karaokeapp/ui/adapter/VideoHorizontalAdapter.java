package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.VideoMdl;

import java.util.List;

/**
 * Created com.karaapp.karaokeapp.ui.adapter on 5/13/2017.
 * Author: NgaNQ
 */
public class VideoHorizontalAdapter extends RecyclerView.Adapter<VideoHorizontalAdapter.VideoViewHolder> {
    public List<VideoMdl> mListVideo;
    private static OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_two_item, parent, false);
        return new VideoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoMdl mVideo = mListVideo.get(position);
        holder.txtTittle.setText(mVideo.getTitle());
        Glide.with(holder.imgVideo.getContext()).load(mVideo.getUrl()).into(holder.imgVideo);
        holder.txtDuration.setText("04:15");
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mListVideo.size();
    }

    public VideoHorizontalAdapter(List<VideoMdl> mListVideo) {
        this.mListVideo = mListVideo;


    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView imgVideo;
        TextView txtTittle;
        TextView txtDuration;

        public VideoViewHolder(final View itemView) {
            super(itemView);
            imgVideo = (ImageView) itemView.findViewById(R.id.image);
            txtTittle = (TextView) itemView.findViewById(R.id.title);
            txtDuration = (TextView) itemView.findViewById(R.id.txtdurations);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });


        }

    }
}
