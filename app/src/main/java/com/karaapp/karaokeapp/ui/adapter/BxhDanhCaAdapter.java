package com.karaapp.karaokeapp.ui.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.karaapp.karaokeapp.mdl.BxhDanhCa;
import com.karaapp.karaokeapp.R;

import java.util.List;

/**
 * Created by ThanhThuy on 24/04/2017.
 */

public class BxhDanhCaAdapter extends RecyclerView.Adapter<BxhDanhCaAdapter.MyViewHolder> {

    private List<BxhDanhCa> bxhDanhCasList;

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.bxh_danh_ca, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        BxhDanhCa bxhDanhCa = bxhDanhCasList.get(position);
        holder.tvTenface.setText(bxhDanhCa.getNameface());
        holder.tvnoidungchiase.setText(bxhDanhCa.getContent_share());
        holder.tvView.setText(bxhDanhCa.getDanhcaview());
        holder.tvComment.setText(bxhDanhCa.getDanhcacomment());

        if (position == 0) {
            holder.imagebxh.setImageResource(R.drawable.t1);
        } else if (position == 1) {
            holder.imagebxh.setImageResource(R.drawable.t2);
        } else if (position == 2) {
            holder.imagebxh.setImageResource(R.drawable.t3_tim);
        } else {
            holder.imagebxh.setImageResource(R.drawable.t3);
        }

        holder.sothutubxh.setText(Integer.toString(position + 1));
    }

    @Override
    public int getItemCount() {
        return bxhDanhCasList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ProfilePictureView avatarface;
        public TextView tvTenface, tvnoidungchiase;
        public TextView tvView, tvComment, sothutubxh;
        public ImageView imagebxh;

        public MyViewHolder(View itemView) {
            super(itemView);
            avatarface = (ProfilePictureView) itemView.findViewById(R.id.avata_bxhDanhCa);
            tvTenface = (TextView) itemView.findViewById(R.id.tvtenface);
            tvnoidungchiase = (TextView) itemView.findViewById(R.id.tvnoidungchiase);
            tvView = (TextView) itemView.findViewById(R.id.tvView);
            tvComment = (TextView) itemView.findViewById(R.id.tvComment);
            sothutubxh = (TextView) itemView.findViewById(R.id.num);
            imagebxh = (ImageView) itemView.findViewById(R.id.iv_rank);
        }
    }

    public BxhDanhCaAdapter(List<BxhDanhCa> bxhDanhCasList) {
        this.bxhDanhCasList = bxhDanhCasList;
    }
}
