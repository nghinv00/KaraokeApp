package com.karaapp.karaokeapp.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.Mdl.GameAndApp;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.BxhDanhCaAdapter;
import com.karaapp.karaokeapp.ui.adapter.GameAndAppAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ThanhThuy on 4/05/2017.
 */
public class GameAndAppFragment extends BackFragment {

    private List<GameAndApp> gameAndAppsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GameAndAppAdapter gameAndAppAdapter;
    private MainActivity activity;

    public static GameAndAppFragment newInstance() {
        GameAndAppFragment fragment = new GameAndAppFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getContext();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_game_and_app, container, false);

        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());

            }
        });
        recyclerView = (RecyclerView) v.findViewById(R.id.gameandapp);

        gameAndAppAdapter = new GameAndAppAdapter(gameAndAppsList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gameAndAppAdapter);

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
        dataGame();
        return v;
    }

    private void dataGame() {
        GameAndApp gameAndApp = new GameAndApp(R.drawable.bingo, "Bingo Animals - Trò chơi giải trí dánh cho mọi lứa tuổi");
        gameAndAppsList.add(gameAndApp);
        gameAndApp = new GameAndApp(R.drawable.gemmy, "Gemmy Lands - FreePlay - Trò chơi Kim cương hay! hay!");
        gameAndAppsList.add(gameAndApp);
        gameAndApp = new GameAndApp(R.drawable.clash, "Clash Royhle - Trờ chơi Online số 1 thế giới kakaaka");
        gameAndAppsList.add(gameAndApp);
        gameAndApp = new GameAndApp(R.drawable.candy, "CandY Crush Jelly Saga - trò chơi giải trí hay nhất");
        gameAndAppsList.add(gameAndApp);
        gameAndApp = new GameAndApp(R.drawable.tital, "Titan Brawl - Đấy kỹ năng chiến lược của bạn đến giới hạn");
        gameAndAppsList.add(gameAndApp);
    }
}
