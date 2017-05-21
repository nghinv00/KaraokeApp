package com.karaapp.karaokeapp.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.Mdl.GameAndApp;

import java.util.List;


/**
 * Created by ThanhThuy on 05/05/2017.
 */

public class GameAndAppAdapter extends RecyclerView.Adapter<GameAndAppAdapter.MyViewHolder>{


    private List<GameAndApp> gameAndApps;

    public GameAndAppAdapter(List<GameAndApp> gameAndAppsList) {
        this.gameAndApps = gameAndAppsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_game, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        GameAndApp gameAndApp = gameAndApps.get(position);

        holder.icon.setImageResource(gameAndApp.getIcon());
        holder.title.setText(gameAndApp.getTitle());
    }

    @Override
    public int getItemCount() {
        return gameAndApps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView icon;
        public TextView title;

        public MyViewHolder(View itemView){
            super(itemView);

            icon = (ImageView) itemView.findViewById(R.id.ivgame);
            title = (TextView) itemView.findViewById(R.id.tvtitle);

        }
    }
}
