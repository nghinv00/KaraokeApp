package com.karaapp.karaokeapp.ui.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.ui.Mdl.DsYeuThich;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.DsYeuThichAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DsYeuThichFragment extends BackFragment{

    private List<DsYeuThich> dsYeuThichList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DsYeuThichAdapter dsYeuThichAdapter;
    private MainActivity activity;
    private ImageView iv_not_love;
    private static Activity context;

    public static DsYeuThichFragment newInstance() {
        DsYeuThichFragment fragment = new DsYeuThichFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public DsYeuThichFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getContext();

        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View v = inflater.inflate(R.layout.fragment_ds_yeu_thich, container, false);

        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());
            }
        });

        recyclerView = (RecyclerView) v.findViewById(R.id.dsyeuthich);
        dsYeuThichAdapter = new DsYeuThichAdapter(dsYeuThichList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        // recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(dsYeuThichAdapter);

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
        datalistlove();
        return v;


    }

    private void datalistlove(){
        if(dsYeuThichList.size() == 0){
            DsYeuThich dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.videotest, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.bxhbaihat, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.bxhbaihat, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
            dsYeuThich = new DsYeuThich(R.drawable.bxhbaihat, "4:18", "ĐÊM NGÀY XA EM -KARAOKE NHẠC TRẺ - HÁT KARAOKE ONLINE", "KARAOKE NHẠC TRẺ");
            dsYeuThichList.add(dsYeuThich);
        }
    }

}

