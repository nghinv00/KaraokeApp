package com.karaapp.karaokeapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.BxhDanhCa;
import com.karaapp.karaokeapp.mdl.QuestionMdl;

import java.util.List;

/**
 * Created com.karaapp.karaokeapp.ui.adapter on 5/3/2017.
 * Author: NgaNQ
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    List<QuestionMdl> iQuestionMdls;
    private static QuestionAdapter.OnItemClickListener listener;
    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public void setOnItemClickListener(QuestionAdapter.OnItemClickListener listener) {
        this.listener = listener;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_question_level_one, parent, false);
        return new QuestionAdapter.ViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        QuestionMdl questionMdl=iQuestionMdls.get(position);
        holder.number.setText(String.valueOf(questionMdl.getNumbers()));
        holder.text.setText(questionMdl.getQuestion());
    }

    @Override
    public int getItemCount() {
        return iQuestionMdls.size();
    }
    public QuestionAdapter(List<QuestionMdl> questionAdapter) {
        this.iQuestionMdls = questionAdapter;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView number;
        private TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.number);
            text = (TextView) itemView.findViewById(R.id.text);

        }
    }
}
