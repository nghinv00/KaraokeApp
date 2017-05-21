package com.karaapp.karaokeapp.ui.adapter;

import android.app.Activity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuPopupHelper;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.Mdl.DsYeuThich;
import com.karaapp.karaokeapp.ui.fragment.DsYeuThichFragment;

import java.util.List;


/**
 * Created by ThanhThuy on 10/05/2017.
 */

public class DsYeuThichAdapter extends RecyclerView.Adapter<DsYeuThichAdapter.MyViewHolder> {

    private static Activity context = null;
    private List<DsYeuThich> dsYeuThichList;
    private DsYeuThichFragment dsYeuThichFragment;

    public DsYeuThichAdapter(List<DsYeuThich> dsYeuThichList) {
        this.dsYeuThichList = dsYeuThichList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_love, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        DsYeuThich dsYeuThich = dsYeuThichList.get(position);
        holder.imgVideo_love.setImageResource(dsYeuThich.getImgVideo());
        holder.tvtime.setText(dsYeuThich.getTimeVideo());
        holder.tv_title_love.setText(dsYeuThich.getTitlelove());
        holder.tv_the_loai_love.setText(dsYeuThich.getTheloai());

        holder.not_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(holder.not_love, position);
            }
        });
    }

    private void showPopupMenu( View view, int position ){
        PopupMenu popupMenu = new PopupMenu(view.getContext(),view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.not_love, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new MyMenuItemClickListener(position));
        popupMenu.show();

        MenuPopupHelper menuHelper = new MenuPopupHelper(view.getContext(), (MenuBuilder) popupMenu.getMenu(), view);
        menuHelper.setForceShowIcon(true);
        menuHelper.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener{

        private int position;
        public MyMenuItemClickListener(int position){
            this.position = position;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.item_not_love:

                    break;
                default:
            }
            return false;
        }
    }
    @Override
    public int getItemCount() {
        return dsYeuThichList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgVideo_love;
        public TextView tvtime;
        public TextView tv_title_love;
        public TextView tv_the_loai_love;
        public ImageView not_love;

        public MyViewHolder(View itemView) {
            super(itemView);

            imgVideo_love = (ImageView) itemView.findViewById(R.id.imgVideo_love);
            tvtime = (TextView) itemView.findViewById(R.id.tvtime);
            tv_title_love = (TextView) itemView.findViewById(R.id.tv_title_love);
            tv_the_loai_love = (TextView) itemView.findViewById(R.id.tv_the_loai_love);
            not_love = (ImageView) itemView.findViewById(R.id.iv_not_love);
        }
    }

}
