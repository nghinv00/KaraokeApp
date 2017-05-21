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

import com.karaapp.karaokeapp.R;
import com.karaapp.karaokeapp.data.Resource;
import com.karaapp.karaokeapp.mdl.RecordVidMdl;
import com.karaapp.karaokeapp.ui.activity.MainActivity;
import com.karaapp.karaokeapp.ui.adapter.RecordVideoAdapter;

import java.util.ArrayList;
import java.util.List;


public class RecordListVideoFragment extends BackFragment {
    private RecordVideoAdapter mVideoAdapter;
    private List<RecordVidMdl> mVideos = new ArrayList<>();
    private MainActivity activity;
    private RecyclerView recyclerView;
    private RecordVideoAdapter recordVidmVideoseoAdapter;
    private BackFragment.BackPressLister backPressLister;

    public static final RecordListVideoFragment newInstance() {
        RecordListVideoFragment f = new RecordListVideoFragment();
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }
    public RecordListVideoFragment(BackFragment.BackPressLister backPressListener) {
        this.backPressLister = backPressListener;
    }
    public static final RecordListVideoFragment newInstance(BackFragment.BackPressLister
                                                              backPressListener) {
        RecordListVideoFragment f = new RecordListVideoFragment(backPressListener);
        Bundle bdl = new Bundle();
        f.setArguments(bdl);
        return f;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = (MainActivity) getActivity();
        if(mVideos.size() ==0){
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));
            mVideos.add(new RecordVidMdl("nJ31sMmytHU0","https://i.ytimg.com/vi/HQzu7NYlZNQ/sddefault.jpg","ĐẾM NGÀY XA EM -KARAOKE NHẠC TRẺ -HÁT KARAOKE ONLINE ","Thời gian: 30/04/2017 22:30:15","2.5","100","100","04:15"));

        }
    }

    public RecordListVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity.setTitle(Resource.getInstance(getContext()).getString(R.string.list_record_vid));
        activity.setImageDrawer(R.drawable.ic_arrow_back_black_24dp);
        activity.setClickDrawer(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.callFragment(SearchFragment.newInstance());
            }
        });
        View v=inflater.inflate(R.layout.fragment_record_video, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.rv_RecordVideo);
        mVideoAdapter = new RecordVideoAdapter(mVideos);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mVideoAdapter);
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

        mVideoAdapter.setOnItemCLickListener(new RecordVideoAdapter.OnItemCLickListener() {
            @Override
            public void OnItemClick(View itemView, int position) {
                RecordVidMdl mdl = mVideos.get(position);
                activity.callFragment(RecordVideoInfoFragment.newInstance(mdl.getIdVideoRecord(), mdl.getmTittle()));
            }
        });
        return v;
    }

}
