package com.karaapp.karaokeapp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.login.widget.ProfilePictureView;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.Mdl.ITrangCaNhan;

import java.util.List;

/**
 * Created by ThanhThuy on 12/05/2017.
 */

public class TrangcanhanAdapter extends BaseAdapter{

    private List<ITrangCaNhan> itrangCaNhanList;
    private Context context;


    public TrangcanhanAdapter(Context context, List<ITrangCaNhan> itrangCaNhanList ) {
        this.context = context;
        this.itrangCaNhanList = itrangCaNhanList;

    }

    @Override
    public int getCount() {
        return itrangCaNhanList.size();
    }

    @Override
    public Object getItem(int position) {
        return itrangCaNhanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(context, R.layout.item_thong_ke, null);
            holder = new ViewHolder();
            holder.tvThuam = (TextView) convertView.findViewById(R.id.tvthu_am);
            holder.tvSoLuong = (TextView) convertView.findViewById(R.id.tvso_luong);
            holder.tvLike = (TextView) convertView.findViewById(R.id.tvlike);
            holder.tvShare = (TextView) convertView.findViewById(R.id.tvshare);
            holder.tvComment = (TextView) convertView.findViewById(R.id.tvcomment_tk);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ITrangCaNhan trangCaNhan = itrangCaNhanList.get(position);
        holder.tvThuam.setText(trangCaNhan.getThuam());
        holder.tvSoLuong.setText(trangCaNhan.getSoluong());
        holder.tvLike.setText(trangCaNhan.getLike());
        holder.tvShare.setText(trangCaNhan.getShare());
        holder.tvComment.setText(trangCaNhan.getComment());
        return convertView;
    }

    private class ViewHolder{
        private ProfilePictureView avatar_trangcanhan;
        private TextView tvUser;
        private TextView tvThuam;
        private TextView tvSoLuong;
        private TextView tvLike;
        private TextView tvShare;
        private TextView tvComment;
    }
}
