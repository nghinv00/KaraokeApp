package com.karaapp.karaokeapp.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 */
public class QuetionOneLevelFragment extends BackFragment {
    private MainActivity activity;
    private List<QuestionMdl> list = new ArrayList<>();
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;

    public QuetionOneLevelFragment() {
    }

    public static final QuetionOneLevelFragment newInstance() {
        QuetionOneLevelFragment f = new QuetionOneLevelFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if(list.size() ==0){
            list.add(new QuestionMdl(1, "Câu hỏi về App"));
            list.add(new QuestionMdl(2, "Làm sao để thu âm"));
            list.add(new QuestionMdl(3, "Làm sao để thu hình"));
            list.add(new QuestionMdl(4, "Câu hỏi về các chức năng khác"));
            list.add(new QuestionMdl(5, "...abc xyz"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_quetion_one_level, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.lvQuestion);

        questionAdapter = new QuestionAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                activity.callFragment(QuestionTwoLevelFragment.newInstance());
                return true;
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
                activity.callFragment(SearchFragment.newInstance());
            }
        });
        return v;
    }

}
