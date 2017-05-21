package com.karaapp.karaokeapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.VideoMdl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created com.karaapp.karaokeapp.ui.adapter on 5/12/2017.
 * Author: NgaNQ
 */

public class VideoPlayAdapter extends BaseAdapter {
    private List<VideoMdl> mListVideoPlayVideoMdls = new ArrayList<>();
    private Context context;

    @Override
    public int getCount() {
        return mListVideoPlayVideoMdls.size();
    }

    public VideoPlayAdapter(List<VideoMdl> mListVideoPlayVideoMdls, Context context) {
        this.mListVideoPlayVideoMdls = mListVideoPlayVideoMdls;
        this.context = context;
    }

    @Override
    public Object getItem(int position) {
        return mListVideoPlayVideoMdls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.list_item_video, null);
            holder = new ViewHolder();
            holder.imgVideo = (ImageView) convertView.findViewById(R.id.image);
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.duration = (TextView) convertView.findViewById(R.id.txtdurations);
        }
        VideoMdl videoPlayMdl = mListVideoPlayVideoMdls.get(position);
        holder.title.setText(videoPlayMdl.getTitle());
        holder.duration.setText(videoPlayMdl.getDurations());
        Glide.with(holder.imgVideo.getContext()).load(videoPlayMdl.getUrl()).into(holder.imgVideo);
        return convertView;
    }
    class ViewHolder {
        private ImageView imgVideo;
        private TextView title;
        private TextView duration;
    }
}
