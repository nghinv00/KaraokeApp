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

import com.karaapp.karaokeapp.mdl.BxhDanhCa;
import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.BxhDanhCaAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BxhDanhCaFragment extends BackFragment {

    public static final BxhDanhCaFragment newInstance() {
        BxhDanhCaFragment f = new BxhDanhCaFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    public BxhDanhCaFragment() {
        // Required empty public constructor
    }

    public BxhDanhCaFragment(BackFragment.BackPressLister backPressListener) {
        this.backPressLister = backPressListener;
        setArguments(null);
    }

    private BackFragment.BackPressLister backPressLister;
    private List<BxhDanhCa> bxhDanhCaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BxhDanhCaAdapter bxhDanhCaAdapter;
    private MainActivity activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
    }

    public static final BxhDanhCaFragment newInstance(BackFragment.BackPressLister
                                                              backPressListener) {
        BxhDanhCaFragment f = new BxhDanhCaFragment(backPressListener);
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bxh_danh_ca, container, false);
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());

            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_bxhdanhCa);
        bxhDanhCaAdapter = new BxhDanhCaAdapter(bxhDanhCaList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bxhDanhCaAdapter);

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
        prepareBxbData();

        return v;
    }

    @Override
    public void onBack() {
        super.onBack();
        activity.callFragment(SearchFragment.newInstance());
    }



    private void prepareBxbData() {
        // bảng xếp hạng có 30 phần tử
        BxhDanhCa bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
        bxhDanhCa = new BxhDanhCa("Tên facebook", "Nội dung chia sẻ \uD83D\uDE18", "500k", "500k");
        bxhDanhCaList.add(bxhDanhCa);
    }
}
