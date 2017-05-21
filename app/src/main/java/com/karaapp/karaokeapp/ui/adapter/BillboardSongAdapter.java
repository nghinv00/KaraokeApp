package com.karaapp.karaokeapp.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.login.widget.ProfilePictureView;
import com.karaapp.karaokeapp.mdl.BillboardSong;
import com.karaapp.karaokeapp.R;
import com.rockerhieu.emojicon.EmojiconEditText;
import com.rockerhieu.emojicon.EmojiconTextView;

import java.util.List;

/**
 * Created by Admin 88 on 4/26/2017.
 */

public class BillboardSongAdapter extends RecyclerView.Adapter<BillboardSongAdapter.BillboardSongHolder> {
    public List<BillboardSong> mListBillBoardSong;
    private static OnItemClickListener listener;
    private Context context;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public BillboardSongHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.billboard_adapter, parent, false);
        return new BillboardSongHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BillboardSongHolder holder, int position) {
        BillboardSong mSong = mListBillBoardSong.get(position);
        Glide.with(holder.urlImage.getContext()).load(mSong.getUrlImage()).into(holder.urlImage);
        holder.urlImage.setImageResource(R.drawable.bxhbaihat);
        holder.username.setText(mSong.getUsernameFB());
        holder.contentShare.setText(mSong.getContentShare());
        holder.tittle.setText(mSong.getTittle());
        holder.minuteShare.setText(mSong.getMinuteShare());
        holder.viewCount.setText(mSong.getCountSeen());
        holder.viewComment.setText(mSong.getCountComment());
        holder.viewShare.setText(mSong.getCountShare());
        holder.viewLike.setText(mSong.getCountLike());
        holder.numBillboard.setText(String.valueOf(position + 1));

        if (position == 0) {
            holder.imageBillboard.setImageResource(R.drawable.t1);
        } else if (position == 1) {
            holder.imageBillboard.setImageResource(R.drawable.t2);
        } else if (position == 2) {
            holder.imageBillboard.setImageResource(R.drawable.t3_tim);
        } else {
            holder.imageBillboard.setImageResource(R.drawable.t3);
        }
    }

    public BillboardSongAdapter(List<BillboardSong> mListBillBoardSong) {
        this.mListBillBoardSong = mListBillBoardSong;
    }

    @Override
    public int getItemCount() {
        return mListBillBoardSong.size();
    }

    public class BillboardSongHolder extends RecyclerView.ViewHolder {
        TextView username;
        EmojiconTextView contentShare;
        ImageView urlImage,imageBillboard;
        ProfilePictureView urlAvatar;
        TextView tittle;
        TextView minuteShare;
        TextView viewCount;
        TextView viewComment;
        TextView viewShare;
        TextView viewLike;
        TextView numBillboard;

        public BillboardSongHolder(final View itemView) {
            super(itemView);
            username = (TextView) itemView.findViewById(R.id.usernameFB);
            contentShare = (EmojiconTextView) itemView.findViewById(R.id.txtContentShare);
            urlImage = (ImageView) itemView.findViewById(R.id.imgVideo);
            tittle = (TextView) itemView.findViewById(R.id.tv_title);
            minuteShare = (TextView) itemView.findViewById(R.id.minuteShare);
            urlAvatar = (ProfilePictureView) itemView.findViewById(R.id.avatarFB);
            viewCount = (TextView) itemView.findViewById(R.id.viewCount);
            viewComment = (TextView) itemView.findViewById(R.id.viewComment);
            viewShare = (TextView) itemView.findViewById(R.id.viewShare);
            viewLike = (TextView) itemView.findViewById(R.id.viewLike);
            numBillboard = (TextView) itemView.findViewById(R.id.num);
            imageBillboard = (ImageView) itemView.findViewById(R.id.iv_rank);
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
