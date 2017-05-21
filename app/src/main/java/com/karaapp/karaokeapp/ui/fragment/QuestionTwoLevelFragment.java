package com.karaapp.karaokeapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.mdl.QuestionMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.QuestionAdapter;

import java.util.ArrayList;
import java.util.List;

public class QuestionTwoLevelFragment extends BackFragment {
    private List<QuestionMdl> list = new ArrayList<>();
    private AdapterView.OnItemClickListener onItemClick;
    private BackFragment.BackPressLister backPressListener;
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;

    private MainActivity activity;
    public QuestionTwoLevelFragment(BackFragment.BackPressLister backPressListener) {
        this.backPressListener=backPressListener;
    }

    public QuestionTwoLevelFragment(AdapterView.OnItemClickListener onItemClick, BackFragment.BackPressLister backPress) {
        this.onItemClick = onItemClick;
        this.backPressListener = backPress;
    }
    public QuestionTwoLevelFragment() {
    }
    public static QuestionTwoLevelFragment newInstance(BackFragment.BackPressLister backPressLister) {
        QuestionTwoLevelFragment f = new QuestionTwoLevelFragment(backPressLister);
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public static QuestionTwoLevelFragment newInstance() {

        QuestionTwoLevelFragment f = new QuestionTwoLevelFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if(list.size() ==0){
            list.add(new QuestionMdl(1, "sssjkksCâu hỏi về App"));
            list.add(new QuestionMdl(2, "ssssLàm sao để thu âm"));
            list.add(new QuestionMdl(3, "aaaLàm sao để thu hình"));
            list.add(new QuestionMdl(4, "aaaaaCâu hỏi về các chức năng khác"));
            list.add(new QuestionMdl(5, "...abc xyz"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_question_two_level, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.lv_question2);

        questionAdapter = new QuestionAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(QuetionOneLevelFragment.newInstance());
            }
        });
        return v;
    }

    @Override
    public void onBack() {
        super.onBack();
        backPressListener.onBack();
        activity.callFragment(QuetionOneLevelFragment.newInstance());
    }
}
